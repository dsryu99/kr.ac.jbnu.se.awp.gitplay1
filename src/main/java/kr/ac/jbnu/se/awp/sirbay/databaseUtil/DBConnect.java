package kr.ac.jbnu.se.awp.sirbay.databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnect {
	public static Connection getConnection(){
		Connection conn = null;          
 
		try{
			String poolName = "jdbc:apache:commons:dbcp2:sirbay";
			conn = DriverManager.getConnection(poolName);
 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn; 
	}
}