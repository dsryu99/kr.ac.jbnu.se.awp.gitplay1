package kr.ac.jbnu.se.awp.sirbay.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.jbnu.se.awp.sirbay.dao.UserDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.UserInfoDAO;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public class UserService implements UserServiceIF {
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserInfoDAO userInfoDAO;
	
	@Override
	public boolean isUserValid(String id, String password) {
		try {
			ResultSet rs = userDAO.userSelect(id);
			if(rs.next()) {
				if(rs.getString(2) == password) {
					return true;
				}
				return false;//incorrect password
			}
			return false;//incorrect ID
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//DB exception
	}

	@Override
	public boolean isUserExist(String id) {
		try {
			ResultSet rs = userDAO.userSelect(id);
			if(rs.next()) {
				return true;//duplicated userID exists
			}
			return false;//userID is valid
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//DB error
	}

	@Override
	public boolean addUser(String id, String password, String name, Date birth, String job, String address, String sex) {
		try {
			userDAO.userInsert(id, password);
			userInfoDAO.userInfoInsert(id, name, birth, job, address, sex);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserInfoDTO getUser(String id) {
		try {
			ResultSet rs = userInfoDAO.userInfoSelect(id);
			if(rs.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setUserID(rs.getString(1));
				userInfoDTO.setUserName(rs.getString(2));
				userInfoDTO.setUserAge(rs.getDate(3));
				userInfoDTO.setUserJob(rs.getString(4));
				userInfoDTO.setUserAddress(rs.getString(5));
				userInfoDTO.setUserSex(rs.getString(6));
				return userInfoDTO;
			}
			return null;//incorrect ID
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;//DB exception
	}

	@Override
	public boolean checkPw(String id, String password) {
		try {
			ResultSet rs = userDAO.userSelect(id);
			if(rs.next()) {
				if(rs.getString(2) == password) {
					return true;
				}
				return false;//incorrect password
			}
			return false;//incorrect ID
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//DB exception
	}

	@Override
	public boolean deleteUser(String id) {
		try {
			userDAO.userDelete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;//DB exception
	}

}
