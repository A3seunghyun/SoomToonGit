package com.soomtoon.www;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/soomtoonDaily")
	public String soomtoonDaily() {
		return "soomtoon_daily";
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
	
}
