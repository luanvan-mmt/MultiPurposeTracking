package controller;

import javax.servlet.http.HttpSession;

import model.User;
import mongodb.UsersCollection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class Login {
	
	private UsersCollection userColl = new UsersCollection();

	// ------------ CREATE LOGIN FORM ------------------------------
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		// Khoi tao doi tuong User de su dung cho Form Login
		User user = new User();
		
		return new ModelAndView("login-page", "User", user);
	}
	
	// ------------ HANDLE LOGIN FORM ------------------------------
	
	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public ModelAndView handleLogin(@ModelAttribute("User") User user, HttpSession session) {
		
		// Lay password trong db theo userName:
		String pwd = null;
		try {
			pwd = userColl.getPasswordByUserName(user.getUserName().toUpperCase());
		} catch (NullPointerException e) {
			System.out.println("User khong ton tai");
			e.printStackTrace();
		}
		
		// Kiem tra passwod co trung khop khong?
		if(user.getPassword().equals(pwd)) {
			
			/*
			 * If : Password trung khop
			 * -> Luu User vao session
			 */
			session.setAttribute("User", user);
			
			// -> Chuyen sang Trang chu
			return new ModelAndView("home-page");
		}
		
		// Else -> Quay lai trang Login + Message
		ModelAndView model = new ModelAndView("login-page", "User", user)
			.addObject("message", "Tài khoản hoặc Mật khẩu không đúng.");
		return model;
	}
	
	@RequestMapping(value = "/register")
	public String redirectRegister() {
		
		return "redirect:/register/form.html";
	}
	
}
