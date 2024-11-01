package com.soomtoon.service;

import java.util.ArrayList;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;

public interface BoardService {
	ArrayList<BoardDto> boardAllList();
	ArrayList<BoardDto> boardDetail(int postIdx);
	void boardInsert(BoardInsertDto dto);
	void boardDelete(int postIdx);
	void boardUpdate(int postIdx, int webtoonIdx, String postTitle, String postContent);
}
