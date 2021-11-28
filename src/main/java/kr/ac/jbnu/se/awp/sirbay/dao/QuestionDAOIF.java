package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface QuestionDAOIF {
	public ResultSet questionSelect(int questionNum, String surveyID);
	public ResultSet questionSelect(String surveyID);
	public int questionInsert(int questionNum, String surveyID, String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion);
	public int questionUpdate(String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion, int questionNum, String surveyID);
	public int questionDelete(int questionNum, String surveyID);
}
