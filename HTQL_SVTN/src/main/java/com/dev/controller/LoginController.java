package com.dev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.dev.model.ChienDichTinhNguyen;
import com.dev.model.NguoiDung;
import com.dev.mongodb.controller.ChienDichColl;
import com.dev.mongodb.controller.NguoiDungColl;

@Controller
public class LoginController {
	
	private NguoiDungColl userColl = new NguoiDungColl();
	private ChienDichColl chienDichColl = new ChienDichColl();

	@RequestMapping("/login")
	public ModelAndView showMessage() {
		ModelAndView model = new ModelAndView("login-page");

		// Khoi tao doi tuong User de su dung cho Form Login
		NguoiDung user = new NguoiDung();
		
		// Lay danh sach 10 danh sach chien dich con han dang ky
		List<ChienDichTinhNguyen> dsChienDich = new ArrayList<ChienDichTinhNguyen>();
		dsChienDich = chienDichColl.layDSChuaHetHan(new Date());
		
		model.addObject("User", user);
		model.addObject("dsChienDich", dsChienDich);

		return model;
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
				
				System.out.println(user.getUserName());
				System.out.println(localUser.getUserName());

				// Kiem tra passwod co trung khop khong?
				if (user.getPassword().equals(localUser.getPassword())) {

					// If : Password trung khop
					// -> Cap nhat trang thai online cho user
					localUser.setSipStatus(true);
					userColl.updateSipStatus(localUser.getUserName(), true);
					// -> Luu User vao session
					session.setAttribute("User", localUser);

					// -> Chuyen sang Trang chu
					return new ModelAndView("redirect:/home-page");
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
			NguoiDung user = (NguoiDung) session.getAttribute("User");
			userColl.updateSipStatus(user.getUserName(), false);
			
			session.removeAttribute("User");
			
			return new ModelAndView("login-page").addObject("User", new NguoiDung());
		}

		@RequestMapping(value = "/map")
		public String openMap() {

			return "map";
		}

}
