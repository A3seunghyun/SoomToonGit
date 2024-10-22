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
	
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonList(String day_week) {
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.toonList", day_week);
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}

}
