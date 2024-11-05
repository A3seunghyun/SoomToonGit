package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.SoomtoonDto;

public interface SoomtoonDao {
	// 요일별 웹툰을 뽑아옴
	ArrayList<SoomtoonDto> getSoomtoonList(String day_week);
	
	// 요일별 웹툰의 수
	public int getCountToon(String day_week);
	
	// 전체 웹툰 게시물 조회수 순으로
	ArrayList<SoomtoonDto> getSoomtoonListAll();
	
	// 웹툰의 총 count
	public int counToonAll();
}
