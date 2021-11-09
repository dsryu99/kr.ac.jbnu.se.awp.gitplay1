package kr.ac.jbnu.se.awp.sirbay.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.jbnu.se.awp.sirbay.dao.UserDAO;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public class UserService implements UserServiceIF {

	@Override
	public boolean isUserValid(String id, String password) {
		try {
			ResultSet rs = UserDAO.getInstance().userSelect(id);
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
			ResultSet rs = UserDAO.getInstance().userSelect(id);
			if(rs.next()) {
				return false;//duplicated userID exists
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;//userID is valid
	}

	@Override
	public boolean addUser(String id, String password, String name, int age, String job, String address, int sex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfoDTO getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPw(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
