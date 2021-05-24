package com.mindtree.librarymanagementsystem.security.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mindtree.librarymanagementsystem.modules.user.entity.User;

/**
 * @author M1049006
 *
 */
public class LMSUserDetail implements UserDetails {

	private static final long serialVersionUID = 8441413930620719540L;
	private Long userId;
	private String username;
	private String emailId;
	private String password;
	private String fullName;
	private Collection<? extends GrantedAuthority> authorities;

	public LMSUserDetail() {
	}

	public LMSUserDetail(User user) {
		this.fullName = user.getFullName();
		this.userId = user.getUserId();
		this.username = user.getUserName();
		this.emailId = user.getEmailId();
		this.password = user.getPassword();
		this.authorities = user.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
