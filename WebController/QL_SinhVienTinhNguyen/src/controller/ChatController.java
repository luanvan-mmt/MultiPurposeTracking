package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chat")
public class ChatController {
	
	@RequestMapping(value = "init")
	public String initChat() {
		
		return "chat";
	}
}
