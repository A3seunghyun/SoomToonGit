package com.soomtoon.dto;

public class CommentDto {
	private int postIdx;
	private int userIdx;
	private String content;
	
	public CommentDto(int postIdx, int userIdx, String content) {
		this.postIdx = postIdx;
		this.userIdx = userIdx;
		this.content = content;
	}

	public int getPostIdx() {
		return postIdx;
	}

	public void setPostIdx(int postIdx) {
		this.postIdx = postIdx;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
