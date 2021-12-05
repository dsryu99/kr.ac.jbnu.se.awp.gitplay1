package kr.ac.jbnu.se.awp.sirbay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.jbnu.se.awp.sirbay.dto.UserDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;
import kr.ac.jbnu.se.awp.sirbay.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userId");
		if(id == null) model.addAttribute("isLogin", false);
		else model.addAttribute("isLogin", true);
		return "page_main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		boolean isValid = userService.isUserValid(id, password);
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", request.getParameter("id"));
			model.addAttribute("isLogin", true);
			return "page_main";
		} else {
			model.addAttribute("isLogin", false);
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String goRegister(Model model, HttpServletRequest request) {
		return "page_register";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String register(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int birthYear = Integer.parseInt(request.getParameter("birth_yy"));
		int birthMonth = Integer.parseInt(request.getParameter("birth_mm"));
		int birthDay = Integer.parseInt(request.getParameter("birth_dd"));
		String email = request.getParameter("email_1") + "@" + request.getParameter("email_2");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Date birth = new Date(birthYear, birthMonth, birthDay);
		String job = "무직";
		userService.addUser(id, password, name, birth, job, address, gender);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/unRegister", method = RequestMethod.GET)
	public String unRegister(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		userService.deleteUser(userId);
		session.invalidate();
		return "redirect:";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.POST)
	public String myPage(Model model, HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("userId");
		UserInfoDTO user = userService.getUser(id);
		model.addAttribute("user", user);
		return "page_myPage";
	}
	
}
