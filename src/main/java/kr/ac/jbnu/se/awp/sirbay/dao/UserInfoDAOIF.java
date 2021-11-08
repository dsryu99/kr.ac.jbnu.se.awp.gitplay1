package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public interface UserInfoDAOIF {
	public ResultSet userInfoSelect(String userID);
	public int userInfoInsert(String userID, String userName, int userAge, String userJob, String userAddress, int userSex);
	public int userInfoUpdate(String userName, int userAge, String userJob, String userAddress, int userSex);
	public int userInfoDelete(String userID);
}
