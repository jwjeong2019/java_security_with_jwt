package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.dto.MemberResponseDto;
import com.example.repository.MemberRepository;
import com.example.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	@Transactional(readOnly = true)
	public MemberResponseDto getMemberInfo(String email) {
		return memberRepository.findByEmail(email)
				.map(MemberResponseDto::of)
				.orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
	}
	
	@Transactional(readOnly = true)
	public MemberResponseDto getMyInfo() {
		return memberRepository.findById(SecurityUtil.getCurrentMemberId())
				.map(MemberResponseDto::of)
				.orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
	}
}
