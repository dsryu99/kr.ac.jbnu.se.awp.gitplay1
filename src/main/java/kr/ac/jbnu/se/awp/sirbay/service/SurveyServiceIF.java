package kr.ac.jbnu.se.awp.sirbay.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;

public interface SurveyServiceIF {
	boolean addSurvey(String userId, HashMap<Integer, String> questions, List<MultipleChoiceQuestionItemDTO> choiceAnswers);
	List<QuestionDTO> getSurvey(String surveyId);
	boolean addAnswer(String surveyId, HashMap<Integer, String> answers);
	List<SurveyDTO> getAllSurveys();
}
