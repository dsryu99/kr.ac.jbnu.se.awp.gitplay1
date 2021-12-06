package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyAnswerDTO;
@Repository("surveyAnswerDAO")
public class SurveyAnswerDAO implements SurveyAnswerDAOIF {

	@Override
	public int surveyAnswergetCount(int questionNum, int surveyID) {
		String SQL = "SELECT count FROM surveyAnswer WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
				return count;//result
			}
			return -1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -2;//DB error
	}
	
	@Override
	public int surveyAnswergetAnswer(int questionNum, int surveyID) {
		String SQL = "SELECT answer FROM surveyAnswer WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int answer = 0;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				answer = rs.getInt(1);
			}
			return answer;//result
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB error
	}
	
	@Override
	public List<SurveyAnswerDTO> surveyAnswergetAllAnswer(int surveyID) {
		String SQL = "SELECT * FROM surveyAnswer WHERE surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SurveyAnswerDTO> list = new ArrayList<SurveyAnswerDTO>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyAnswerDTO surveyAnswerDTO = new SurveyAnswerDTO();
				surveyAnswerDTO.setQuestionNum(rs.getInt(1));
				surveyAnswerDTO.setSurveyID(rs.getInt(2));
				surveyAnswerDTO.setAnswer(rs.getString(3));
				surveyAnswerDTO.setCount(rs.getInt(4));
				list.add(surveyAnswerDTO);
			}
			return list;//result
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
	public int surveyAnswerInsert(int questionNum, int surveyID, String answer, int count) {
		String SQL = "INSERT INTO surveyAnswer VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setInt(2, surveyID);
			pstmt.setString(3, answer);
			pstmt.setInt(4, count);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB error
	}

	@Override
	public int surveyAnswerUpdate(int questionNum, int surveyID, String answer, int count) {
		String SQL = "UPDATE surveyAnswer SET answer = ?, count = ? WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, answer);
			pstmt.setInt(2, count);
			pstmt.setInt(3, questionNum);
			pstmt.setInt(4, surveyID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB error
	}

	@Override
	public int surveyAnswerDelete(int questionNum, int surveyID) {
		String SQL = "DELETE FROM surveyAnswer WHERE questionNum = ? AND surveyID = ?";
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
		return -1;//DB error
	}

}
