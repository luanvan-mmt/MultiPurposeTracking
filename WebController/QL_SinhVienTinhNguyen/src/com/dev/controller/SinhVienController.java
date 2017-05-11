package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sinh-vien-tinh-nguyen")
public class SinhVienController {

	@RequestMapping(value = "/initmap")
	public String showMap() {

		return "map";
	}
		
}
