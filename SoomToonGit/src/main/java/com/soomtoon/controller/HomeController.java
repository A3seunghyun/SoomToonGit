package com.soomtoon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;
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
	public String boardDetail(HttpSession session, Model model, @RequestParam("postIdx") int postIdx) {
		String userId = (String) session.getAttribute("userId"); // 로그인한 사용자 IDX
		System.out.println("유저ID : " + userId);
		
		if(postIdx < 1) {
			System.out.println("게시글 상세페이지 이동중 오류발생");
			return "error_page";
		}
		
		System.out.println("게시글 상세페이지 이동 : postIdx => " + postIdx);
		ArrayList<BoardDto> boardDetail = bSvc.boardDetail(postIdx);
		
		BoardDto bDto = boardDetail.get(0);
		System.out.println("게시글작성 ID : " + bDto.getUserId());
		
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("userId", userId);
		
		return "board_detail";
	}
	
	@RequestMapping("/writePost")
	public String writePost() {
		return "write_post"; 
	}
	
	// 게시글 쓰기
	@RequestMapping(value= "/writePost", method = RequestMethod.POST)
	public String soomtoon_insert(Model model, @ModelAttribute BoardInsertDto dto) {
		System.out.println("사용자 IDX : " + dto.getUserIdx());
		bSvc.boardInsert(dto);
		return "redirect:/freeBulletinBoard";
	}
	
	// 게시글 수정 페이지
	@RequestMapping(value= "/editPage", method = RequestMethod.POST)
	public String editPage(Model model, 
							@RequestParam("postIdx") int postIdx,
							@RequestParam("postTitle") String postTitle,
							@RequestParam("postContent") String postContent) {
		model.addAttribute("postIdx", postIdx);
		model.addAttribute("postTitle", postTitle);
		model.addAttribute("postContent", postContent);
		
		return "edit_page";
	}
	
	// 게시글 수정 기능
	@RequestMapping(value= "/editPost", method = RequestMethod.POST)
	public String soomtoon_update(Model model, @RequestParam("postIdx") int postIdx, 
												@RequestParam("webtoonIdx") int webtoonIdx, 
												@RequestParam("postTitle") String postTitle, 
												@RequestParam("postContent") String postContent) {
		System.out.println("수정 테스트 게시글 IDX : " + postIdx);
		bSvc.boardUpdate(postIdx, webtoonIdx, postTitle, postContent);
		return "redirect:/boardDetail?postIdx=" + postIdx;
	}
	
	// 게시글 삭제
	@RequestMapping(value= "/deletePost", method = RequestMethod.GET)
	public String soomtoon_delete(Model model, @RequestParam("postIdx") int postIdx) {
		System.out.println("삭제 테스트 게시글 IDX : " + postIdx);
		bSvc.boardDelete(postIdx);
		return "redirect:/freeBulletinBoard";
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
	@RequestMapping(value= "/main")
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
		return "login";
	}
	
	// 로그인 페이지 - 승현
	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	// 로그인처리 - 승현
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw,
						HttpSession session, Model model, MemberDto dto) {
		boolean loginResult = ms.login(id, pw);
		if(loginResult) {
			MemberDto userDto = ms.userInfo(id, pw);
			session.setAttribute("userId", id);
			session.setAttribute("userInfo", userDto);
			return "redirect:/main";
		} else {
			model.addAttribute("errorMessage", "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
			return "login";
		}
	}
	
	// 로그아웃 - 승현
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		if (session != null) {
	        session.invalidate();
	    }
		
		return "redirect:/main";
	}
	
}
