package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.dto.MemberResponseDto;
import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	private final MemberService memberService;
	
	@GetMapping("/me")
	public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
		return ResponseEntity.ok(memberService.getMyInfo());
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email) {
		return ResponseEntity.ok(memberService.getMemberInfo(email));
	}
}
