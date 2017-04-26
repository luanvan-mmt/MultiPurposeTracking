package controller;

import javax.servlet.http.HttpSession;

import model.CanBo;
import model.SIPAccount;
import model.SinhVien;
import model.NguoiDung;
import mongodb.SIPAccountCollection;
import mongodb.CanBoCollection;
import mongodb.SinhVienCollection;
import mongodb.UserCollection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class Login {

	private UserCollection userColl = new UserCollection();

	// ------------ CREATE LOGIN FORM ------------------------------

	@RequestMapping(value = "/form", method = RequestMethod.GET)
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
			
			System.out.println(user.getUserName());
			System.out.println(localUser.getUserName());

			// Kiem tra passwod co trung khop khong?
			if (user.getPassword().equals(localUser.getPassword())) {

				// If : Password trung khop -> Luu User vao session
				session.setAttribute("User", localUser);
				
				// Lay Sip Account va luu vao session
				SIPAccountCollection sipColl = new SIPAccountCollection();
				SIPAccount sipAccount = sipColl.getInactiveAccount();
				session.setAttribute("sipAccount", sipAccount);

				// Kiem tra xem User la Can bo hay Sinh vien:
				int role = localUser.getRole();

				if (role == 2) { // Neu User la Can Bo
					// Lay thong tin Can bo tu CSDL
					CanBoCollection staffColl = new CanBoCollection();
					CanBo canBo = staffColl.getByFieldName("mscb",
							localUser.getUserName());

					// Luu thong tin Can bo vao Session
					session.setAttribute("CanBo", canBo);
					
				} else if (role == 3) { // Neu User la Sinh vien
					// Lay thong tin Sinh vien tu CSDL
					SinhVienCollection studentColl = new SinhVienCollection();
					SinhVien sinhVien = studentColl.getByFieldName("mssv",
							localUser.getUserName());
					
					// Luu thong tin Sinh vien vao Session
					session.setAttribute("SinhVien", sinhVien);
					
				} else if (role == 1) {

				}

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
		session.removeAttribute("CanBo");
		session.removeAttribute("SinhVien");
		session.removeAttribute("sipAccount");
		session.removeAttribute("User");
		
		return new ModelAndView("login-page").addObject("User", new NguoiDung());
	}

	@RequestMapping(value = "/map")
	public String openMap() {

		return "map";
	}
}





// 