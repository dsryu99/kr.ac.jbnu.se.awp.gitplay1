package kr.ac.jbnu.se.awp.sirbay.service;

import java.sql.ResultSet;
import java.sql.SQLException;

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
				return false;//duplicated userID exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;//userID is valid
	}

	@Override
	public boolean addUser(String id, String password, String name, int age, String job, String address, int sex) {
		try {
			userDAO.userInsert(id, password);
			userInfoDAO.userInfoInsert(id, name, age, job, address, sex);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
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
				userInfoDTO.setUserAge(rs.getInt(3));
				userInfoDTO.setUserJob(rs.getString(4));
				userInfoDTO.setUserAddress(rs.getString(5));
				userInfoDTO.setUserSex(rs.getInt(6));
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
			e.getStackTrace();
		}
		return false;//DB exception
	}

}
