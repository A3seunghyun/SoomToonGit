package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;

public interface BoardDao {
	ArrayList<BoardDto> getBoardAllSelect();
	ArrayList<BoardDto> getBoardDetailSelect(int postIdx);
}
