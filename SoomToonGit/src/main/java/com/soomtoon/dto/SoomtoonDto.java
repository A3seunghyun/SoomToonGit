package com.soomtoon.dto;

public class SoomtoonDto {
	private int webToon_idx;
	private String toon_name;
	private String toon_img;
	private String day_week;
	private String toon_author;
	private String toon_genre;
	private boolean favorite;   //찜 기능을 위해 추가
	
	
	public SoomtoonDto() {
		super();
	}
	public SoomtoonDto(int webToon_idx, String toon_name, String toon_img, String day_week, String toon_author,
			String toon_genre, boolean favorite) {
		super();
		this.webToon_idx = webToon_idx;
		this.toon_name = toon_name;
		this.toon_img = toon_img;
		this.day_week = day_week;
		this.toon_author = toon_author;
		this.toon_genre = toon_genre;
		this.favorite = favorite;
	}
	
	public int getWebToon_idx() {
		return webToon_idx;
	}
	public void setWebToon_idx(int webToon_idx) {
		this.webToon_idx = webToon_idx;
	}
	public String getToon_name() {
		return toon_name;
	}
	public void setToon_name(String toon_name) {
		this.toon_name = toon_name;
	}
	public String getToon_img() {
		return toon_img;
	}
	public void setToon_img(String toon_img) {
		this.toon_img = toon_img;
	}
	public String getDay_week() {
		return day_week;
	}
	public void setDay_week(String day_week) {
		this.day_week = day_week;
	}
	public String getToon_author() {
		return toon_author;
	}
	public void setToon_author(String toon_author) {
		this.toon_author = toon_author;
	}
	public String getToon_genre() {
		return toon_genre;
	}
	public void setToon_genre(String toon_genre) {
		this.toon_genre = toon_genre;
	}
	public boolean isFavorite() {
		return favorite;
	}
	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	@Override
	public String toString() {
		return "SoomtoonDto [webToon_idx=" + webToon_idx + ", toon_name=" + toon_name + ", toon_img=" + toon_img
				+ ", day_week=" + day_week + ", toon_author=" + toon_author + ", toon_genre=" + toon_genre
				+ ", favorite=" + favorite + "]";
	}

	
	
	
	
}
