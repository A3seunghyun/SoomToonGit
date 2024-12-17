package com.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	
	@GetMapping(value = "/index.do")
	public String index(Model model) {
		return "chatbot";
	}
	
	@GetMapping(value = "/chat.do")
	public String chat(Model model) {
		return "chat";
	}
	
	@GetMapping(value = "/chat.list")
	public String chatList(String alias, Model model) {
		
		model.addAttribute("alias",alias);
		return "chat_list";
	}
}
