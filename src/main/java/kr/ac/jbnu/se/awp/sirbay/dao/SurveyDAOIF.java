package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyDAOIF {
	public ResultSet surveySelect(int surveyID);
	public ResultSet surveySelect();
	public int surveyInsert(String userID, String surveyCreatedTime, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyInsert(String userID, String surveyCreatedTime, String surveyTitle);
	public int surveyUpdate(int surveyID, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyDelete(int surveyID);
}
