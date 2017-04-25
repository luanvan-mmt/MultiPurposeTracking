package controller;

import javax.servlet.http.HttpServletRequest;

import model.CanBo;
import model.SinhVien;
import mongodb.CanBoCollection;
import mongodb.SinhVienCollection;
import mongodb.UserCollection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.SendEmail;

@Controller
@RequestMapping(value = "/register")
public class Regsiter {

	private SinhVienCollection studentColl = new SinhVienCollection();
	private CanBoCollection staffColl = new CanBoCollection();
	private UserCollection userColl = new UserCollection();

	// ------------ CREATE REGISTER FORM ------------------------------

	@RequestMapping(value = "/form")
	public ModelAndView registerForm() {
		ModelAndView model = new ModelAndView("register-page");
		model.addObject("Student", new SinhVien());
		model.addObject("Staff", new CanBo());

		return model;
	}

	// ------------ HANDLE REGISTER FORM ------------------------------

	@RequestMapping(value = "/handle-student", method = RequestMethod.POST)
	public ModelAndView handleStudentRegister(
			@ModelAttribute("Student") SinhVien student) {
		studentColl.save(student);

		// Khoi tao user voi password ngau nhien
		String password = userColl.autoCreateUser(student.getMssv(), 3);

		// Gui password dang nhap he thong qua email
		SendEmail.sendEmail(student.getEmail(), password);

		ModelAndView model = new ModelAndView("redirect:/login/form.html");

		return model;
	}

	@RequestMapping(value = "/handle-staff", method = RequestMethod.POST)
	public ModelAndView handleStaffRegister(@ModelAttribute("Staff") CanBo staff) {
		staffColl.save(staff);

		// Khoi tao User:
		String password = userColl.autoCreateUser(staff.getMscb(), 2);

		// Gui password:
		SendEmail.sendEmail(staff.getEmail(), password);

		ModelAndView model = new ModelAndView("redirect:/login/form.html");

		return model;
	}

	@RequestMapping(value = "/login")
	public String quayLai() {

		return "redirect:/login/form.html";
	}

	@RequestMapping(value = "/sendEmail")
	public String sendPasswordToEmail(HttpServletRequest request) {
		// String StudentId = request.getParameter("studentId");
		String email = request.getParameter("email");

		SendEmail.sendEmail(email, "123456789");

		return "redirect:/login/form.html";
	}

}

// End