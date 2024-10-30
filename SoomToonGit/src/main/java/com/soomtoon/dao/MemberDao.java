package com.soomtoon.dao;

import com.soomtoon.dto.MemberDto;

public interface MemberDao {
	
	// 회원정보 등록
	public void insertMember(MemberDto dto);
	
	// 중복 id 검색
	public int selectId(String id);
	
	// 로그인 처리
	public boolean login(String id, String pw);
	
	// 유저 정보
	MemberDto userInfo(String id, String pw);
}
