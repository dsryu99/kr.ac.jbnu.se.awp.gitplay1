package kr.ac.jbnu.se.awp.sirbay.databaseUtil;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


public class DBCPool extends HttpServlet {
	public void init(ServletConfig config) {
		String poolName = config.getInitParameter("poolName");        // Pool 이름
		String jdbcDriver = config.getInitParameter("jdbcDriver");    // Driver Class
		String jdbcURL = config.getInitParameter("jdbcURL");          // MySQL 서버 주소
		String user = config.getInitParameter("user");                // 계정 아이디
		String password = config.getInitParameter("password");        // 계정 비밀번호
		
		int maxActive = 0;        // 최대 연결수 
		int maxIdle = 0;          // 대기중인 연결수  
		
		try {
			Class.forName(jdbcDriver);
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcDriver, user, password);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setMaxTotal(maxActive);
			poolConfig.setMaxIdle(maxIdle);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnFactory,poolConfig);
			
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcURL, user, password);
			
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
			poolableConnectionFactory.setPool(connectionPool);
			
			PoolingDriver driver = new PoolingDriver();
			
			driver.registerPool(poolName, connectionPool);
			
			System.out.println("---------------------------------------------------");
			System.out.println("     >> DBCP Connection Pool이 실행되었습니다 <<     ");
			System.out.println("---------------------------------------------------");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}