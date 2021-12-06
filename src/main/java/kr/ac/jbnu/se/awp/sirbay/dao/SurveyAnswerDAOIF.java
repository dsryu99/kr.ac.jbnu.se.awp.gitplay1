package kr.ac.jbnu.se.awp.sirbay.dao;

import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.SurveyAnswerDTO;

public interface SurveyAnswerDAOIF {
	public int surveyAnswergetCount(int questionNum, int surveyID, String answer);
	public int surveyAnswergetAnswer(int questionNum, int surveyID);
	public List<SurveyAnswerDTO> surveyAnswergetAllAnswer(int surveyID);
	public int surveyAnswerInsert(int questionNum, int surveyID, String answer, int count);
	public int surveyAnswerUpdate(int questionNum, int surveyID, String answer, int count);
	public int surveyAnswerDelete(int questionNum, int surveyID);
}
