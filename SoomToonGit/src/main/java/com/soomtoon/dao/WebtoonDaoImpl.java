package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

@Repository
public class WebtoonDaoImpl implements WebtoonDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<WebtoonDto> getWebtoonDetailSelect(int webtoonIdx) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("webtoonIdx", webtoonIdx);
		
		List<WebtoonDto> list = sqlSession.selectList("WebtoonMapper.WebtoonDetail", hmap);
		
		ArrayList<WebtoonDto> webtoonDetail = new ArrayList<WebtoonDto>();
		webtoonDetail.addAll(list);
		
		return webtoonDetail;
	}

	@Override
	public ArrayList<BoardDto> getWebtoobBoardListSelect(int webtoonIdx) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("webtoonIdx", webtoonIdx);
		
		List<BoardDto> list = sqlSession.selectList("WebtoonMapper.WebtoonBoardList", hmap);
		
		ArrayList<BoardDto> webtoonBoardList = new ArrayList<BoardDto>();
		
		webtoonBoardList.addAll(list);
		return webtoonBoardList;
	}
	
}
