package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		// List --> ArrayList 변환
		ArrayList<BoardDto> allList = new ArrayList<BoardDto>();
		allList.addAll(list);
		
		System.out.println("게시글 리스트 조회");
		
		return allList;
	}

	@Override
	public ArrayList<BoardDto> getBoardDetailSelect(int postIdx) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("postIdx", postIdx);
		
		List<BoardDto> list =  sqlSession.selectList("PostBoardMapper.PostBoardDetail", hmap);
		
		ArrayList<BoardDto> boardDetail = new ArrayList<BoardDto>();
		boardDetail.addAll(list);
		
		
		return boardDetail;
	}


}
