package kr.ac.jbnu.se.awp.sirbay.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;

public interface SurveyServiceIF {
	boolean addSurvey(String userId, String surveyTitle, List<QuestionDTO> questions, List<MultipleChoiceQuestionItemDTO> choiceAnswers);
	List<QuestionDTO> getSurvey(int surveyId);
	List<MultipleChoiceQuestionItemDTO> getMultipleChoiceQuestions(int surveyId, int questionNum);
	boolean isAnswered(String userId, int surveyId);
	boolean addAnswer(String userId, int surveyId, HashMap<Integer, String> answers);
	List<SurveyDTO> getAllSurveys();
}
