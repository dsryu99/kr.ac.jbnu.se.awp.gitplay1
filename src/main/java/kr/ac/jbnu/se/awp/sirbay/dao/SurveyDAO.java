package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;
import java.util.Date;

public class SurveyDAO implements SurveyDAOIF {

	@Override
	public ResultSet surveySelect(String surveyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int surveyInsert(String surveyID, String userID, Date surveyCreatedTime, Date surveyStartTime,
			Date surveyEndTime, String surveyTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyUpdate(Date surveyStartTime, Date surveyEndTime, String surveyTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyDelete(String surveyID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
