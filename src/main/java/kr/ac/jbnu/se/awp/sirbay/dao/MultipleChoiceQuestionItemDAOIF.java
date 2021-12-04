package kr.ac.jbnu.se.awp.sirbay.dao;

import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.MultipleChoiceQuestionItemDTO;

public interface MultipleChoiceQuestionItemDAOIF {
	public MultipleChoiceQuestionItemDTO multipleChoiceQuestionItemSelect(int itemNum, int questionNum, int surveyID);
	public List<MultipleChoiceQuestionItemDTO> multipleChoiceQuestionItemSelect(int questionNum, int surveyID);
	public int multipleChoiceQuestionItemInsert(int itemNum, int questionNum, int surveyID, String itemContent);
	public int multipleChoiceQuestionItemUpdate(int itemNum, int questionNum, int surveyID, String itemContent);
	public int multipleChoiceQuestionItemDelete(int itemNum, int questionNum, int surveyID);
}
