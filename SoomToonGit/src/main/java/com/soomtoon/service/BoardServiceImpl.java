package com.soomtoon.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.BoardDao;
import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;
import com.soomtoon.dto.ChildCommentDto;
import com.soomtoon.dto.ChildCommentInsertDto;
import com.soomtoon.dto.CommentDetailDto;
import com.soomtoon.dto.CommentDto;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao bDao;

	@Override
	public ArrayList<BoardDto> boardAllList() {
		return bDao.getBoardAllSelect();
	}

	@Override
	public ArrayList<BoardDto> boardDetail(int postIdx, HttpSession session) {
		return bDao.getBoardDetailSelect(postIdx, session);
	}

	@Override
	public void boardInsert(BoardInsertDto dto) {
		bDao.boardInsert(dto);
	}

	@Override
	public void boardDelete(int postIdx) {
		bDao.boardDelete(postIdx);
	}

	@Override
	public void boardUpdate(int postIdx, int webtoonIdx, String postTitle, String postContent) {
		bDao.boardUpdate(postIdx, webtoonIdx, postTitle, postContent);
	}

	@Override
	public void commentInsert(CommentDto dto) {
		bDao.commentInsert(dto);
	}

	@Override
	public ArrayList<CommentDetailDto> getBoardCommentSelect(int postIdx) {
		return bDao.getBoardCommentSelect(postIdx);
	}

	@Override
	public ArrayList<ChildCommentDto> getChildCommentSelect(int postIdx) {
		return bDao.getChildCommentSelect(postIdx);
	}

	@Override
	public void childCommentInsert(ChildCommentInsertDto dto) {
		bDao.childCommentInsert(dto);
	}


}
