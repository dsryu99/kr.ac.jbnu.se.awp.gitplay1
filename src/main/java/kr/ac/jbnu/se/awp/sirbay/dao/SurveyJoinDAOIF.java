package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;
import java.util.Date;

public interface SurveyJoinDAOIF {
	public ResultSet surveyJoinSelect(String userID, String surveyID);
	public int surveyJoinInsert(String userID, String surveyID, Date joinDate);
	public int surveyJoinUpdate(Date joinDate);
	public int surveyJoinDelete(String userID, String surveyID);
}
