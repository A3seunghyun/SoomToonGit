package com.soomtoon.dto;

public class BoardDto {
	private int postIdx;
	private int webtoonIdx;
	private String webtoonName;
	private String userName;
	private String title;
	private String postContent;
	private String postDate;
	private int postView;
	
	public BoardDto(int postIdx, int webtoonIdx, String webtoonName, String userName, String title, String postContent,
			String postDate, int postView) {
		this.postIdx = postIdx;
		this.webtoonIdx = webtoonIdx;
		this.webtoonName = webtoonName;
		this.userName = userName;
		this.title = title;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postView = postView;
	}

	public int getPostIdx() {
		return postIdx;
	}

	public void setPostIdx(int postIdx) {
		this.postIdx = postIdx;
	}

	public int getWebtoonIdx() {
		return webtoonIdx;
	}

	public void setWebtoonIdx(int webtoonIdx) {
		this.webtoonIdx = webtoonIdx;
	}

	public String getWebtoonName() {
		return webtoonName;
	}

	public void setWebtoonName(String webtoonName) {
		this.webtoonName = webtoonName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getPostView() {
		return postView;
	}

	public void setPostView(int postView) {
		this.postView = postView;
	}
	
}
