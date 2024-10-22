package com.soomtoon.dao;

import com.soomtoon.dto.MemberDto;

public interface MemberDao {
	
	// 회원정보 등록
	public void insertMember(MemberDto dto);
	
	// 중복 id 검색
	public int selectId(String id);	
}
