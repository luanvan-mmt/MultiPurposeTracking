package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.mongodb.controller.ChienDichColl;

@Controller
@RequestMapping(value = "/chien-dich-tinh-nguyen")
public class ChienDich {
	
	ChienDichColl cdColl = new ChienDichColl();

	@RequestMapping(value = "/management")
	public ModelAndView management() {
		ModelAndView model = new ModelAndView("ql-dot-tn");
		
		return model;
	}
	
	@RequestMapping(value = "/create/form")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("tao-chien-dich");
		
		com.dev.model.ChienDichTinhNguyen chienDich = new com.dev.model.ChienDichTinhNguyen();
		chienDich.setMaChienDich(110110);
		
		model.addObject("ChienDich", chienDich);
		
		return model;
	}
	
	@RequestMapping(value = "/create/handle")
	public ModelAndView createHandle(@ModelAttribute com.dev.model.ChienDichTinhNguyen chienDich) {
		ModelAndView model = new ModelAndView();
		
		cdColl.save(chienDich);
		
		model.setViewName("redirect:/chien-dich-tinh-nguyen/management.html");
		
		return model;
	}
	
}
