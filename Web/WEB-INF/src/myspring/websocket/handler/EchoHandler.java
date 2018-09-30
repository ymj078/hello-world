package myspring.websocket.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	
	public void afterConnectionEstablished(WebSocketSession session)throws Exception{
		
		sessionList.add(session);
		
		System.out.println("{} ¿¬°áµÊ" + session.getId());
		
		System.out.println("Ã¤ÆÃ¹æ ÀÔÀåÀÚ :" + session.getPrincipal().getName());
	}
	
	public void handleTextMessage(WebSocketSession session, TextMessage message)throws Exception{
		System.out.println("{}·Î ºÎÅÍ {}¹ÞÀ½" + session.getId() + message.getPayload());
		
		
		for(WebSocketSession sess : sessionList){
			sess.sendMessage(new TextMessage(session.getPrincipal().getName() + "|" + message.getPayload()) );
		}
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status)throws Exception{
		sessionList.remove(session);
		
		System.out.println("¿¬°á ²÷±è:"+ session.getId());
		
		System.out.println("Ã¤ÆÃ¹æ ÅðÀåÀÚ : " + session.getPrincipal().getName());
	}
}
