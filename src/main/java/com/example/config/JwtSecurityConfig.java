package com.example.config;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwt.JwtFilter;
import com.example.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	private final TokenProvider tokenProvider;
	
	@Override
	public void configure(HttpSecurity http) {
		JwtFilter customeFilter = new JwtFilter(tokenProvider);
		http.addFilterBefore(customeFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
