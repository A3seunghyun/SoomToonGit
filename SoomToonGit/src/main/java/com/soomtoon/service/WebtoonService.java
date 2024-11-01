package com.soomtoon.service;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

public interface WebtoonService {
	ArrayList<WebtoonDto> webtoonDetail(int webtoonIdx);
	ArrayList<BoardDto> webtoonBoardList(int webtoonIdx);
	ArrayList<WebtoonDto> getWebtoonSearchSelect(String webtoonName);
}
