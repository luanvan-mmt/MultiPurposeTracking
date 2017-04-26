package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/chien-dich-tinh-nguyen")
public class ChienDichTinhNguyen {

	@RequestMapping(value = "/management")
	public ModelAndView management() {
		ModelAndView model = new ModelAndView("ql-dot-tn");
		
		return model;
	}
	
	@RequestMapping(value = "/create/form")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("tao-chien-dich");
		
		model.ChienDichTinhNguyen chienDich = new model.ChienDichTinhNguyen();
		chienDich.setMaChienDich(110110);
		
		model.addObject("ChienDich", chienDich);
		
		return model;
	}
	
	@RequestMapping(value = "/create/handle")
	public ModelAndView createHandle(@ModelAttribute model.ChienDichTinhNguyen chienDich) {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("redirect:/chien-dich-tinh-nguyen/management.html");
		model.addObject("ChienDich", chienDich);
		
		return model;
	}
	
}
