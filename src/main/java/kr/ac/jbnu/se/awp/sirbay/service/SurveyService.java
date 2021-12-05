package kr.ac.jbnu.se.awp.sirbay.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.se.awp.sirbay.dao.MultipleChoiceQuestionItemDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.QuestionDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyAnswerDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyJoinDAO;
import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;
@Service
public class SurveyService implements SurveyServiceIF {
	@Autowired
	SurveyDAO surveyDAO;
	@Autowired
	SurveyJoinDAO surveyJoinDAO;
	@Autowired
	SurveyAnswerDAO surveyAnswerDAO;
	@Autowired
	QuestionDAO questionDAO;
	@Autowired
	MultipleChoiceQuestionItemDAO multipleChoiceQuestionItemDAO;
	
	@Override
	public boolean addSurvey(String userId, String surveyTitle, List<QuestionDTO> questions,
			List<MultipleChoiceQuestionItemDTO> choiceAnswers) {
		try {
			String surveyCreatedTime = currentTime();
			int surveyID = surveyDAO.surveyInsert(userId, surveyCreatedTime, surveyTitle);
			for(QuestionDTO question: questions) {
				System.out.println(question.getQuestionNum());
				System.out.println(surveyID);
				System.out.println(question.getQuestionDesc());
				System.out.println(question.isEssential());
				System.out.println(question.isMultipleChoiceQuestion());
				questionDAO.questionInsert(question.getQuestionNum(), surveyID, question.getQuestionDesc(), question.isEssential(), question.isMultipleChoiceQuestion());
			}
			for(MultipleChoiceQuestionItemDTO item : choiceAnswers) {
				multipleChoiceQuestionItemDAO.multipleChoiceQuestionItemInsert(item.getItemNum(), item.getQuestionNum(), surveyID, item.getItemContent());
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuestionDTO> getSurvey(int surveyId) {
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		list = questionDAO.questionSelect(surveyId);
		if(list != null) {
			return list;
		}
		return null;//DB exception
	}

	@Override
	public List<MultipleChoiceQuestionItemDTO> getMultipleChoiceQuestions(int surveyId, int questionNum) {
		List<MultipleChoiceQuestionItemDTO> list = new ArrayList<MultipleChoiceQuestionItemDTO>();
		list = multipleChoiceQuestionItemDAO.multipleChoiceQuestionItemSelect(questionNum, surveyId);
		if(list != null) {
			return list;
		}
		return null;//DB exception
	}

	@Override
	public List<SurveyDTO> getAllSurveys() {
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		list = surveyDAO.surveySelect();
		if(list != null) {
			return list;
		}
		return null;//DB exception
	}

	@Override
	public boolean isAnswered(String userId, int surveyId) {
		int result = surveyJoinDAO.surveyJoinIsAnswered(userId, surveyId);
		if(result == 1) {
			return true;//already answered
		}
		return false;//not answered
	}

	@Override
	public boolean addAnswer(String userId, int surveyId, HashMap<Integer, String> answers) {
		try {
			for(Integer key : answers.keySet()) {
				surveyAnswerDAO.surveyAnswerInsert(key, surveyId, answers.get(key));
			}
			String joinDate = currentTime();
			surveyJoinDAO.surveyJoinInsert(userId, surveyId, joinDate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	private String currentTime() {
		Date dateNow = new Date(System.currentTimeMillis());
		SimpleDateFormat forteenFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = forteenFormat.format(dateNow);
		return currentTime;
	}
}
