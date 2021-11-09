package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyAnswerDAOIF {
	public ResultSet surveyAnswerSelect(int questionNum, String surveyID);
	public int surveyAnswerInsert(int questionNum, String surveyID, String answer);
	public int surveyAnswerUpdate(int questionNum, String surveyID, String answer);
	public int surveyAnswerDelete(int questionNum, String surveyID);
}
