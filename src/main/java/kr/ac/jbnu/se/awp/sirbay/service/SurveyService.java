package kr.ac.jbnu.se.awp.sirbay.service;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
			String surveyCreatedTime = currentTime();
			surveyDAO.surveyInsert(userId, surveyCreatedTime, surveyTitle);
			//pls fix
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuestionDTO> getSurvey(int surveyId) {
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
	public List<MultipleChoiceQuestionItemDTO> getMultipleChoiceQuestions(int surveyId, int questionNum) {
		try {
			List<MultipleChoiceQuestionItemDTO> list = new ArrayList<MultipleChoiceQuestionItemDTO>();
			ResultSet rs = multipleChoiceQuestionItemDAO.multipleChoiceQuestionItemSelect(questionNum, surveyId);
			while(rs.next()) {
				MultipleChoiceQuestionItemDTO multipleChoiceQuestionItemDTO = new MultipleChoiceQuestionItemDTO();
				multipleChoiceQuestionItemDTO.setItemNum(rs.getInt(1));
				multipleChoiceQuestionItemDTO.setQuestionNum(rs.getInt(2));
				multipleChoiceQuestionItemDTO.setSurveyID(rs.getString(3));
				multipleChoiceQuestionItemDTO.setItemContent(rs.getString(4));
				list.add(multipleChoiceQuestionItemDTO);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;//DB exception
	}

	@Override
	public List<SurveyDTO> getAllSurveys() {
		try {
			List<SurveyDTO> list = new ArrayList<SurveyDTO>();
			ResultSet rs = surveyDAO.surveySelect();
			while(rs.next()) {
				SurveyDTO surveyDTO = new SurveyDTO();
				surveyDTO.setSurveyID(rs.getInt(1));
				surveyDTO.setUserID(rs.getString(2));
				surveyDTO.setSurveyCreatedTime(rs.getDate(3));
				surveyDTO.setSurveyStartTime(rs.getDate(4));
				surveyDTO.setSurveyEndTime(rs.getDate(5));
				surveyDTO.setSurveyTitle(rs.getString(6));
				list.add(surveyDTO);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;//DB exception
	}

	@Override
	public boolean isAnswered(String userId, int surveyId) {
		try {
			ResultSet rs = surveyJoinDAO.surveyJoinSelect(userId, surveyId);
			if(rs.next()) {
				return true;//already answered
			}
			return false;//not answered
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;//DB error
	}

	@Override
	public boolean addAnswer(String userId, int surveyId, HashMap<Integer, String> answers) {
		try {
			for(int key : answers.keySet()) {
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
