package kr.ac.jbnu.se.awp.sirbay.dao;

public interface UserDAOIF {
	public int userLogin(String userID, String userPassword);
	public int userExist(String userID);
	public int userInsert(String userID, String userPassword);
	public int userUpdate(String userID, String userPassword);
	public int userDelete(String userID);
}
