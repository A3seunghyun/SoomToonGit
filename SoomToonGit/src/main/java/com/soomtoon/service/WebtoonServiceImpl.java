package com.soomtoon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.WebtoonDao;
import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

@Service
public class WebtoonServiceImpl implements WebtoonService{
	@Autowired
	private WebtoonDao wDao;
	
	@Override
	public ArrayList<WebtoonDto> webtoonDetail(int webtoonIdx) {
		return wDao.getWebtoonDetailSelect(webtoonIdx);
	}

	@Override
	public ArrayList<BoardDto> webtoonBoardList(int webtoonIdx) {
		return wDao.getWebtoobBoardListSelect(webtoonIdx);
	}

}
