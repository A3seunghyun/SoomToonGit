package com.soomtoon.service;

import com.soomtoon.dto.MemberDto;

public interface MemberService {
	public void memberInsert(MemberDto dto);
	
	public int selectId(String id); //중복 id 검색
	
	public boolean login(String id, String pw); // 로그인
	
	MemberDto userInfo(String id, String pw); // 유저 정보
}
