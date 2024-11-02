package com.soomtoon.dto;

public class ChildCommentInsertDto {
	private int postIdx;
	private int commentIdx;
	private int userIdx;
	private String childContent;
	
	public ChildCommentInsertDto(int postIdx, int commentIdx, int userIdx, String childContent) {
		this.postIdx = postIdx;
		this.commentIdx = commentIdx;
		this.userIdx = userIdx;
		this.childContent = childContent;
	}

	public int getPostIdx() {
		return postIdx;
	}

	public void setPostIdx(int postIdx) {
		this.postIdx = postIdx;
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

	public String getChildContent() {
		return childContent;
	}

	public void setChildContent(String childContent) {
		this.childContent = childContent;
	}
	
}
