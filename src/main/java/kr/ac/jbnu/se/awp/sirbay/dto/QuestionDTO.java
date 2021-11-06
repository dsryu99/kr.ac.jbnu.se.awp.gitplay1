package kr.ac.jbnu.se.awp.sirbay.dto;

public class QuestionDTO {
	private int questionNum;
	private String surveyID;
	private String questionDesc;
	private boolean isEssential;
	private boolean isMultipleChoiceQuestion;
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public boolean isEssential() {
		return isEssential;
	}
	public void setEssential(boolean isEssential) {
		this.isEssential = isEssential;
	}
	public boolean isMultipleChoiceQuestion() {
		return isMultipleChoiceQuestion;
	}
	public void setMultipleChoiceQuestion(boolean isMultipleChoiceQuestion) {
		this.isMultipleChoiceQuestion = isMultipleChoiceQuestion;
	}
}
