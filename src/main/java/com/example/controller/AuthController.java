package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.dto.MemberRequestDto;
import com.example.controller.dto.MemberResponseDto;
import com.example.controller.dto.TokenDto;
import com.example.controller.dto.TokenRequestDto;
import com.example.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.signup(memberRequestDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.login(memberRequestDto));
	}
	
	@PostMapping("/reissue")
	public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
		return ResponseEntity.ok(authService.reissue(tokenRequestDto));
	}
}
