package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/map")
public class MapController {
	
	@RequestMapping(value = "/show")
	public String showMap() {
		
		return "map";
	}
	
}
