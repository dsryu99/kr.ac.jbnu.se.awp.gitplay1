package kr.ac.jbnu.se.awp.sirbay.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String surveyTitle = request.getParameter("surveyTitle");
		List<QuestionDTO> questions = new ArrayList<QuestionDTO>();
		List<MultipleChoiceQuestionItemDTO> choiceAnswers = new ArrayList<MultipleChoiceQuestionItemDTO>();
		
		Map<String, String[]> map = request.getParameterMap();
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String[] values = map.get(key);
			if(key.contains("title")) {
				int questionNum = Integer.parseInt(key.split("title")[1]);
				String radio = "radio" + questionNum;
				QuestionDTO question = new QuestionDTO();
				question.setEssential(false);
				question.setQuestionNum(questionNum);
				question.setQuestionDesc(values[0]);
				question.setMultipleChoiceQuestion(false);
				String radioValue = map.get(radio)[0];
				if(radioValue.equals("choice")) {
					question.setMultipleChoiceQuestion(true);
					String[] selections = map.get("selection" + questionNum);
					for(int i=0; i<selections.length; i++) {
						MultipleChoiceQuestionItemDTO mc = new MultipleChoiceQuestionItemDTO();
						mc.setItemNum(questionNum);
						mc.setItemContent(selections[i]);
						mc.setQuestionNum(i+1);
						choiceAnswers.add(mc);
					}
				}
				questions.add(question);
			}
		}
		
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
		System.out.println(surveyService.isAnswered(userId, surveyId));
		if(surveyService.isAnswered(userId, surveyId)) return "redirect:/";
		
		HashMap<Integer, String> answers = new HashMap<Integer, String>();
		Map<String, String[]> params = request.getParameterMap();
		for(Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String value = params.get(key)[0];
			if(key.contains("subjectiveAnswer")) {
				int questionNum = Integer.parseInt(key.split("subjectiveAnswer")[1]);
				answers.put(questionNum, value);
			} else if(key.contains("multipleAnswer")) {
				int questionNum = Integer.parseInt(key.split("multipleAnswer")[1]);
				answers.put(questionNum, value);
			}
		}
		surveyService.addAnswer(userId, surveyId, answers);
		return "redirect:/";
	}
}
