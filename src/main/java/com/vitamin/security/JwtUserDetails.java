package com.vitamin.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {
	
	private String username;
	private String token;
	private int id;
	private Collection<? extends GrantedAuthority> authorities;
	
	private static final long serialVersionUID = 1L;

	public JwtUserDetails(String username, int id, String token, List<GrantedAuthority> grantedAuthorities) {
		this.username = username;
		this.token = token;
		this.id = id;
		this.authorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return username;
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

	public String getToken() {
		return token;
	}

	public int getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
