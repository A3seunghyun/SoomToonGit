package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;
import com.soomtoon.dto.ChildCommentDto;
import com.soomtoon.dto.ChildCommentInsertDto;
import com.soomtoon.dto.CommentDetailDto;
import com.soomtoon.dto.CommentDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDto> getBoardAllSelect(){
		List<BoardDto> list = sqlSession.selectList("WebtoonMapper.PostBoardListAll");
		
		// List --> ArrayList 변환
		ArrayList<BoardDto> allList = new ArrayList<BoardDto>();
		allList.addAll(list);
		
		System.out.println("게시글 리스트 조회");
		
		return allList;
	}
	
	@Override
	public ArrayList<BoardDto> getBoardSearchSelect(String title, String userName, String webtoonName) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("title", title);
		hmap.put("userName", userName);
		hmap.put("webtoonName", webtoonName);
		
		List<BoardDto> list = sqlSession.selectList("PostBoardSearchList", hmap);
		
		ArrayList<BoardDto> searchList = new ArrayList<BoardDto>();
		searchList.addAll(list);
		
		return searchList;
	}

	@Override
	public ArrayList<BoardDto> getBoardDetailSelect(int postIdx, HttpSession session) {
		String viewKey = "viewed_" + postIdx;
		
	    // 세션에 조회 기록이 없을 때만 조회수 증가
	    if (session.getAttribute(viewKey) == null) {
	        sqlSession.update("WebtoonMapper.BoardViewCount", postIdx);
	        session.setAttribute(viewKey, true);
	    }
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("postIdx", postIdx);
		
		List<BoardDto> list =  sqlSession.selectList("WebtoonMapper.PostBoardDetail", hmap);
		
		ArrayList<BoardDto> boardDetail = new ArrayList<BoardDto>();
		boardDetail.addAll(list);
		
		
		return boardDetail;
	}

	@Override
	public void boardInsert(BoardInsertDto dto) {
		sqlSession.insert("WebtoonMapper.BoardInsert", dto);
	}

	@Override
	public void boardDelete(int postIdx) {
		sqlSession.delete("WebtoonMapper.BoardDelete", postIdx);
	}

	@Override
	public void boardUpdate(int postIdx, int webtoonIdx, String postTitle, String postContent) {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("postIdx", postIdx);
		hmap.put("webtoonIdx", webtoonIdx);
		hmap.put("postTitle", postTitle);
		hmap.put("postContent", postContent);
		
		sqlSession.update("WebtoonMapper.BoardEdit", hmap);
	}

	@Override
	public void commentInsert(CommentDto dto) {
		sqlSession.insert("WebtoonMapper.CommentInsert", dto);
	}

	@Override
	public ArrayList<CommentDetailDto> getBoardCommentSelect(int postIdx) {
		List<CommentDetailDto> list = sqlSession.selectList("WebtoonMapper.BoardComments", postIdx);
		
		// List --> ArrayList 변환
		ArrayList<CommentDetailDto> commentsList = new ArrayList<CommentDetailDto>();
		commentsList.addAll(list);
		
		System.out.println("게시글 댓글 리스트 조회");
		
		return commentsList;
	}

	@Override
	public ArrayList<ChildCommentDto> getChildCommentSelect(int postIdx) {
		List<ChildCommentDto> list = sqlSession.selectList("WebtoonMapper.ChildComments", postIdx);
		
		// List --> ArrayList 변환
		ArrayList<ChildCommentDto> childCommentsList = new ArrayList<ChildCommentDto>();
		childCommentsList.addAll(list);
		
		System.out.println("게시글 대댓글 리스트 조회");
		
		return childCommentsList;
	}

	@Override
	public void childCommentInsert(ChildCommentInsertDto dto) {
		sqlSession.insert("WebtoonMapper.ChildCommentInsert", dto);
	}

}
