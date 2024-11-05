package com.soomtoon.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	SqlSession session;
	
	@Override
	public void insertMember(MemberDto dto) {
		session.insert("Member.memberInsert", dto);
	}
	
	// 회원중복 체크
	@Override
    public int selectId(String id) {
        int count = session.selectOne("Member.selectId", id); // 1이면 아이디중복
        //System.out.println("selectId 결과: " + count); // 쿼리 결과 디버깅 출력
        return count;
	}
	 
	
	@Override
	public MemberDto selectUserIdx(int user_idx) {
		return session.selectOne("Member.userBno", user_idx);
	}
	
	// 닉네임 변경
	@Override
	public void updateAlias(MemberDto dto) {
		session.update("Member.updateAlias", dto);

	}
	
	// 계정 삭제
	@Override
	public void acoountDelete(int user_idx) {
		session.update("Member.deleteUser", user_idx);
	}
 

	// 로그인 - 승현
	@Override
	public boolean login(String id, String pw) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("id", id);
		hmap.put("pw", pw);
		
		int userCount = session.selectOne("Member.login", hmap);
		
		return userCount == 1;
	}
	
	// 유저 정보 - 승현
	@Override
	public MemberDto userInfo(String id, String pw) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("id", id);
		hmap.put("pw", pw);
		
		List<MemberDto> list = session.selectList("Member.userInfo", hmap);
		
		MemberDto dto = new MemberDto();
		dto= list.get(0);
		
		return dto;
	}
}
