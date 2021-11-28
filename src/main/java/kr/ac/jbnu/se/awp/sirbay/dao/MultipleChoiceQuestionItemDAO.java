package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;

public class MultipleChoiceQuestionItemDAO implements MultipleChoiceQuestionItemDAOIF {

	@Override
	public ResultSet multipleChoiceQuestionItemSelect(int itemNum, int questionNum, String surveyID) {
		String SQL = "SELECT * FROM multipleChoiceQuestionItem WHERE itemNum = ? AND questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, itemNum);
			pstmt.setInt(2, questionNum);
			pstmt.setString(3, surveyID);
			rs = pstmt.executeQuery();
			return rs;//result
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
	public ResultSet multipleChoiceQuestionItemSelect(int questionNum, String surveyID) {
		String SQL = "SELECT * FROM multipleChoiceQuestionItem WHERE questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionNum);
			pstmt.setString(2, surveyID);
			rs = pstmt.executeQuery();
			return rs;//result
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
	public int multipleChoiceQuestionItemInsert(int itemNum, int questionNum, String surveyID, String itemContent) {
		String SQL = "INSERT INTO multipleChoiceQuestionItem VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, itemNum);
			pstmt.setInt(2, questionNum);
			pstmt.setString(3, surveyID);
			pstmt.setString(4, itemContent);
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
	public int multipleChoiceQuestionItemUpdate(int itemNum, int questionNum, String surveyID, String itemContent) {
		String SQL = "UPDATE multipleChoiceQuestionItem SET itemContent = ? WHERE itemNum = ? AND questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, itemContent);
			pstmt.setInt(2, itemNum);
			pstmt.setInt(3, questionNum);
			pstmt.setString(4, surveyID);
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
	public int multipleChoiceQuestionItemDelete(int itemNum, int questionNum, String surveyID) {
		String SQL = "DELETE FROM multipleChoiceQuestionItem WHERE itemNum = ? AND questionNum = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, itemNum);
			pstmt.setInt(2, questionNum);
			pstmt.setString(3, surveyID);
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
