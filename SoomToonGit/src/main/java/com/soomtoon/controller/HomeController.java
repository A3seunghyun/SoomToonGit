package com.soomtoon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.BoardInsertDto;
import com.soomtoon.dto.ChildCommentDto;
import com.soomtoon.dto.ChildCommentInsertDto;
import com.soomtoon.dto.CommentDetailDto;
import com.soomtoon.dto.CommentDto;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
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
	
//	// 자유게시판 - 승현
//	@RequestMapping("/freeBulletinBoard")
//	public String freebulletinboard(Model model) {
//		System.out.println("자유게시판 이동");
//		ArrayList<BoardDto> boardAllList = bSvc.boardAllList();
//		
//		model.addAttribute("boardAllList", boardAllList);
//		return "free_bulletin_board";
//	}
	
	// 자유게시판 검색 - 승현
	@RequestMapping("/freeBulletinBoard")
	public String freebulletinboardSerach(Model model, 
										@RequestParam(value = "searchType", required = false) String searchType, 
										@RequestParam(value = "searchTerm", required = false) String searchTerm) {
		System.out.println("자유게시판 검색");
		ArrayList<BoardDto> boardSearchList = new ArrayList<BoardDto>();
		if (searchTerm == null || searchTerm.trim().isEmpty() || searchType == null || searchType.trim().isEmpty()) {
			System.out.println("검색키워드 없음.");
			boardSearchList = bSvc.boardAllList();
		} else {
			String title = null;
			String userName = null;
			String webtoonName = null;
			if(searchType.equals("title")) {
				title = searchTerm;
				System.out.println("제목 : " + title);
			} else if(searchType.equals("userName")) {
				userName = searchTerm;
				System.out.println("작성자 : " + userName);
			} else {
				webtoonName = searchTerm;
				System.out.println("웹툰명 : " + webtoonName);
			}
			
			boardSearchList = bSvc.boardSearchList(title, userName, webtoonName);
		}
		
		model.addAttribute("boardSearchList", boardSearchList);
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
		
		// 게시글 상세 정보
		ArrayList<BoardDto> boardDetail = bSvc.boardDetail(postIdx, session);
		
		// 게시글 댓글
		ArrayList<CommentDetailDto> boardComments = bSvc.getBoardCommentSelect(postIdx);
		
		
		// 게시글 대댓글
		ArrayList<ChildCommentDto> childComments = bSvc.getChildCommentSelect(postIdx);
		
		BoardDto bDto = boardDetail.get(0);
		System.out.println("게시글작성 ID : " + bDto.getUserId());
		
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("userId", userId);
		model.addAttribute("boardComments", boardComments);
		model.addAttribute("childComments", childComments);
		
		return "board_detail";
	}
	
	@RequestMapping("/writePost")
	public String writePost(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "login";
		}
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
	
	// 댓글 쓰기
	@RequestMapping(value= "/writeComment", method = RequestMethod.POST)
	public String commentInsert(Model model, @ModelAttribute CommentDto dto) {
		System.out.println("POST IDX : " + dto.getPostIdx());
		int postIdx = dto.getPostIdx();
		bSvc.commentInsert(dto);
		return "redirect:/boardDetail?postIdx=" + postIdx;
	}
	
	// 댓글 답변 쓰기
	@RequestMapping(value= "/writeChildComment", method = RequestMethod.POST)
	public String childCommentInsert(Model model, @ModelAttribute ChildCommentInsertDto dto) {
		System.out.println("POST IDX : " + dto.getPostIdx());
		int postIdx = dto.getPostIdx();
		bSvc.childCommentInsert(dto);
		return "redirect:/boardDetail?postIdx=" + postIdx;
	}
	
	@RequestMapping("/error")
	public String errorPage() {
		return "error_page";
	}
	
	@RequestMapping(value="/webtoonRating", method = RequestMethod.POST)
	public String webtoonRating(Model model, @RequestParam("rating") int rating) {
		int webtoonIdx = 1;
		int webtoonRating = rating;
		System.out.println("평점 : " + webtoonRating);
		return "redirect:/webtoonContent?webtoonIdx=" + webtoonIdx;
	}
	
	// 용준
	@Autowired
	MemberService ms;
	
	@Autowired
	SoomtoonService ss;
	
	// 계정정보
	@RequestMapping(value= "/account_infor")
	public String account_infor(HttpSession session, Model model) {
		
//			로그인 합친 이후 주석풀어
//			Integer user_idx = (Integer)session.getAttribute("user_idx");
//			if(user_idx == null) {
//				return "redirect:/soomtoon/login";
//			}
		
//			지금은 예시 user_idx 
		Integer user_idx = 2; 
		MemberDto dto = ms.selectUserIdx(user_idx);
		
		model.addAttribute("user_idx", user_idx);
		model.addAttribute("dto", dto);
		
		System.out.println("계정정보 페이지 들어옴");
		
		return "account_infor";
	}
	
	// 계정 삭제
	@RequestMapping(value = "/account_delete", method = RequestMethod.POST)
	public String account_delete(@RequestParam(value = "user_idx", required = false) Integer user_idx, Model model, HttpSession session) {
		
		user_idx = 2;  // 로그인 기능 이후 수정 해야함
		if(user_idx == null) {
			System.out.println("회원탈퇴 에러 user_idx가 null임 !!");
			return "redirect:/account_infor";
		} 
		
		System.out.println("계정 삭제됨 user_idx : " + user_idx);
		ms.acoountDelete(user_idx);
		
//			로그인 기능 완성 후
//			session.invalidate();
		
//			로그인페이지로 이동하는거로 바꾸기 
		return "redirect:/";
	}
	
	
	// 서비스 탈퇴
	@RequestMapping("/service_withdrawal")
	public String service_withdrawal(Model model) {
		
		
		return "service_withdrawal";
	}
	
	
	// 프로필 수정 form
	@RequestMapping("/profile_updateForm")
	public String profile_updateForm(Integer user_idx, Model model) {
		if(user_idx == null) {
			logger.info("user_idx가 null 에러!");
			return "account_infor";
		}
		MemberDto dto = ms.selectUserIdx(user_idx);
		model.addAttribute("dto", dto);
		
		return "profile_update";
	}
	
	// 프로필 수정
	@RequestMapping("/profile_update")
	public String profile_update(MemberDto dto, Model model) {
		System.out.println("user_idx: " + dto.getUser_idx());
		System.out.println("alias: " + dto.getAlias());
		
		ms.updateAlias(dto);
		
		System.out.println("프로필 수정 들어옴");
		return "redirect:/account_infor";
	}
	
	@RequestMapping(value= "/main")
	public String soomtoon_daily(String day_week, Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId"); // 로그인한 사용자 IDX
		System.out.println("유저ID : " + userId);
		
		if(day_week == null) {
			day_week = "1";
		}
		
		ArrayList<SoomtoonDto> list = ss.getSoomtoonList(day_week);
		System.out.println("웹툰 리스트:" + list);
		
		model.addAttribute("day_week", day_week);
		model.addAttribute("list",list);
		
		int countToon = ss.getCountToon(day_week);
		model.addAttribute("countToon", countToon);
		return "soomtoon_daily";
	}
	
	// 실시간 웹툰 랭킹
	@RequestMapping(value= "/soomtoon_rank")
	public String soomtoon_rank(Model model) {
		
		ArrayList<SoomtoonDto> list = ss.getSoomtoonListAll();
		model.addAttribute("list", list);
		
		int countToonAll = ss.counToonAll();
		model.addAttribute("countToonAll", countToonAll);
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
//			MemberDto dto2 = dto;
//			System.out.println(dto2);
		return "redirect:/";
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
