package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	// 채팅창 웹툰 검색
	ArrayList<SoomtoonDto> searchToonList(String toonName);
	
	// 웹툰 찜
	public boolean toonZzim(int webtoon_idx, int user_idx);
	
	// 웹툰 찜 해제
	public boolean deleteZzim(int webtoon_idx, int user_idx);
	
	// 유저의 웹툰 찜 목록
	List<SoomtoonDto> getFavoriteWebtoons(String userId);
	
	// 찜 총  count
	public int zzimCount(int user_idx);
	
	
}
