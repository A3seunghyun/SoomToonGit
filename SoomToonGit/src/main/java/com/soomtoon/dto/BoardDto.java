package com.soomtoon.dto;

public class BoardDto {
	private int postIdx;
	private int webtoonIdx;
	private String webtoonName;
	private String userId;
	private String userName;
	private String title;
	private String postContent;
	private String postDate;
	private int postView;
	private int commentCount;
	private int childCommentCount;
	
	public BoardDto(int postIdx, int webtoonIdx, String webtoonName, String userId, String userName, String title,
			String postContent, String postDate, int postView, int commentCount, int childCommentCount) {
		this.postIdx = postIdx;
		this.webtoonIdx = webtoonIdx;
		this.webtoonName = webtoonName;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postView = postView;
		this.commentCount = commentCount;
		this.childCommentCount = childCommentCount;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getChildCommentCount() {
		return childCommentCount;
	}

	public void setChildCommentCount(int childCommentCount) {
		this.childCommentCount = childCommentCount;
	}
	
}
