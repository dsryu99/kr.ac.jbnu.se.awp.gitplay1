package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public class SurveyDAO implements SurveyDAOIF {

	@Override
	public ResultSet surveySelect(String surveyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int surveyInsert(String surveyID, String userID, String surveyCreatedTime, String surveyStartTime,
			String surveyEndTime, String surveyTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyUpdate(String surveyStartTime, String surveyEndTime, String surveyTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyDelete(String surveyID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
