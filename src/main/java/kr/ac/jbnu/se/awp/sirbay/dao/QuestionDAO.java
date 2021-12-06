package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
import kr.ac.jbnu.se.awp.sirbay.dto.QuestionDTO;
@Repository("questionDAO")
public class QuestionDAO implements QuestionDAOIF {

	@Override
	public QuestionDTO questionSelect(int questionNum, int surveyID) {
		String SQL = "SELECT * FROM question WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuestionDTO questionDTO = new QuestionDTO();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				questionDTO.setQuestionNum(rs.getInt(1));
				questionDTO.setSurveyID(rs.getInt(2));
				questionDTO.setQuestionDesc(rs.getString(3));
				questionDTO.setEssential(rs.getBoolean(4));
				questionDTO.setMultipleChoiceQuestion(rs.getBoolean(5));
			}
			return questionDTO;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return null;//DB error
	}
	
	@Override
	public List<QuestionDTO> questionSelect(int surveyID) {
		String SQL = "SELECT * FROM question WHERE surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setQuestionNum(rs.getInt(1));
				questionDTO.setSurveyID(rs.getInt(2));
				questionDTO.setQuestionDesc(rs.getString(3));
				questionDTO.setEssential(rs.getBoolean(4));
				questionDTO.setMultipleChoiceQuestion(rs.getBoolean(5));
				list.add(questionDTO);
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return null;//DB error
	}

	@Override
	public int questionInsert(int questionNum, int surveyID, String questionDesc, boolean isEssential,
			boolean isMultipleChoiceQuestion) {
		String SQL = "INSERT INTO question VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			pstmt.setString(3, questionDesc);
			pstmt.setBoolean(4, isEssential);
			pstmt.setBoolean(5, isMultipleChoiceQuestion);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB오류
	}

	@Override
	public int questionUpdate(String questionDesc, boolean isEssential, boolean isMultipleChoiceQuestion, int questionNum, int surveyID) {
		String SQL = "UPDATE question SET questionDesc = ? ,isEssential = ?, isMultipleChoiceQuestion = ? WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, questionDesc);
			pstmt.setBoolean(2, isEssential);
			pstmt.setBoolean(3, isMultipleChoiceQuestion);
			pstmt.setInt(4, questionNum);
			pstmt.setInt(5, surveyID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB오류
	}

	@Override
	public int questionDelete(int questionNum, int surveyID) {
		String SQL = "DELETE FROM question WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB오류
	}

}
