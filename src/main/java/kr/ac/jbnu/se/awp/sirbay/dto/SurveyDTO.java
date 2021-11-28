package kr.ac.jbnu.se.awp.sirbay.dto;

import java.util.Date;

public class SurveyDTO {
	private String surveyID;
	private String userID;
	private Date surveyCreatedTime;//DateÇü½ÄÀº "yyyy-MM-dd HH:mm:SS"
	private Date surveyStartTime;
	private Date surveyEndTime;
	private String surveyTitle;
	public String getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getSurveyCreatedTime() {
		return surveyCreatedTime;
	}
	public void setSurveyCreatedTime(Date usrveyCreatedTime) {
		this.surveyCreatedTime = usrveyCreatedTime;
	}
	public Date getSurveyStartTime() {
		return surveyStartTime;
	}
	public void setSurveyStartTime(Date surveyStartTime) {
		this.surveyStartTime = surveyStartTime;
	}
	public Date getSurveyEndTime() {
		return surveyEndTime;
	}
	public void setSurveyEndTime(Date surveyEndTime) {
		this.surveyEndTime = surveyEndTime;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
}
