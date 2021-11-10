package kr.ac.jbnu.se.awp.sirbay.dto;

public class SurveyJoinDTO {
	private String userID;
	private String surveyID;
	private String joinDate;//String firm "yyyyMMddHHmmSS"
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
