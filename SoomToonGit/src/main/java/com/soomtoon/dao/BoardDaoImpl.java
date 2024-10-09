package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDto> getBoardAllSelect(){
		List<BoardDto> list = sqlSession.selectList("PostBoardMapper.PostBoardListAll");
		System.out.println("게시글 리스트 조회");
		
		// List --> ArrayList 변환
		
		ArrayList<BoardDto> allList = new ArrayList<BoardDto>();
		allList.addAll(list);
		return allList;
	}


}
