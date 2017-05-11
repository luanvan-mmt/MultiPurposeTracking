package com.dev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.model.NguoiDung;
import com.dev.mongodb.controller.NguoiDungColl;

@Controller
@RequestMapping(value = "/login")
public class Login {

	private NguoiDungColl userColl = new NguoiDungColl();

	// ------------ CREATE LOGIN FORM ------------------------------
	
	@RequestMapping(value = "/form")
	public ModelAndView loginForm() {
		// Khoi tao doi tuong User de su dung cho Form Login
		NguoiDung user = new NguoiDung();

		return new ModelAndView("login-page", "User", user);
	}

	// ------------ HANDLE LOGIN FORM ------------------------------

	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public ModelAndView handleLogin(@ModelAttribute("User") NguoiDung user,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		NguoiDung localUser = null;
		
		System.out.println(user.getUserName());

		try {
			// Lay User tu CSDL theo userName:
			localUser = userColl.getByFieldName("userName", user.getUserName());
			
			// Kiem tra passwod co trung khop khong?
			if (user.getPassword().equals(localUser.getPassword())) {

				// If : Password trung khop
				// -> Cap nhat trang thai online cho user
				localUser.setSipStatus(true);
				userColl.updateSipStatus(localUser.getUserName(), true);
				// -> Luu User vao session
				session.setAttribute("User", localUser);

				// -> Chuyen sang Trang chu
				return new ModelAndView("redirect:/home-page/index.html");
			}

			// Else -> Quay lai trang Login + Message
			model.setViewName("login-page");
			model.addObject("User", user);
			model.addObject("message", "Tài khoản hoặc Mật khẩu không đúng.");
		} catch (NullPointerException e) {
			System.out.println("User khong ton tai");
			e.printStackTrace();

			model.setViewName("login-page");
			model.addObject("User", user);
			model.addObject("message", "Tài khoản hoặc Mật khẩu không đúng.");
		}

		return model;
	}
	
	// LOGOUT:	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		// Cap nhat trang thai Offline cho User
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("User");
		
		System.out.println("Logout" + nguoiDung.getUserName());
		
		userColl.updateSipStatus(nguoiDung.getUserName(), false);
		
		return new ModelAndView("redirect:/login/form.html").addObject("User", new NguoiDung());
	}
}





// 