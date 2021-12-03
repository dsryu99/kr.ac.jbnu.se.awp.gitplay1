package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import kr.ac.jbnu.se.awp.sirbay.databaseUtil.DBConnect;
@Repository("userDAO")
public class UserDAO implements UserDAOIF {
	
	@Override
	public int userLogin(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM User WHERE userID = ?";//userID를 통해서만 검색 가능
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).compareTo(userPassword)==0) {
					return 1;//login success
				}
				return 0;//incorrect password
			}
			return -1;//incorrect id
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -2;//DB error
	}
	
	@Override
	public int userExist(String userID) {
		String SQL = "SELECT userID FROM User WHERE userID = ?";//userID를 통해서만 검색 가능
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1) == userID) {
					return 1;//login success
				}
				return 0;//incorrect password
			}
			return -1;//incorrect id
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		return -2;//DB error
	}

	@Override
	public int userInsert(String userID, String userPassword) {
		String SQL = "INSERT INTO User VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
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
	public int userUpdate(String userID, String userPassword) {
		String SQL = "UPDATE User SET userPassword = ? WHERE userID = ?";//userID에는 변경을 가할 수 없도록 함
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userPassword);
			pstmt.setString(2, userID);
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
	public int userDelete(String userID) {
		String SQL = "DELETE FROM User WHERE userID = ?";//userID를 통해서만 삭제 가능
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
