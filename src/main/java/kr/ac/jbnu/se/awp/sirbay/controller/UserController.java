package kr.ac.jbnu.se.awp.sirbay.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userId");
		if(id == null) model.addAttribute("isLogin", false);
		else model.addAttribute("isLogin", true);
		
		return "page_main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("userId", request.getParameter("id"));
		model.addAttribute("isLogin", true);
		
		return "page_main";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String goRegister(Model model, HttpServletRequest request) {
			
		return "signUp";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest request) {
			
		return "redirect:";
	}
	
	@RequestMapping(value = "/unRegister", method = RequestMethod.GET)
	public String unRegister(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.POST)
	public String myPage(Model model, HttpServletRequest request) {
			
		return "page_myProfile";
	}
	
}
