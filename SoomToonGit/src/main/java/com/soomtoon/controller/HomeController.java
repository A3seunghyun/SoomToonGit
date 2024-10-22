package com.soomtoon.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.MemberDto;
import com.soomtoon.dto.SoomtoonDto;
import com.soomtoon.dto.WebtoonDto;
import com.soomtoon.service.BoardService;
import com.soomtoon.service.MemberService;
import com.soomtoon.service.SoomtoonService;
import com.soomtoon.service.WebtoonService;

@Controller
public class HomeController {
	@Autowired
	BoardService bSvc;
	
	@Autowired
	WebtoonService wSvc;
	
	// 특정 웹툰 페이지 - 승현
	@RequestMapping(value= "/webtoonContent", method = RequestMethod.GET)
	public String webtoonContent(Model model, @RequestParam("webtoonIdx") int webtoonIdx) {
		
		if(webtoonIdx < 1) {
			System.out.println("웹툰 상세페이지 이동중 오류발생");
			return "error_page";
		}
		
		System.out.println("웹툰 상세페이지 이동");
		
		// 특정 웹툰 상세 정보
		ArrayList<WebtoonDto> webtoonDetail = wSvc.webtoonDetail(webtoonIdx);
		
		// 특정 웹툰 게시판
		ArrayList<BoardDto> webtoonBoardList = wSvc.webtoonBoardList(webtoonIdx);
		
		model.addAttribute("webtoonDetail", webtoonDetail);
		model.addAttribute("webtoonBoardList", webtoonBoardList);
		
		return "webtoon_content";
	}
	
	// 자유게시판 - 승현
	@RequestMapping("/freeBulletinBoard")
	public String freebulletinboard(Model model) {
		System.out.println("자유게시판 이동");
		ArrayList<BoardDto> boardAllList = bSvc.boardAllList();
		
		model.addAttribute("boardAllList", boardAllList);
		return "free_bulletin_board";
	}
	
	// 게시글 상세페이지 - 승현
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, @RequestParam("postIdx") int postIdx) {
		
		if(postIdx < 1) {
			System.out.println("게시글 상세페이지 이동중 오류발생");
			return "error_page";
		}
		
		System.out.println("게시글 상세페이지 이동 : postIdx : " + postIdx);
		ArrayList<BoardDto> boardDetail = bSvc.boardDetail(postIdx);
		
		model.addAttribute("boardDetail", boardDetail);
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
	
	@RequestMapping("/error")
	public String errorPage() {
		return "error_page";
	}
	
	
	// 용준
	@Autowired
	MemberService ms;
	
	@Autowired
	SoomtoonService ss;
	
	// 계정정보
	@RequestMapping(value= "/account_infor")
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
	@RequestMapping(value= "/")
	public String soomtoon_daily(String day_week, Model model) {
		if(day_week == null) {
			day_week = "1";
		}
		
		ArrayList<SoomtoonDto> list = ss.getSoomtoonList(day_week);
		System.out.println("웹툰 리스트:" + list);
		
		model.addAttribute("day_week", day_week);
		model.addAttribute("list",list);
		
		return "soomtoon_daily";
	}
	
	// 실시간 웹툰 
	@RequestMapping(value= "/soomtoon_rank")
	public String soomtoon_rank(Model model) {
		
		return "soomtoon_rank";
	}
	
	// 게시글 쓰기
	@RequestMapping(value= "/soomtoon_insert")
	public String soomtoon_insert(Model model) {
		
		return "soomtoon_insert";
	}
	
	// 회원가입
	@RequestMapping(value= "/sign_up")
	public String signUP(Model model) {
		System.out.println("회원가입창 들어옴");
		
		return "signUp";
	}
	
	// 회원등록
	@RequestMapping("/insert_member")
	public String insertMember(Model model, MemberDto dto) {
		System.out.println("회원가입 정보 들어옴");

		ms.memberInsert(dto);
//		MemberDto dto2 = dto;
//		System.out.println(dto2);
		return "soomtoon_daily";
	}
	
}
