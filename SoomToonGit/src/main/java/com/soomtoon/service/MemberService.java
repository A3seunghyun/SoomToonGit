package com.soomtoon.service;

import com.soomtoon.dto.MemberDto;

public interface MemberService {
	public void memberInsert(MemberDto dto);	// 회원가입
	
	public int selectId(String id); 			//중복 id 검색
	
	public MemberDto selectUserIdx(int user_idx); // 닉네임 변경할 user_idx

	public void updateAlias(MemberDto dto);      // 닉네임 변경
	
	public void acoountDelete(int user_idx);	// 계정 삭제
	
	public boolean login(String id, String pw); // 로그인
	
//	MemberDto userInfo(String id, String pw); // 유저 정보
	
	MemberDto userInfo(String id); // 유저 정보  복호화 위함
	
	public void postDelete(int user_idx);		// 계정삭제시 작성된 포스트,댓글 삭제 (댓글은 오라클 종속삭제)
}
