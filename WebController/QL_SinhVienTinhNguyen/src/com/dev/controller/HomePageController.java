package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home-page")
public class HomePageController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView initHomePage() {
		
		return new ModelAndView("home-page");
	}
	
	@RequestMapping(value = "/voiceCall", method = RequestMethod.GET)
	public ModelAndView testVoiceCall() {
		
		return new ModelAndView("voice-call");
	}
	
}
