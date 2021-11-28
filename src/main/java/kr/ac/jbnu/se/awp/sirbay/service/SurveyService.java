package kr.ac.jbnu.se.awp.sirbay.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.jbnu.se.awp.sirbay.dao.MultipleChoiceQuestionItemDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.QuestionDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyAnswerDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyJoinDAO;
import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;

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
	public boolean addSurvey(String userId, String surveyTitle, HashMap<Integer, String> questions,
			List<MultipleChoiceQuestionItemDTO> choiceAnswers) {
		try {
			surveyDAO.surveyInsert(surveyTitle, userId, surveyTitle, surveyTitle, userId, surveyTitle);
			//pls fix
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuestionDTO> getSurvey(String surveyId) {
		try {
			List<QuestionDTO> list = new ArrayList<QuestionDTO>();
			ResultSet rs = questionDAO.questionSelect(surveyId);
			while(rs.next()) {
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setQuestionNum(rs.getInt(1));
				questionDTO.setSurveyID(rs.getString(2));
				questionDTO.setQuestionDesc(rs.getString(3));
				questionDTO.setEssential(rs.getBoolean(4));
				questionDTO.setMultipleChoiceQuestion(rs.getBoolean(5));
				list.add(questionDTO);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;//DB exception
	}

	@Override
	public List<MultipleChoiceQuestionItemDTO> getMultipleChoiceQuestions(String surveyId, int questionNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveyDTO> getAllSurveys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnswered(String userId, String surveyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAnswer(String userId, String surveyId, HashMap<Integer, String> answers) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
