package com.soomtoon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.BoardDao;
import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao bDao;

	@Override
	public ArrayList<BoardDto> boardAllList() {
		return bDao.getBoardAllSelect();
	}

	@Override
	public ArrayList<BoardDto> boardDetail(int postIdx) {
		return bDao.getBoardDetailSelect(postIdx);
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


}
