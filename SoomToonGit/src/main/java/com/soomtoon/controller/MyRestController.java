package com.soomtoon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.soomtoon.dto.SoomtoonDto;
import com.soomtoon.dto.WebtoonDto;
import com.soomtoon.service.MemberService;
import com.soomtoon.service.SoomtoonService;
import com.soomtoon.service.WebtoonService;

@RestController
@RequestMapping(value="/ajax", produces="application/json; charset=UTF-8")
public class MyRestController {
	// 멤버 관련 서비스
	@Autowired
	MemberService ms;
	
	@ResponseBody
	@RequestMapping("/ConfirmId")
	public boolean confirmId(@RequestBody Map<String, String> param) throws Exception {
	    // 클라이언트에서 보낸 JSON 데이터의 "id" 필드를 추출
	    String id = param.get("id");
	    System.out.println("ConfirmId 호출됨, id: " + id);
	    
	    int result = ms.selectId(id);  // 1이면 중복
	    System.out.println("ID중복검사 결과: " + result);

	    return result == 1;  // 1이면 true 반환, 0이면 false 반환
	}
	
	@Autowired
	WebtoonService ws;
	
	@ResponseBody
	@RequestMapping("/WebtoonSearch")
	public ArrayList<WebtoonDto> WebtoonSearch(@RequestBody Map<String, String> param) throws Exception {
	    // 클라이언트에서 보낸 JSON 데이터의 "id" 필드를 추출
	    String webtoonName = param.get("webtoonName");
	    System.out.println("웹툰명, webtoonName : " + webtoonName);
	    
	    ArrayList<WebtoonDto> result = ws.getWebtoonSearchSelect(webtoonName);

	    return result;
	}
	
	
	@Autowired
	SoomtoonService ss;
	
	
	// 채팅창, 헤더 웹툰 검색
	@ResponseBody
	@RequestMapping(value= "/searchToonList", method = RequestMethod.POST)
	public ArrayList<SoomtoonDto> searchToonList(@RequestBody Map<String, String> param) {
		String toonName = param.get("toonName");
		System.out.println("툰 네임 " + toonName);
		
		ArrayList<SoomtoonDto> list = ss.searchToonList(toonName);
		System.out.println("검색된 웹툰 : " + list);
		
		return list;
	}
	
	
	// 웹툰 찜 insert
	@RequestMapping(value="/soomtoonZzim", method = RequestMethod.POST)
	public Map<String, String> webtoonZzim(@RequestBody Map<String, Object> param) {
		Map<String, String> result = new HashMap<>();
		
		String toonIdxStr = String.valueOf(param.get("toonIdx"));
		String userIdxStr = String.valueOf(param.get("userIdx"));
		boolean isFavorite = Boolean.parseBoolean(String.valueOf(param.get("isFavorite")));
		// 찜상태 가져옴
		
		System.out.println("webtoon_idx, user_ idx : " + toonIdxStr + "," + userIdxStr);
											// param.get은 Object로 반환됨 -> String.valueOf 사용
		
		if(toonIdxStr == null || toonIdxStr.isEmpty() || userIdxStr == null || userIdxStr.isEmpty()) {
			Map<String, String> errorResult = new HashMap<>();
			errorResult.put("message", "파라미터가 null");
			errorResult.put("status", "error");
			return errorResult;
		}
		
		int webtoon_idx = Integer.parseInt(toonIdxStr);
		int user_idx = Integer.parseInt(userIdxStr);
		
		// 찜 insert, delete
		boolean zzim;
		
		
		if(isFavorite) {
			// 이미 찜한 상태라면 찜 delete
			zzim = ss.deleteZzim(webtoon_idx, user_idx);
			result.put("message", zzim ? "찜 해제 성공!" : "찜 해제 실패");
		} else {
			// 찜하지 않은 상태라면 찜insert
			zzim = ss.toonZzim(webtoon_idx, user_idx);
	        result.put("message", zzim ? "웹툰 찜 성공!" : "이미 찜 한 웹툰입니다.");
		}
		
		 result.put("status", zzim ? "success" : "error");
		 // zzim이 성공했으면 success 실패면 error
		 
		return result;	
		
	}
	
	

////	// 카카오 로그인
//	KakaoAPI kakaoApi = new KakaoAPI();
//	
//	@RequestMapping(value = "/login.do")
//	public @ResponseBody String getKakaoAuthUrl(@RequestParam("code") String code, Model model, HttpSession session) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		
//		// 1번 인증코드 요청 전달
//		String access_token = kakaoApi.getAccessToken(code);
//		
//		// 2번 인증코드로 토큰 전달
//		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);
//		
//		System.out.println("login info : " + userInfo.toString());
//		
//		if(userInfo.get("email") != null) {
//			session.setAttribute("userId", userInfo.get("email"));
//			session.setAttribute("access_token", access_token);
//		}
//		mav.addObject("userId",userInfo.get("email"));
//		mav.addObject("access_token",access_token);
//		
//		String id = "6259e8667002337b0fccfd09aec1ce35";  //REST API 키
//		String url = "http://localhost:9090/soomtoon/login";
//		
//		String kakaoUrl = 
//				"https://kauth.kakao.com/oauth/authorize"
//				+ "?client_id=" + id
//				+ "&redirect_uri=" + url + "&response_type=code";
//		
//		model.addAttribute("kakaoLUrl", kakaoUrl);
//		return "login";
//	}
//	
//	
	
	
	

}