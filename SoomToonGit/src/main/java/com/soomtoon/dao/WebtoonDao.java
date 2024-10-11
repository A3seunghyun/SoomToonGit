package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

public interface WebtoonDao {
	ArrayList<WebtoonDto> getWebtoonDetailSelect(int webtoonIdx);
	ArrayList<BoardDto> getWebtoobBoardListSelect(int webtoonIdx);
}
