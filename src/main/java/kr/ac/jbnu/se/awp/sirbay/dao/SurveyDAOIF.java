package kr.ac.jbnu.se.awp.sirbay.dao;

import java.util.List;

import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;

public interface SurveyDAOIF {
	public SurveyDTO surveySelect(int surveyID);
	public List<SurveyDTO> surveySelect();
//	public int surveyInsert(String userID, String surveyCreatedTime, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyInsert(String userID, String surveyCreatedTime, String surveyTitle);
	public int surveyUpdate(int surveyID, String surveyStartTime, String surveyEndTime, String surveyTitle);
	public int surveyDelete(int surveyID);
}
