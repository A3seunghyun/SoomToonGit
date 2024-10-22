package com.soomtoon.dto;

public class MemberDto {
	private int user_idx;  
	private String alias;
	private String id;
	private String name;
	private String pw;
	private String jumin1;
	private String jumin2;
	
//	private int jumin2  주민 뒷번호 컬럼 추가해야할듯;
	
	public MemberDto() {}

	public MemberDto(int user_idx, String alias, String id, String name, String pw, String jumin1, String jumin2) {
		super();
		this.user_idx = user_idx;
		this.alias = alias;
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getJumin1() {
		return jumin1;
	}
	
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	
	public String getJumin2() {
		return jumin2;
	}
	
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	
	@Override
	public String toString() {
		return "MemberDto [user_idx=" + user_idx + ", alias=" + alias + ", id=" + id + ", name=" + name + ", pw=" + pw
				+ ", jumin1=" + jumin1 + ", jumin2=" + jumin2 + "]";
	};
	
}
