package com.dev.controller;

import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sinh-vien-tinh-nguyen")
public class SinhVienController {

	@RequestMapping(value = "/initmap")
	public String showMap() {

		return "map";
	}
		
}
