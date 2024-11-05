package com.soomtoon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.SoomtoonDao;
import com.soomtoon.dto.SoomtoonDto;

@Service
public class SoomtoonServiceImpl implements SoomtoonService {
	@Autowired
	SoomtoonDao dao;
	
	// 요일별 웹툰 게시물을 뽑아옴
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonList(String day_week) {
		return dao.getSoomtoonList(day_week);
	}

	// 요일별 웹툰의 수를 구함
	@Override
	public int getCountToon(String day_week) {
		return dao.getCountToon(day_week);
	}

	// 웹툰의 총 count를 구함
	@Override
	public int counToonAll() {
		return dao.counToonAll();
	}

	// 웹툰의 총 게시물을 뽑아옴 조회수 순으로
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonListAll() {
		return dao.getSoomtoonListAll();
	}

}
