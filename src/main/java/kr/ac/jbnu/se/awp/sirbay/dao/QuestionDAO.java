package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public class QuestionDAO implements QuestionDAOIF {

	@Override
	public ResultSet questionSelect(int questionNum, String surveyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int questionInsert(int questionNum, String surveyID, String questionDesc, boolean isEssential,
			boolean isMultipleChoiceQuestion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int questionUpdate(String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int questionDelete(int questionNum, String surveyID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
