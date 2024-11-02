package com.soomtoon.dto;

public class ChildCommentDto {
	private int childCommentIdx;
	private int commentIdx;
	private int userIdx;
	private String userName;
	private String childContent;
	private String childCommentDate;
	private int postIdx;
	
	public ChildCommentDto(int childCommentIdx, int commentIdx, int userIdx, String userName, String childContent,
			String childCommentDate, int postIdx) {
		this.childCommentIdx = childCommentIdx;
		this.commentIdx = commentIdx;
		this.userIdx = userIdx;
		this.userName = userName;
		this.childContent = childContent;
		this.childCommentDate = childCommentDate;
		this.postIdx = postIdx;
	}

	public int getChildCommentIdx() {
		return childCommentIdx;
	}

	public void setChildCommentIdx(int childCommentIdx) {
		this.childCommentIdx = childCommentIdx;
	}

	public int getCommentIdx() {
		return commentIdx;
	}

	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
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

	public String getChildContent() {
		return childContent;
	}

	public void setChildContent(String childContent) {
		this.childContent = childContent;
	}

	public String getChildCommentDate() {
		return childCommentDate;
	}

	public void setChildCommentDate(String childCommentDate) {
		this.childCommentDate = childCommentDate;
	}

	public int getPostIdx() {
		return postIdx;
	}

	public void setPostIdx(int postIdx) {
		this.postIdx = postIdx;
	}
	
}
