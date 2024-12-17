package com.soomtoon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 웹툰 검색
	@Override
	public ArrayList<SoomtoonDto> searchToonList(String toonName) {
		return dao.searchToonList(toonName);
	}

	
	// 웹툰 찜 insert
	@Override
	public boolean toonZzim(int webtoon_idx, int user_idx) {
		return dao.toonZzim(webtoon_idx, user_idx);
	}
	
	// 로그인한 유저의 찜 여부 확인
	@Override
	public Map<Integer, Boolean> getFavoriteWebtoons(String userId) {
		List<SoomtoonDto> favoriteList = dao.getFavoriteWebtoons(userId);
		Map<Integer, Boolean> favoriteMap = new HashMap<>();
		
		for(SoomtoonDto dto : favoriteList) {
			favoriteMap.put(dto.getWebToon_idx(), true);
		}
		return favoriteMap;
	}
	
	// 유저의 웹툰 찜 목록 확인
	@Override
	public List<SoomtoonDto> getFavoriteWebtoonsList(String userId) {
		List<SoomtoonDto> favoriteList = dao.getFavoriteWebtoons(userId);
		return favoriteList;
	}
	
	// 찜 삭제
	@Override
	public boolean deleteZzim(int webtoon_idx, int user_idx) {
		return dao.deleteZzim(webtoon_idx, user_idx);
	}

	// 유저의 찜 count
	@Override
	public int zzimCount(int user_idx) {
		return dao.zzimCount(user_idx);
	}

}
