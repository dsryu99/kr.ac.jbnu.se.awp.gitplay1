package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;
import java.util.Date;

public class SurveyJoinDAO implements SurveyJoinDAOIF {

	@Override
	public ResultSet surveyJoinSelect(String userID, String surveyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int surveyJoinInsert(String userID, String surveyID, Date joinDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyJoinUpdate(Date joinDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int surveyJoinDelete(String userID, String surveyID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
