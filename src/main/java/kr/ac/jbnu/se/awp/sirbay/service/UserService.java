package kr.ac.jbnu.se.awp.sirbay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.se.awp.sirbay.dao.UserDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.UserDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dao.UserInfoDAO;
import kr.ac.jbnu.se.awp.sirbay.dao.UserInfoDAOIF;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;
@Service
public class UserService implements UserServiceIF {
	UserDAOIF userDAO;
	UserInfoDAOIF userInfoDAO;
	
	@Autowired
	private void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Autowired
	private void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	
	@Override
	public boolean isUserValid(String id, String password) {
		int result = userDAO.userLogin(id, password);
		if(result==1) {
			return true;
		} else {
			return false;//invalid
		}
	}

	@Override
	public boolean isUserExist(String id) {
		int result = userDAO.userExist(id);
		if(result==1) {
			return true;
		} else {
			return false;//DB exception
		}
	}

	@Override
	public boolean addUser(String id, String password, String name, String birth, String job, String address, String sex) {
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
		UserInfoDTO result = userInfoDAO.userInfoSelect(id);
		if(result != null) {
			return result;
		} else {
			return null;//DB exception
		}
	}

	@Override
	public boolean checkPw(String id, String password) {
		int result = userDAO.userLogin(id, password);
		if(result==1) {
			return true;
		} else {
			return false;//DB exception
		}
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
