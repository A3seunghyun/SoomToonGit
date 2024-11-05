package com.websocket.server;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.websocket.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	private static List<Session> sessionList = new ArrayList<Session>();
	
	@OnOpen
	public void handleOpen(Session session) {
		sessionList.add(session);
		checkSessionList();			//접속자 확인
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {
		System.out.println(msg);
		
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		if(message.getCode().equals("1")) {
			for(Session s : sessionList) {
				if (s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (message.getCode().equals("2")) {
			sessionList.remove(session);
			for(Session s : sessionList) {
				try {
					s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if(message.getCode().equals("3")) {	//상대방 메세지 전송
			// 보낸사람 빼고 나머지 사람에게 전달함.
			for(Session s : sessionList) {
				if (s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (message.getCode().equals("4")) { //상대방 메세지 전송
			for(Session s : sessionList) {
				if (s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	} 

	// 접속자를 확인하는 메서드
	private void checkSessionList() {
		System.out.println();
		System.out.println("[Session List]");
		for(Session session : sessionList) {
			System.out.println(session.getId());
			
		}
		System.out.println();
		
	}
}
