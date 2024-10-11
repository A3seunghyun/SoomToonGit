package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

public interface BoardDao {
	ArrayList<BoardDto> getBoardAllSelect();
	ArrayList<BoardDto> getBoardDetailSelect(int postIdx);
}
