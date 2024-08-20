package com.org.resumebuilder.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.resumebuilder.exception.UserAlreadyExistsException;
import com.org.resumebuilder.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public LoginUser registerUser(LoginUser user) {
		// Check if a user with the same mobile number, email, or username already exist
		if (userRepository.existsByMobile(user.getMobile())) {
			throw new UserAlreadyExistsException("A user with this mobile number already exists.");
		} else if (userRepository.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("A user with this email already exists.");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password and set user status
		user.setIsLoginUser(true);
		userRepository.save(user); // Save the new user
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Search By Username, mobile, or email
		Optional<LoginUser> userOptional = userRepository.findByUsername(username);
		if (userOptional.isEmpty()) {
			userOptional = userRepository.findByEmail(username);
		}
		LoginUser user = userOptional
				.orElseThrow(() -> new UsernameNotFoundException("User not found with: " + username));
		// Check if the user is allowed to log in(allow for only boolean = true users)
		if (!user.getIsLoginUser()) {
			throw new RuntimeException("User is not permitted to log in. Please contact support.");
		} else {
			return new User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
		}
	}

}
