package kr.ac.jbnu.se.awp.sirbay.dao;

import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;

public interface QuestionDAOIF {
	public QuestionDTO questionSelect(int questionNum, int surveyID);
	public List<QuestionDTO> questionSelect(int surveyID);
	public int questionInsert(int questionNum, int surveyID, String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion);
	public int questionUpdate(String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion, int questionNum, int surveyID);
	public int questionDelete(int questionNum, int surveyID);
}
