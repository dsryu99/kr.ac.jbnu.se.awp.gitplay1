package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface MultipleChoiceQuestionItemDAOIF {
	public ResultSet multipleChoiceQuestionItemSelect(int itemNum, int questionNum, int surveyID);
	public ResultSet multipleChoiceQuestionItemSelect(int questionNum, int surveyID);
	public int multipleChoiceQuestionItemInsert(int itemNum, int questionNum, int surveyID, String itemContent);
	public int multipleChoiceQuestionItemUpdate(int itemNum, int questionNum, int surveyID, String itemContent);
	public int multipleChoiceQuestionItemDelete(int itemNum, int questionNum, int surveyID);
}
