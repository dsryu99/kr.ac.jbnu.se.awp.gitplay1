package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyAnswerDAOIF {
	public int surveyAnswerSelect(int questionNum, int surveyID);
	public int surveyAnswerInsert(int questionNum, int surveyID, String answer);
	public int surveyAnswerUpdate(int questionNum, int surveyID, String answer);
	public int surveyAnswerDelete(int questionNum, int surveyID);
}
