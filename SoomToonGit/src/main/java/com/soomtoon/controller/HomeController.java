package com.soomtoon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
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
		 // 세션에서 userInfo 객체를 가져옴
	    MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
	    
		if(userInfo == null) {
			System.out.println("세션에 저장된 userInfo가 없음 로그인페이지로");
			return "redirect:/login";
		}
		
		// userInfo 객체에 user_idx와 정보를 모덱에 추가
		model.addAttribute("userInfo", userInfo);
		
	    System.out.println("계정정보 페이지 들어옴. user_idx: " + userInfo.getUser_idx());
	    
		return "account_infor";
	}
	
	// 계정 삭제
	@RequestMapping(value = "/account_delete", method = RequestMethod.POST)
	public String account_delete(@RequestParam(value = "user_idx", required = false) Integer user_idx, 
								Model model, HttpSession session) {
		
		 // 세션에서 userInfo 객체를 가져옴
	    MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
	    
		if(userInfo == null) {
			System.out.println("세션에 저장된 userInfo가 없음 로그인페이지로");
			return "redirect:/login";
		}
		
		System.out.println("계정 삭제됨 user_idx : " + user_idx);
		ms.acoountDelete(userInfo.getUser_idx());
		ms.postDelete(userInfo.getUser_idx());
		
		session.invalidate();
		
		return "redirect:/main";
	}
	
	
	// 서비스 탈퇴페이지
	@RequestMapping("/service_withdrawal")
	public String service_withdrawal(@RequestParam(value = "user_idx", required = false) Integer user_idx, 
									Model model, HttpSession session) {
		
		
		return "service_withdrawal";
	}
	
	
	// 프로필 수정 form
	@RequestMapping("/profile_updateForm")
	public String profile_updateForm(@RequestParam(value = "user_idx", required = false) Integer user_idx, Model model, HttpSession session) {
		 // 세션에서 dto 객체를 가져옴
	    MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
	    
	    // dto가 세션에 없을 경우 로그인 페이지로 리다이렉트
	    if (userInfo == null) {
	        System.out.println("세션에 저장된 dto가 null입니다. 로그인 페이지로 이동합니다.");
	        return "redirect:/login";
	    }

	    // 모델에 dto 추가
	    model.addAttribute("userInfo", userInfo);
	    
	    return "profile_update";
	}
	
	// 프로필 수정
	@RequestMapping("/profile_update")
	public String profile_update( @RequestParam("alias") String alias, HttpSession session) {
		
		// 세션에서 dto 객체를 가져옴
	    MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
	    
		if(userInfo == null) {
			System.out.println("세션에 저장된 userInfo가 없음 로그인페이지로");
			return "redirect:/login";
		}
	    
	    userInfo.setAlias(alias);
	    ms.updateAlias(userInfo);
	    
	    System.out.println("프로필 수정 완료. user_idx: " + userInfo.getUser_idx() + ", alias: " + alias);
		return "redirect:/account_infor";
	}
	
	// 메인페이지 (요일 웹툰)
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
		
		Map<Integer, Boolean> favoriteWebtoons = ss.getFavoriteWebtoons(userId);
		model.addAttribute("favoriteWebtoons", favoriteWebtoons);
		
		
		ArrayList<SoomtoonDto> dto = ss.getSoomtoonListAll();
		model.addAttribute("dto", dto);
		return "soomtoon_daily";
	}
	
	// 실시간 웹툰 랭킹
	@RequestMapping(value= "/soomtoon_rank")
	public String soomtoon_rank(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		
		// 웹툰 목록 불러오기
		ArrayList<SoomtoonDto> list = ss.getSoomtoonListAll();
		model.addAttribute("list", list);
		
		// 웹툰의 총 수
		int countToonAll = ss.counToonAll();
		model.addAttribute("countToonAll", countToonAll);
		
		// 찜한 웹툰 목록ㄴ
		Map<Integer, Boolean> favoriteWebtoons = ss.getFavoriteWebtoons(userId);
		model.addAttribute("favoriteWebtoons", favoriteWebtoons);
		
		return "soomtoon_rank";
	}
	
	// 로그인한 유저의 찜한 웹툰 목록
	@RequestMapping(value = "/soomtoon_zzim")
	public String soomtoon_zzim(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
		
		// 로그인한 유저의 찜한 웹툰 목록
		List<SoomtoonDto> list = ss.getFavoriteWebtoonsList(userId);
		int zzimCount = ss.zzimCount(userInfo.getUser_idx());
		
		model.addAttribute("list",list);
		model.addAttribute("zzimCount",zzimCount);
		
		
		return "soomtoon_zzim";
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
		
		// 암호화 위함
		dto.setPw(bcryptPasswordEncoder.encode(dto.getPw()));		
		
		
		
		ms.memberInsert(dto);
//			MemberDto dto2 = dto;
//			System.out.println(dto2);
		return "redirect:/main";
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
		
		MemberDto userDto = ms.userInfo(id);
		// id를 이용해 DB에서 암호화된 비밀번호를 포함한 사용자 정보를 가져옴
		
		if(userDto != null && bcryptPasswordEncoder.matches(pw,  userDto.getPw())){   // 입력된 비밀번호와 암호화된 비밀번호 비교
													//입력된 비밀번호, 저장된 암호화된 비밀번호
			logger.info("@@@@@@로그인 비밀번호 :  " + pw);
			logger.debug("@@@@@ 로그인한 비밀번호2 : " + pw);
			logger.warn("@@@@@@ logger.warn@@@@");
			logger.error("@@@@@@ logger.error@@@@");
			
			session.setAttribute("userId",id);
			session.setAttribute("userInfo", userDto);
			return "redirect:/main";
		} else {
			model.addAttribute("errorMessage", "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
			return "login";
		}
		
		
		
		
//		boolean loginResult = ms.login(id);
//		if(loginResult) {
//			MemberDto userDto = ms.userInfo(id, pw);
//			session.setAttribute("userId", id);
//			session.setAttribute("userInfo", userDto);
//			return "redirect:/main";
//		} else {
//			model.addAttribute("errorMessage", "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
//			return "login";
//		}
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
