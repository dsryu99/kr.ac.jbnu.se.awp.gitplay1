package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
import kr.ac.jbnu.se.awp.sirbay.dto.SurveyDTO;
@Repository("surveyDAO")
public class SurveyDAO implements SurveyDAOIF {

	@Override
	public SurveyDTO surveySelect(int surveyID) {
		String SQL = "SELECT * FROM survey WHERE surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SurveyDTO surveyDTO = new SurveyDTO();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, surveyID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				surveyDTO.setSurveyID(rs.getInt(1));
				surveyDTO.setUserID(rs.getString(2));
				surveyDTO.setSurveyCreatedTime(rs.getDate(3));
				surveyDTO.setSurveyStartTime(rs.getDate(4));
				surveyDTO.setSurveyEndTime(rs.getDate(5));
				surveyDTO.setSurveyTitle(rs.getString(6));
			}
			return surveyDTO;
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
	public List<SurveyDTO> surveySelect() {
		String SQL = "SELECT * FROM survey";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO surveyDTO = new SurveyDTO();
				surveyDTO.setSurveyID(rs.getInt(1));
				surveyDTO.setUserID(rs.getString(2));
				surveyDTO.setSurveyCreatedTime(rs.getDate(3));
				surveyDTO.setSurveyStartTime(rs.getDate(4));
				surveyDTO.setSurveyEndTime(rs.getDate(5));
				surveyDTO.setSurveyTitle(rs.getString(6));
				list.add(surveyDTO);
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

//	@Override
//	public int surveyInsert(String userID, String surveyCreatedTime, String surveyStartTime,
//			String surveyEndTime, String surveyTitle) {
//		String SQL = "INSERT INTO survey VALUES(?,?,?,?,?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBConnect.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, userID);
//			pstmt.setString(2, surveyCreatedTime);
//			pstmt.setString(3, surveyStartTime);
//			pstmt.setString(4, surveyEndTime);
//			pstmt.setString(5, surveyTitle);
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.getStackTrace();
//		} finally {
//			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
//			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
//		}
//		return -1;//DB오류
//	}
	
	@Override
	public int surveyInsert(String userID, String surveyCreatedTime, String surveyTitle) {
		String SQL = "INSERT INTO survey (userID, SurveyCreatedTime, surveyTitle) VALUES(?,?,?)";
		String getIdSQL = "SELECT LAST_INSERT_ID()";
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt1 = conn.prepareStatement(SQL);
			pstmt1.setString(1, userID);
			pstmt1.setString(2, surveyCreatedTime);
			pstmt1.setString(3, surveyTitle);
			pstmt1.executeUpdate();
			pstmt2 = conn.prepareStatement(getIdSQL);
			rs = pstmt2.executeQuery();
			int id = rs.getInt(1);
			return id;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt1 != null) pstmt1.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -1;//DB오류
	}

	@Override
	public int surveyUpdate(int surveyID, String surveyStartTime, String surveyEndTime, String surveyTitle) {
		String SQL = "UPDATE survey SET surveyStartTime = ? ,surveyEndTime = ?, surveyTitle = ? WHERE surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, surveyStartTime);
			pstmt.setString(2, surveyEndTime);
			pstmt.setString(3, surveyTitle);
			pstmt.setInt(4, surveyID);
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
	public int surveyDelete(int surveyID) {
		String SQL = "DELETE FROM survey WHERE surveyID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, surveyID);
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
