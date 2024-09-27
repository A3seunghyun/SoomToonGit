package com.soomtoon.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/webtoonContent")
	public String webtoonContent() {
		return "webtoon_content";
	}
	
	@RequestMapping("/freeBulletinBoard")
	public String freebulletinboard() {
		return "free_bulletin_board";
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail() {
		return "board_detail";
	}
	
	@RequestMapping("/writePost")
	public String writePost() {
		return "write_post";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
// 용준
	// 계정정보
	@RequestMapping("/")
	public String account_infor(Model model) {
		System.out.println("계정정보 페이지 들어옴");
		
		return "account_infor";
	}
	
	// 프로필 수정
	@RequestMapping("/profile_update")
	public String profile_update(Model model) {
		
		System.out.println("프로필 수정 들어옴");
		return "profile_update";
	}
	
	// 서비스 탈퇴
	@RequestMapping("/service_withdrawal")
	public String service_withdrawal(Model model) {
		
		
		return "service_withdrawal";
	}
	
	// 요일 웹툰
	@RequestMapping("/soomtoon_daily")
	public String soomtoon_daily(Model model) {
		
		return "soomtoon_daily";
	}
	
	// 실시간 웹툰
	@RequestMapping("/soomtoon_rank")
	public String soomtoon_rank(Model model) {
		
		return "soomtoon_rank";
	}
	
	// 회원가입
	@RequestMapping("/sign_up")
	public String signUP(Model model) {
		System.out.println("회원가입창 들어옴");
		
		return "signUp";
	}
	
}
