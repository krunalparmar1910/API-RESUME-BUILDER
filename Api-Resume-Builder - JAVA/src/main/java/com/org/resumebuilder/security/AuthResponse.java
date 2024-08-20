package com.org.resumebuilder.security;

public class AuthResponse {

	private final String baerer_token;

	public AuthResponse(String baerer_token) {
		this.baerer_token = baerer_token;
	}

	public String getBaererToken() {
		return baerer_token;
	}
}
