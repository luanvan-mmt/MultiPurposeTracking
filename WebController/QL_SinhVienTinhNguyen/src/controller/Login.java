package controller;

import javax.servlet.http.HttpSession;

import model.Staff;
import model.Student;
import model.User;
import mongodb.StaffCollection;
import mongodb.StudentCollection;
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
		User user = new User();

		return new ModelAndView("login-page", "User", user);
	}

	// ------------ HANDLE LOGIN FORM ------------------------------

	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public ModelAndView handleLogin(@ModelAttribute("User") User user,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		User localUser = null;

		try {
			// Lay User tu CSDL theo userName:
			localUser = userColl.getByFieldName("userName", user.getUserName());

			// Kiem tra passwod co trung khop khong?
			if (user.getPassword().equals(localUser.getPassword())) {

				// If : Password trung khop -> Luu User vao session
				session.setAttribute("User", localUser);

				// Kiem tra xem User la Can bo hay Sinh vien:
				int role = localUser.getRole();

				if (role == 2) { // Neu User la Can Bo
					// Lay thong tin Can bo tu CSDL
					StaffCollection staffColl = new StaffCollection();
					Staff staff = staffColl.getByFieldName("staffId",
							localUser.getUserName());

					// Luu thong tin Can bo vao Session
					session.setAttribute("Staff", staff);
					
				} else if (role == 3) { // Neu User la Sinh vien
					// Lay thong tin Sinh vien tu CSDL
					StudentCollection studentColl = new StudentCollection();
					Student student = studentColl.getByFieldName("studentId",
							localUser.getUserName());
					
					// Luu thong tin Sinh vien vao Session
					session.setAttribute("Student", student);
					
				} else if (role == 1) {

				}

				// -> Chuyen sang Trang chu
				return new ModelAndView("redirect:/homepage/index.html");
			}

			// Else -> Quay lai trang Login + Message
			model.setViewName("login-page");
			model.addObject("User", user);
			model.addObject("message", "Tài khoản hoặc Mật khẩu không đúng.");
		} catch (NullPointerException e) {
			System.out.println("User khong ton tai");

			model.setViewName("login-page");
			model.addObject("User", user);
			model.addObject("message", "Tài khoản hoặc Mật khẩu không đúng.");
		}

		return model;
	}

	@RequestMapping(value = "/register")
	public String redirectRegister() {

		return "redirect:/register/form.html";
	}

	@RequestMapping(value = "/map")
	public String openMap() {

		return "map";
	}
}

// 