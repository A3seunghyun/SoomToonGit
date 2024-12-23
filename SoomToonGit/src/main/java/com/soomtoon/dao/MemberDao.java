package com.soomtoon.dao;

import com.soomtoon.dto.MemberDto;

public interface MemberDao {
	
	// 회원정보 등록
	public void insertMember(MemberDto dto);
	
	// 중복 id 검색
	public int selectId(String id);
	
	// 닉네임 변경할 user_idx
	public MemberDto selectUserIdx(int user_idx);
	
	// 닉네임 변경
	public void updateAlias(MemberDto dto);
	
	// 계정 삭제
	public void acoountDelete(int user_idx);
	
	// 로그인 처리
	public boolean login(String id, String pw); 
	
	// 유저 정보
//	MemberDto userInfo(String id, String pw);
	
	// 유저 정보 복호화 위함
	MemberDto userInfo(String id);
	
	// 계정삭제시 작성된 포스트,댓글 삭제 (댓글은 오라클 종속삭제)
	public void postDelete(int user_idx);
	
}
