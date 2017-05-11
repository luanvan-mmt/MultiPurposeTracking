package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.model.NguoiDung;
import com.dev.mongodb.controller.NguoiDungColl;

@Controller
@RequestMapping(value = "/nguoidung")
public class NguoiDungController {
	
	private NguoiDungColl userColl = new NguoiDungColl();
	
	@RequestMapping(value = "doiMatKhau")
	public String changePassword(Model model) {
		
		
		return "doi-mat-khau";
	}
	
	@RequestMapping(value = "ktMaSo", method = RequestMethod.POST)
	public ModelAndView handleMaSo(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		String maso = request.getParameter("maso");
		String message = null;
		NguoiDung localUser = null;
		
		try {
			// Lay User tu CSDL theo userName:
			localUser = userColl.getByFieldName("userName", maso);
			
			System.out.println(localUser.getUserName());
			
			// Kiem tra ma so co trung khop khong?
			if (maso.equalsIgnoreCase(localUser.getUserName())) {
				message = "masoOK";
				
				session.setAttribute("masoOK", maso);
			} else {
				message = "masokhongdung";
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			message = "masokhongdung";
		}
		
		System.out.println(message);
		
		model.setViewName("doi-mat-khau");
		model.addObject("message", message);
		model.addObject("maso", maso);
		
		return model;
	}
	
	@RequestMapping(value = "ktMatKhau", method = RequestMethod.POST)
	public ModelAndView handleMatKhau(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		String maso = (String) session.getAttribute("masoOK");
		String oldpwd = request.getParameter("oldPwd");
		String newpwd = request.getParameter("newPwd");
		String message = null;
		NguoiDung localUser = null;
		
		try {
			// Lay User tu CSDL theo userName:
			localUser = userColl.getByFieldName("userName", maso);
			
			System.out.println(localUser.getUserName());
			
			// Kiem tra passwod cũ co trung khop khong?
			if (oldpwd.equalsIgnoreCase(localUser.getPassword())) {
				// Cap nhat trong CSDL
				localUser.setPassword(newpwd);
				userColl.update(localUser, "userName", localUser.getUserName());
				
				// Xoa masoOK khoi session
				session.removeAttribute("masoOK");
				
				message = "OK";
			} else {
				
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		System.out.println(message);
		
		model.setViewName("doi-mat-khau");
		model.addObject("message", message);
		
		return model;
	}
	
}
