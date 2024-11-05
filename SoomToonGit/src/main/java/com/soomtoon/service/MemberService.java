package com.soomtoon.service;

import com.soomtoon.dto.MemberDto;

public interface MemberService {
	public void memberInsert(MemberDto dto);	// 회원가입
	
	public int selectId(String id); 			//중복 id 검색
	
	public MemberDto selectUserIdx(int user_idx); // 닉네임 변경할 user_idx

	public void updateAlias(MemberDto dto);      // 닉네임 변경
	
	public void acoountDelete(int user_idx);	// 계정 삭제
	
	public boolean login(String id, String pw); // 로그인
	
	MemberDto userInfo(String id, String pw); // 유저 정보
}
