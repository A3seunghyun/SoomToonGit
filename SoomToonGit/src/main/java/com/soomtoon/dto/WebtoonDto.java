package com.soomtoon.dto;

public class WebtoonDto {
	private int webtoonIdx;
	private String webtoonName;
	private String webtoonImg;
	private int dayWeek;
	private String webtoonAuthor;
	private String webtoonGenre;
	private int webtoonView;
	
	public WebtoonDto(int webtoonIdx, String webtoonName, String webtoonImg, int dayWeek, String webtoonAuthor,
			String webtoonGenre, int webtoonView) {
		this.webtoonIdx = webtoonIdx;
		this.webtoonName = webtoonName;
		this.webtoonImg = webtoonImg;
		this.dayWeek = dayWeek;
		this.webtoonAuthor = webtoonAuthor;
		this.webtoonGenre = webtoonGenre;
		this.webtoonView = webtoonView;
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

	public String getWebtoonImg() {
		return webtoonImg;
	}

	public void setWebtoonImg(String webtoonImg) {
		this.webtoonImg = webtoonImg;
	}

	public int getDayWeek() {
		return dayWeek;
	}

	public void setDayWeek(int dayWeek) {
		this.dayWeek = dayWeek;
	}

	public String getWebtoonAuthor() {
		return webtoonAuthor;
	}

	public void setWebtoonAuthor(String webtoonAuthor) {
		this.webtoonAuthor = webtoonAuthor;
	}

	public String getWebtoonGenre() {
		return webtoonGenre;
	}

	public void setWebtoonGenre(String webtoonGenre) {
		this.webtoonGenre = webtoonGenre;
	}

	public int getWebtoonView() {
		return webtoonView;
	}

	public void setWebtoonView(int webtoonView) {
		this.webtoonView = webtoonView;
	}
	
}
