package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

public interface UserDAOIF {
	public ResultSet userSelect(String userID);
	public int userInsert(String userID, String userPassword);
	public int userUpdate(String userPassword);
	public int userDelete(String userID);
}
