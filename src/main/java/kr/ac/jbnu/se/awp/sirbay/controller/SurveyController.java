package kr.ac.jbnu.se.awp.sirbay.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyAnswerDTO;
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
//		Map<String, String[]> map = request.getParameterMap();
//		for(Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
//			String key = it.next();
//			String[] values = map.get(key);
//			System.out.println("key: " + key);
//			System.out.println("values:");
//			for(String value: values) {
//				System.out.println(value);
//			}
//		}
//		StringBuilder subject = new StringBuilder("subject");
//		int count = 1;
//		while(request.getParameter(subject.append(count).toString()) != null) {
//			count++;
//		}
		
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
	
	@RequestMapping(value = "/survey/join", method = RequestMethod.GET)
	public String goJoinSurvey(Model model, HttpServletRequest request) {
		int surveyId = Integer.parseInt(request.getParameter("id"));
		String surveyTitle = request.getParameter("title");
		List<QuestionDTO> questions = surveyService.getSurvey(surveyId);
		List<List<MultipleChoiceQuestionItemDTO>> multipleChoiceQuestions = new ArrayList<List<MultipleChoiceQuestionItemDTO>>();
		for(QuestionDTO question : questions) {
			if(question.getIsMultipleChoiceQuestion()) {
				List<MultipleChoiceQuestionItemDTO> multipleQuestions = surveyService.getMultipleChoiceQuestions(surveyId, question.getQuestionNum());
				multipleChoiceQuestions.add(multipleQuestions);
			}
		}
		model.addAttribute("surveyTitle", surveyTitle);
		model.addAttribute("surveyId", surveyId);
		model.addAttribute("questions", questions);
		model.addAttribute("multipleQuestions", multipleChoiceQuestions);
		return "page_survey_join";
	}
	
	@RequestMapping(value = "/survey/result", method = RequestMethod.GET)
	public String goSurveyResult(Model model, HttpServletRequest request) {
		int surveyId = Integer.parseInt(request.getParameter("id"));
		String surveyTitle = request.getParameter("title");
		System.out.println("title: " + surveyTitle);
		List<QuestionDTO> questions = surveyService.getSurvey(surveyId);
		List<SurveyAnswerDTO> answers = surveyService.getAnswers(surveyId);
		for(QuestionDTO question : questions) {
			System.out.print(question.getQuestionNum() + "번 질문 : ");
			System.out.println(question.getQuestionDesc());
			if(question.getIsMultipleChoiceQuestion()) {
				List<MultipleChoiceQuestionItemDTO> multipleQuestions = surveyService.getMultipleChoiceQuestions(2, 2);
				for(MultipleChoiceQuestionItemDTO multipleQuestion : multipleQuestions) {
					System.out.print(multipleQuestion.getItemNum() + " 번 답 : ");
					System.out.println(multipleQuestion.getItemContent());
				}
			}
		}
		for(SurveyAnswerDTO answer : answers) {
			System.out.print(answer.getQuestionNum() + "번 질문 : ");
			System.out.println(answer.getAnswer());
			System.out.println("답변 횟수: " + answer.getCount());
		}
		return "page_survey_result";
	}
	
	@RequestMapping(value = "/survey/join/complete", method = RequestMethod.POST)
	public String joinSurvey(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		if(surveyService.isAnswered(userId, surveyId)) return "redirect:/";
		
		HashMap<Integer, String> answers = new HashMap<Integer, String>();
		answers.put(1, "hello");
		answers.put(2, "1");
		surveyService.addAnswer(userId, surveyId, answers);
		return "redirect:/";
	}
}
