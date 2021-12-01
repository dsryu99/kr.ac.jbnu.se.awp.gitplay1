package kr.ac.jbnu.se.awp.sirbay.dto;

public class SurveyJoinDTO {
	private String userID;
	private int surveyID;
	private String joinDate;//String firm "yyyyMMddHHmmSS"
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
