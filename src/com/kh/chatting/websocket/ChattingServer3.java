package com.kh.chatting.websocket;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.kh.chatting.model.vo.Message;
import com.kh.member.model.vo.Member;

// 일반클래스를 웹소켓 서버로 등록하기위한 방법
@ServerEndpoint(value="/chatting3.do" ,
				decoders = {JsonDecoder.class},
				encoders = {JsonEncoder.class}, 
				configurator = HttpSessionConfigurator.class
		)
public class ChattingServer3 {
	
	
	@OnOpen 
	public void open(Session session, EndpointConfig config) {
		HttpSession httpSession = (HttpSession) config.getUserProperties().get("session");
		Member m = (Member)httpSession.getAttribute("loginUser");
		System.out.println(m);
		session.getUserProperties().put("loginUser", m);
		System.out.println("클라이언트 접속..." + session.getId());
	}
	
	// 클라이언트에서 보내는 메세지를 처리하는 메소드
	@OnMessage
	public void message(Session session, Message msg) { 
		session.getUserProperties().put("msg", msg);
		
		Set<Session> clinets = session.getOpenSessions();
		for (Session s : clinets) {
			Message clientData = (Message)s.getUserProperties().get("msg");
			Member loginUser = (Member)s.getUserProperties().get("loginUser");
			System.out.println(loginUser);
			if(clientData != null) {
				String userId = clientData.getSender();
				if(userId.equals(msg.getReceiver()) || userId.equals(msg.getSender())) {
					try {
						s.getBasicRemote().sendObject(msg);						
					} catch (IOException | EncodeException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}
