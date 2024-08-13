package com.org.resumebuilder.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_user")
public class LoginUser {
	@Id
	@SequenceGenerator(name = "USER_LOGIN_ID_GENERATOR", sequenceName = "USER_LOGIN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_LOGIN_ID_GENERATOR")
	private Long id;
	private String username;
	private String password;
	private String mobile;
	private String email;
	private Boolean isLoginUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsLoginUser() {
		return isLoginUser;
	}

	public void setIsLoginUser(Boolean isLoginUser) {
		this.isLoginUser = isLoginUser;
	}

}