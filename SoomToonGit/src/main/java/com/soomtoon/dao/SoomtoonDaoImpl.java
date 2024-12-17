package com.soomtoon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soomtoon.dto.SoomtoonDto;

@Repository
public class SoomtoonDaoImpl implements SoomtoonDao {
	@Autowired
	SqlSession sqlSession;
	
	// 요일별 웹툰 게시물을 뽑아옴
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonList(String day_week) {
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.toonList", day_week);
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}

	// 요일별 웹툰의 수를 구함
	@Override
	public int getCountToon(String day_week) {
		return sqlSession.selectOne("SoomtoonMapper.countToon", day_week);
	}

	// 웹툰의 총 count를 구함
	@Override
	public int counToonAll() {
		return sqlSession.selectOne("SoomtoonMapper.countToonAll");
	}

	// 웹툰의 총 게시물을 뽑아옵 조회수 순으로
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonListAll() {
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.toonListAll");
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}
	
	// 채팅창 웹툰 검색
	@Override
	public ArrayList<SoomtoonDto> searchToonList(String toonName) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("toonName", toonName);
		
		List<SoomtoonDto> list = sqlSession.selectList("SoomtoonMapper.searchToonList", hmap);
		ArrayList<SoomtoonDto> listRet = new ArrayList<SoomtoonDto>();
		listRet.addAll(list);
		return listRet;
	}

	// 웹툰 찜 insert
	@Override
	public boolean toonZzim(int webtoon_idx, int user_idx) {
		Map<String, Object>	params = new HashMap<>();
			// 문자열, object (object: 어떤 데이터 타입이든 저장할 수 있음) ex, Integer, String, boolean 등
		
		// sqlsSession.insert, select, update, delete() 메서드는 매개변수를 여러개 받을수 없기 떄문에 Map 객체나 Dto객체에 담아서 넘겨햐함
		params.put("webtoon_idx", webtoon_idx);
		params.put("user_idx", user_idx);
		
		Integer checkZzim = sqlSession.selectOne("SoomtoonMapper.checkZzim", params);
		
		if(checkZzim != null && checkZzim > 0) {
			return false;
			// 이미 찜이면 false
		} 
		
		return sqlSession.insert("SoomtoonMapper.toonZzim",params) > 0;
	}

	
	// 로그인한 유저의 찜 목록
	@Override
	public List<SoomtoonDto> getFavoriteWebtoons(String userId) {
		return sqlSession.selectList("SoomtoonMapper.getFavoriteWebtoons",userId);
	}

	// 웹툰 찜 해제
	@Override
	public boolean deleteZzim(int webtoon_idx, int user_idx) {
		Map<String, Object> params = new HashMap<>();
		params.put("webtoon_idx", webtoon_idx);
		params.put("user_idx", user_idx);
		
		int deleted = sqlSession.delete("SoomtoonMapper.deleteZzim", params);
		return deleted > 0;
	}

	// 로그인한 유저의 찜한 웹툰의 수 카운트
	@Override
	public int zzimCount(int user_idx) {
		return sqlSession.selectOne("SoomtoonMapper.zzimCount", user_idx);
	}

}
