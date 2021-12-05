package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;
@Repository("userinfoDAO")
public class UserInfoDAO implements UserInfoDAOIF {
	
	@Override
	public UserInfoDTO userInfoSelect(String userID) {
		String SQL = "SELECT * FROM UserInfo WHERE userID = ?";//select userinfo by userID
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setUserID(rs.getString(1));
				userInfoDTO.setUserName(rs.getString(2));
				userInfoDTO.setUserBirthdate(rs.getDate(3));
				userInfoDTO.setUserJob(rs.getString(4));
				userInfoDTO.setUserAddress(rs.getString(5));
				userInfoDTO.setUserSex(rs.getString(6));
				return userInfoDTO;//결과 반환
			}
			return null;
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
	public int userInfoInsert(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex) {
		String SQL = "INSERT INTO UserInfo VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String birthdate = userBirthdate.getYear()+"-"+userBirthdate.getMonth()+"-"+userBirthdate.getDate();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, userName);
			pstmt.setString(3, birthdate);
			pstmt.setString(4, userJob);
			pstmt.setString(5, userAddress);
			pstmt.setString(6, userSex);
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
	public int userInfoUpdate(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex) {
		String SQL = "UPDATE UserInfo SET UserName = ?, UserAge = ?, UserJob = ?, UserAddress = ?, UserSex = ? WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userName);
			pstmt.setDate(2, userBirthdate);
			pstmt.setString(3, userJob);
			pstmt.setString(4, userAddress);
			pstmt.setString(5, userSex);
			pstmt.setString(6, userID);
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
	public int userInfoDelete(String userID) {
		String SQL = "DELETE FROM UserInfo WHERE userID = ?";//delete userinfo by userID
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
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
