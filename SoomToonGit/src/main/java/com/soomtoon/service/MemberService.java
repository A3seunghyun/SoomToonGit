package com.soomtoon.service;

import com.soomtoon.dto.MemberDto;

public interface MemberService {
	public void memberInsert(MemberDto dto);
	public int selectId(String id); //중복 id 검색
}
