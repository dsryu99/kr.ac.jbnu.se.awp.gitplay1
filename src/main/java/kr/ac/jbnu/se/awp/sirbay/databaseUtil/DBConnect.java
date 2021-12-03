package kr.ac.jbnu.se.awp.sirbay.databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnect {
	public static Connection getConnection(){
		Connection conn = null;          
 
		try{
			String jdbcDriver = "jdbc:apache:commons:dbcp:sirbay";
			conn = DriverManager.getConnection(jdbcDriver);
 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn; 
	}
}