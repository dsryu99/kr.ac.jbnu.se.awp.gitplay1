package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface SurveyJoinDAOIF {
	public ResultSet surveyJoinSelect(String userID, int surveyID);
	public int surveyJoinInsert(String userID, int surveyID, String joinDate);
	public int surveyJoinUpdate(String userID, int surveyID, String joinDate);
	public int surveyJoinDelete(String userID, int surveyID);
}
