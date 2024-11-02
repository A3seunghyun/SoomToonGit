package com.soomtoon.dto;

public class CommentDetailDto {
	private int commentIdx;
	private int postIdx;
	private int userIdx;
	private String userName;
	private String content;
	private String commentDate;
	
	public CommentDetailDto(int commentIdx, int postIdx, int userIdx, String userName, String content,
			String commentDate) {
		this.commentIdx = commentIdx;
		this.postIdx = postIdx;
		this.userIdx = userIdx;
		this.userName = userName;
		this.content = content;
		this.commentDate = commentDate;
	}

	public int getCommentIdx() {
		return commentIdx;
	}

	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
}
