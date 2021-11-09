package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyJoinDAOIF {
	public ResultSet surveyJoinSelect(String userID, String surveyID);
	public int surveyJoinInsert(String userID, String surveyID, String joinDate);
	public int surveyJoinUpdate(String userID, String surveyID, String joinDate);
	public int surveyJoinDelete(String userID, String surveyID);
}
