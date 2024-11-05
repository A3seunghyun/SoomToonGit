package com.soomtoon.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;
import com.soomtoon.dto.ChildCommentDto;
import com.soomtoon.dto.ChildCommentInsertDto;
import com.soomtoon.dto.CommentDetailDto;
import com.soomtoon.dto.CommentDto;

public interface BoardService {
	ArrayList<BoardDto> boardAllList();
	ArrayList<BoardDto> boardSearchList(String title, String userName, String webtoonName);
	ArrayList<BoardDto> boardDetail(int postIdx, HttpSession session);
	void boardInsert(BoardInsertDto dto);
	void boardDelete(int postIdx);
	void boardUpdate(int postIdx, int webtoonIdx, String postTitle, String postContent);
	void commentInsert(CommentDto dto);
	void childCommentInsert(ChildCommentInsertDto dto);
	ArrayList<CommentDetailDto> getBoardCommentSelect(int postIdx);
	ArrayList<ChildCommentDto> getChildCommentSelect(int postIdx);
}
