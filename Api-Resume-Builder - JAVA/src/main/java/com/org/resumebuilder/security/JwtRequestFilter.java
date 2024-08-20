package com.org.resumebuilder.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Configuration
public class JwtRequestFilter extends OncePerRequestFilter {

	private final UserService userService;
	private final JwtTokenUtil jwtTokenUtil;
	private final TokenBlacklistService tokenBlacklistService;

	public JwtRequestFilter(UserService userService, JwtTokenUtil jwtTokenUtil,
			TokenBlacklistService tokenBlacklistService) {
		this.userService = userService;
		this.jwtTokenUtil = jwtTokenUtil;
		this.tokenBlacklistService = tokenBlacklistService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Ignore Authentication while Register & Login
		String requestURI = request.getRequestURI();
		if (requestURI.equals("/api/auth/login") || requestURI.equals("/api/auth/register")) {
			filterChain.doFilter(request, response);
			return;
		}

		final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			if (tokenBlacklistService.isTokenBlacklisted(jwt)) {
				filterChain.doFilter(request, response);
				return;
			}
			username = jwtTokenUtil.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
