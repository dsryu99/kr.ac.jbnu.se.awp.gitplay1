package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface MultipleChoiceQuestionItemDAOIF {
	public ResultSet multipleChoiceQuestionItemSelect(int itemNum, int questionNum, String surveyID);
	public int multipleChoiceQuestionItemInsert(int itemNum, int questionNum, String surveyID, String itemContent);
	public int multipleChoiceQuestionItemUpdate(int itemNum, int questionNum, String surveyID, String itemContent);
	public int multipleChoiceQuestionItemDelete(int itemNum, int questionNum, String surveyID);
}
