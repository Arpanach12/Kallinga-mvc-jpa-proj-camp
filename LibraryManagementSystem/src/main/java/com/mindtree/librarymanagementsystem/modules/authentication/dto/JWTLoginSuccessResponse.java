package com.mindtree.librarymanagementsystem.modules.authentication.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author M1049006
 *
 */
public class JWTLoginSuccessResponse {

	private String token;
	private String type = "Bearer";
	private String username;
	private Long userId;
	private Collection<? extends GrantedAuthority> authorities;

	public JWTLoginSuccessResponse() {
	}

	public JWTLoginSuccessResponse(String token, String username, Collection<? extends GrantedAuthority> authorities,Long userId) {
		this.token = token;
		this.username = username;
		this.authorities = authorities;
		this.userId=userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
