package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface QuestionDAOIF {
	public ResultSet questionSelect(int questionNum, int surveyID);
	public ResultSet questionSelect(int surveyID);
	public int questionInsert(int questionNum, int surveyID, String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion);
	public int questionUpdate(String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion, int questionNum, int surveyID);
	public int questionDelete(int questionNum, int surveyID);
}
