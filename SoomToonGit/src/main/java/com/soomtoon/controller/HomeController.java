package com.soomtoon.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	BoardService bSvc;
	
	// 테스트 1008 승현
	@RequestMapping("/webtoonContent")
	public String webtoonContent() {
		return "webtoon_content";
	}
	
	@RequestMapping("/freeBulletinBoard")
	public String freebulletinboard(Model model) {
		System.out.println("자유게시판 이동");
		ArrayList<BoardDto> boardAllList = bSvc.boardAllList();
		for(BoardDto dto : boardAllList){
			System.out.println(dto.getTitle());
		}
		model.addAttribute("boardAllList", boardAllList);
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
	@RequestMapping("/account_infor")
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
