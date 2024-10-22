package com.soomtoon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soomtoon.service.MemberService;

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

}