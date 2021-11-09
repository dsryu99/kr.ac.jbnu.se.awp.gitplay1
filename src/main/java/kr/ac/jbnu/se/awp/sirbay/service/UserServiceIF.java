package kr.ac.jbnu.se.awp.sirbay.service;

import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public interface UserServiceIF {
	boolean isUserValid(String id, String password);
	boolean isUserExist(String id);
	boolean addUser(String id, String password, String name, int age, String job, String address, int sex);
	UserInfoDTO getUser(String id);
	boolean checkPw(String id, String password);
	boolean deleteUser(String id);
}
