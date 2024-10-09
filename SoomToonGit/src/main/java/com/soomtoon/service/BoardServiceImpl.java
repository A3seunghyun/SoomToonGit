package com.soomtoon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.BoardDao;
import com.soomtoon.dto.BoardDto;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao bDao;

	@Override
	public ArrayList<BoardDto> boardAllList() {
		return bDao.getBoardAllSelect();
	}

}
