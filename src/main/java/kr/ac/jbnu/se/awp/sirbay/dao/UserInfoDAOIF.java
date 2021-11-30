package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;
import java.sql.Date;

public interface UserInfoDAOIF {
	public ResultSet userInfoSelect(String userID);
	public int userInfoInsert(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex);
	public int userInfoUpdate(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex);
	public int userInfoDelete(String userID);
}
