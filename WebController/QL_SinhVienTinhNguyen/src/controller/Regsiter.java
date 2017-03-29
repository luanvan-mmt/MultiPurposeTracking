package controller;

import model.Staff;
import model.Student;
import model.User;
import mongodb.StudentCollection;
import mongodb.UsersCollection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.SendEmail;

@Controller
@RequestMapping(value = "/register")
public class Regsiter {
	
	private StudentCollection studentColl = new StudentCollection();
	private UsersCollection userColl = new UsersCollection();
	
	// ------------ CREATE REGISTER FORM ------------------------------
	
	@RequestMapping(value = "/form")
	public ModelAndView registerForm() {
		ModelAndView model = new ModelAndView("register-page");
		model.addObject("Student", new Student());
		model.addObject("Staff", new Staff());
		
		return model;
	}
	
	// ------------ HANDLE REGISTER FORM ------------------------------
	
	@RequestMapping(value = "/handleStudent", method = RequestMethod.POST)
	public ModelAndView handleStudentRegister(@ModelAttribute("Student") Student student) {
		studentColl.saveUser(student);
		
		String password = userColl.autoCreateUser(student.getStudentId());
		
		SendEmail.sendEmail(student.getEmail(), password);
		
		User user = userColl.getUserByUserName(student.getStudentId());
		
		ModelAndView model = new ModelAndView("redirect:/login/form.html");
		model.addObject("User", user);
		
		return model;
	}
	
	@RequestMapping(value = "/handleStaff", method = RequestMethod.POST)
	public ModelAndView handleStaffRegister() {
		
		return new ModelAndView("register-page", "Student", new Student());
	}
	
	
	@RequestMapping(value = "/login")
	public String quayLai() {
		
		return "redirect:/login/form.html";
	}
	
}














// End