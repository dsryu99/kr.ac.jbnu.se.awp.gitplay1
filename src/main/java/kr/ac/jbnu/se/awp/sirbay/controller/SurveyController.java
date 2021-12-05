package kr.ac.jbnu.se.awp.sirbay.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.service.SurveyService;

@Controller
public class SurveyController {
	@Autowired
	SurveyService surveyService;
	
	@RequestMapping(value = "/survey/create", method = RequestMethod.POST)
	public String goCreateSurvey(Model model, HttpServletRequest request) {
		
		return "page_survey_create";
	}
	
	@RequestMapping(value = "/survey/create/complete", method = RequestMethod.POST)
	public String createSurvey(Model model, HttpServletRequest request) {
		System.out.println("create");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
//		String surveyTitle = request.getParameter("title");
		String surveyTitle = "title2";
		List<QuestionDTO> questions = new ArrayList<QuestionDTO>();
		List<MultipleChoiceQuestionItemDTO> choiceAnswers = new ArrayList<MultipleChoiceQuestionItemDTO>();
		QuestionDTO question = new QuestionDTO();
		question.setEssential(true);
		question.setMultipleChoiceQuestion(false);
		question.setQuestionDesc("question1");
		question.setQuestionNum(1);
		QuestionDTO question2 = new QuestionDTO();
		question2.setEssential(false);
		question2.setMultipleChoiceQuestion(true);
		question2.setQuestionDesc("question2");
		question2.setQuestionNum(2);
		MultipleChoiceQuestionItemDTO mc1 = new MultipleChoiceQuestionItemDTO();
		mc1.setItemNum(1);
		mc1.setItemContent("content1");
		mc1.setQuestionNum(2);
		MultipleChoiceQuestionItemDTO mc2 = new MultipleChoiceQuestionItemDTO();
		mc2.setItemNum(2);
		mc2.setItemContent("content2");
		mc2.setQuestionNum(2);
		questions.add(question);
		questions.add(question2);
		choiceAnswers.add(mc1);
		choiceAnswers.add(mc2);
		surveyService.addSurvey(userId, surveyTitle, questions, choiceAnswers);
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
