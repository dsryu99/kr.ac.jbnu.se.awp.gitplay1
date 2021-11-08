package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;
import java.util.Date;

public interface SurveyDAOIF {
	public ResultSet surveySelect(String surveyID);
	public int surveyInsert(String surveyID, String userID, Date surveyCreatedTime, Date surveyStartTime, Date surveyEndTime, String surveyTitle);
	public int surveyUpdate(Date surveyStartTime, Date surveyEndTime, String surveyTitle);
	public int surveyDelete(String surveyID);
}
