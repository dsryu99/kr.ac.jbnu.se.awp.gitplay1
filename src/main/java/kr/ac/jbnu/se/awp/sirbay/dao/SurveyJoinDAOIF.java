package kr.ac.jbnu.se.awp.sirbay.dao;

public interface SurveyJoinDAOIF {
	public int surveyJoinIsAnswered(String userID, int surveyID);
	public int surveyJoinInsert(String userID, int surveyID, String joinDate);
	public int surveyJoinUpdate(String userID, int surveyID, String joinDate);
	public int surveyJoinDelete(String userID, int surveyID);
}
