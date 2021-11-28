package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyDAOIF {
	public ResultSet surveySelect(String surveyID);
	public ResultSet surveySelect();
	public int surveyInsert(String surveyID, String userID, String surveyCreatedTime, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyUpdate(String surveyID, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyDelete(String surveyID);
}
