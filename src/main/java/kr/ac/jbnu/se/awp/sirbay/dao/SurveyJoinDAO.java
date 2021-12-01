package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;

public class SurveyJoinDAO implements SurveyJoinDAOIF {

	@Override
	public ResultSet surveyJoinSelect(String userID, int surveyID) {
		String SQL = "SELECT * FROM surveyJoin WHERE userID = ?, surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setInt(2, surveyID);
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
	public int surveyJoinInsert(String userID, int surveyID, String joinDate) {
		String SQL = "INSERT INTO surveyJoin VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setInt(2, surveyID);
			pstmt.setString(3, joinDate);
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
	public int surveyJoinUpdate(String userID, int surveyID, String joinDate) {
		String SQL = "UPDATE surveyJoin SET joinDate = ? WHERE userID = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setInt(2, surveyID);
			pstmt.setString(3, joinDate);
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
	public int surveyJoinDelete(String userID, int surveyID) {
		String SQL = "DELETE FROM surveyJoin WHERE userID = ? AND surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
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
