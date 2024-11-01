package com.soomtoon.dto;

public class BoardInsertDto {
	private int webtoonIdx;
	private String userIdx;
	private String postTitle;
	private String postContent;
	
	public BoardInsertDto(int webtoonIdx, String userIdx, String postTitle, String postContent) {
		this.webtoonIdx = webtoonIdx;
		this.userIdx = userIdx;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	public int getWebtoonIdx() {
		return webtoonIdx;
	}

	public void setWebtoonIdx(int webtoonIdx) {
		this.webtoonIdx = webtoonIdx;
	}

	public String getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	
}
