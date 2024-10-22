package com.soomtoon.dao;

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
}
