package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;

public interface BoardDao {
	ArrayList<BoardDto> getBoardAllSelect();
	ArrayList<BoardDto> getBoardDetailSelect(int postIdx);
	void boardInsert(BoardInsertDto dto);
}
