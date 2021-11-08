package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public class UserInfoDAO implements UserInfoDAOIF {

	@Override
	public ResultSet userInfoSelect(UserInfoDTO userInfoDTO) {
		String SQL = "SELECT * FROM UserInfo WHERE userID = ?";//select userinfo by userID
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userInfoDTO.getUserID());
			rs = pstmt.executeQuery();
			return rs;//결과 반환
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return null;//DB오류
	}

	@Override
	public int userInfoInsert(UserInfoDTO userInfoDTO) {
		String SQL = "INSERT INTO UserInfo VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userInfoDTO.getUserID());
			pstmt.setString(2, userInfoDTO.getUserName());
			pstmt.setInt(3, userInfoDTO.getUserAge());
			pstmt.setString(4, userInfoDTO.getUserJob());
			pstmt.setString(5, userInfoDTO.getUserAddress());
			pstmt.setInt(6, userInfoDTO.getUserSex());
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
	public int userInfoUpdate(UserInfoDTO userInfoDTO) {
		String SQL = "UPDATE UserInfo SET UserName = ?, UserAge = ?, UserJob = ?, UserAddress = ?, UserSex = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userInfoDTO.getUserID());
			pstmt.setString(2, userInfoDTO.getUserName());
			pstmt.setInt(3, userInfoDTO.getUserAge());
			pstmt.setString(4, userInfoDTO.getUserJob());
			pstmt.setString(5, userInfoDTO.getUserAddress());
			pstmt.setInt(6, userInfoDTO.getUserSex());
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
	public int userInfoDelete(UserInfoDTO userInfoDTO) {
		String SQL = "DELETE FROM UserInfo WHERE userID = ?";//delete userinfo by userID
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userInfoDTO.getUserID());
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
