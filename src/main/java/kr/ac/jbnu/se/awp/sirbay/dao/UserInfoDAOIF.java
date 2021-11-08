package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.dto.UserInfoDTO;

public interface UserInfoDAOIF {
	public ResultSet userInfoSelect(UserInfoDTO userInfoDTO);
	public int userInfoInsert(UserInfoDTO userInfoDTO);
	public int userInfoUpdate(UserInfoDTO userInfoDTO);
	public int userInfoDelete(UserInfoDTO userInfoDTO);
}
