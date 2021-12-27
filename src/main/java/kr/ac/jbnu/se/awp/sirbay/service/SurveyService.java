package kr.ac.jbnu.se.awp.sirbay.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.se.awp.sirbay.dao.MultipleChoiceQuestionItemDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.MultipleChoiceQuestionItemDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dao.QuestionDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.QuestionDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyAnswerDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyAnswerDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyJoinDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.SurveyJoinDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyAnswerDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;
@Service
public class SurveyService implements SurveyServiceIF {
	SurveyDAOIF surveyDAO;
	SurveyJoinDAOIF surveyJoinDAO;
	SurveyAnswerDAOIF surveyAnswerDAO;
	QuestionDAOIF questionDAO;
	MultipleChoiceQuestionItemDAOIF multipleChoiceQuestionItemDAO;
	
	@Autowired
	private void setSurveyDAO(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}
	@Autowired
	private void setSurveyJoinDAO(SurveyJoinDAO surveyJoinDAO) {
		this.surveyJoinDAO = surveyJoinDAO;
	}
	@Autowired
	private void setSurveyAnswerDAO(SurveyAnswerDAO surveyAnswerDAO) {
		this.surveyAnswerDAO = surveyAnswerDAO;
	}
	@Autowired
	private void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	@Autowired
	private void setMultipleChoiceQuestionItemDAO(MultipleChoiceQuestionItemDAO multipleChoiceQuestionItemDAO) {
		this.multipleChoiceQuestionItemDAO = multipleChoiceQuestionItemDAO;
	}
	
	@Override
	public boolean addSurvey(String userId, String surveyTitle, List<QuestionDTO> questions,
			List<MultipleChoiceQuestionItemDTO> choiceAnswers) {
		try {
			String surveyCreatedTime = currentTime();
			int surveyID = surveyDAO.surveyInsert(userId, surveyCreatedTime, surveyTitle);
			for(QuestionDTO question: questions) {
				questionDAO.questionInsert(question.getQuestionNum(), surveyID, question.getQuestionDesc(), question.isEssential(), question.getIsMultipleChoiceQuestion());
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
			int count = 0;
			for(Integer key : answers.keySet()) {
				count = surveyAnswerDAO.surveyAnswergetCount(key, surveyId, answers.get(key));
				if(count == -1) {//first generation
					System.out.println("first");
					surveyAnswerDAO.surveyAnswerInsert(key, surveyId, answers.get(key), 1);
				} else if(count == -2) {//DB exception
					System.out.println("DB");
					return false;
				} else {//success
					System.out.println("success");
					surveyAnswerDAO.surveyAnswerUpdate(key, surveyId, answers.get(key), count+1);
				}
			}
			String joinDate = currentTime();
			surveyJoinDAO.surveyJoinInsert(userId, surveyId, joinDate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("exception");
		return false;
	}
	
	private String currentTime() {
		Date dateNow = new Date(System.currentTimeMillis());
		SimpleDateFormat forteenFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = forteenFormat.format(dateNow);
		return currentTime;
	}

	@Override
	public List<SurveyAnswerDTO> getAnswers(int surveyId) {
		List<SurveyAnswerDTO> list = new ArrayList<SurveyAnswerDTO>();
		list = surveyAnswerDAO.surveyAnswergetAllAnswer(surveyId);
		if(list != null) {
			return list;
		}
		return null;//DB exception
	}
}
