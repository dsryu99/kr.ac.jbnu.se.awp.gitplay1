package kr.ac.jbnu.se.awp.sirbay.dto;

import java.util.Date;

public class SurveyJoinDTO {
	private String userID;
	private String surveyID;
	private Date joinDate;//DateÇü½ÄÀº "yyyy-MM-dd HH:mm:SS"
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
