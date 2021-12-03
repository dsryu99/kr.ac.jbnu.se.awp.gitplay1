package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.Date;
import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public interface UserInfoDAOIF {
	public UserInfoDTO userInfoSelect(String userID);
	public int userInfoInsert(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex);
	public int userInfoUpdate(String userID, String userName, Date userBirthdate, String userJob, String userAddress, String userSex);
	public int userInfoDelete(String userID);
}
