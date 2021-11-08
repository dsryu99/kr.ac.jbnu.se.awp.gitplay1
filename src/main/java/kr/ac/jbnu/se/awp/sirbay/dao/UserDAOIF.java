package kr.ac.jbnu.se.awp.sirbay.dao;

import java.sql.ResultSet;

import kr.ac.jbnu.se.awp.sirbay.dto.UserDTO;

public interface UserDAOIF {
	public ResultSet userSelect(UserDTO userDTO);
	public int userInsert(UserDTO userDTO);
	public int userUpdate(UserDTO userDTO);
	public int userDelete(UserDTO userDTO);
}
