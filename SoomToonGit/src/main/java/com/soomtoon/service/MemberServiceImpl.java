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

	@Override
	public MemberDto selectUserIdx(int user_idx) {
		return dao.selectUserIdx(user_idx);
	}

	@Override
	public void updateAlias(MemberDto dto) {
		dao.updateAlias(dto);
	}

	@Override
	public void acoountDelete(int user_idx) {
		dao.acoountDelete(user_idx);
	}
	
	
	@Override
	public boolean login(String id, String pw) {
		boolean login =  dao.login(id, pw);
		return login;
	}

	@Override
	public MemberDto userInfo(String id, String pw) {
		return dao.userInfo(id, pw);
	}
}
