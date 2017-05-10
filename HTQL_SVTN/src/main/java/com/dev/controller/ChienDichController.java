package com.dev.controller;

import com.dev.model.ChienDichTinhNguyen;
import com.dev.mongodb.controller.ChienDichColl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/chien-dich-tinh-nguyen")
public class ChienDichController {
	
	ChienDichColl cdColl = new ChienDichColl();

	@RequestMapping(value = "/quan-ly")
	public ModelAndView management() {
		ModelAndView model = new ModelAndView("ql-dot-tn");
		
		return model;
	}
	
	@RequestMapping(value = "/create/form")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("tao-chien-dich");
		
		ChienDichTinhNguyen chienDich = new ChienDichTinhNguyen();
		chienDich.setMaChienDich(110110);
		
		model.addObject("ChienDich", chienDich);
		
		return model;
	}
	
	@RequestMapping(value = "/create/handle")
	public ModelAndView createHandle(@ModelAttribute ChienDichTinhNguyen chienDich) {
		ModelAndView model = new ModelAndView();
		
		cdColl.save(chienDich);
		
		model.setViewName("redirect:/chien-dich-tinh-nguyen/quan-ly");
		
		return model;
	}
	
}
