package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.SoomtoonDto;

@Repository
public class SoomtoonDaoImpl implements SoomtoonDao {
	@Autowired
	SqlSession sqlSession;
	
	// 요일별 웹툰 게시물을 뽑아옴
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonList(String day_week) {
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.toonList", day_week);
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}

	// 요일별 웹툰의 수를 구함
	@Override
	public int getCountToon(String day_week) {
		return sqlSession.selectOne("SoomtoonMapper.countToon", day_week);
	}

	// 웹툰의 총 count를 구함
	@Override
	public int counToonAll() {
		return sqlSession.selectOne("SoomtoonMapper.countToonAll");
	}

	// 웹툰의 총 게시물을 뽑아옵 조회수 순으로
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonListAll() {
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.toonListAll");
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}

}
