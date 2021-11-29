package kr.ac.jbnu.se.awp.sirbay.service;

import java.util.Date;

import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public interface UserServiceIF {
	boolean isUserValid(String id, String password);
	boolean isUserExist(String id);
	boolean addUser(String id, String password, String name, Date birth, String job, String address, String sex);
	UserInfoDTO getUser(String id);
	boolean checkPw(String id, String password);
	boolean deleteUser(String id);
}
