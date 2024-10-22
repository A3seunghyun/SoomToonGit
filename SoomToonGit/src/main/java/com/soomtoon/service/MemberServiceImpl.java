package com.soomtoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.MemberDao;
import com.soomtoon.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;

	@Override
	public void memberInsert(MemberDto dto) {
		 dao.insertMember(dto);
	}

	@Override
	public int selectId(String id) {
		int result =  dao.selectId(id); // 1이면 중복
		return result;
	}
}
