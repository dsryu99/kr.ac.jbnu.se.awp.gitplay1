package kr.ac.jbnu.se.awp.sirbay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {
	@RequestMapping(value = "/survey/create", method = RequestMethod.POST)
	public String goCreateSurvey(Model model, HttpServletRequest request) {
		
		return "page_survey_create";
	}
	
	@RequestMapping(value = "/survey/create/complete", method = RequestMethod.POST)
	public String createSurvey(Model model, HttpServletRequest request) {
		System.out.println("create");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/survey", method = RequestMethod.GET)
	public String goSurvey(Model model, HttpServletRequest request) {
		
		return "page_survey";
	}
	
	@RequestMapping(value = "/survey/join", method = RequestMethod.POST)
	public String joinSurvey(Model model, HttpServletRequest request) {
		
		return "redirect:/";
	}
}
