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
		String poolName = config.getInitParameter("poolName");        // Pool �씠由�
		String jdbcDriver = config.getInitParameter("jdbcDriver");    // Driver Class
		String jdbcURL = config.getInitParameter("jdbcURL");          // MySQL �꽌踰� 二쇱냼
		String user = config.getInitParameter("user");                // 怨꾩젙 �븘�씠�뵒
		String password = config.getInitParameter("password");        // 怨꾩젙 鍮꾨�踰덊샇
		
		int maxActive = 0;        // 理쒕� �뿰寃곗닔 
		int maxIdle = 0;          // ��湲곗쨷�씤 �뿰寃곗닔  
		
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
			System.out.println("     >> DBCP Connection Pool Execute <<     ");
			System.out.println("---------------------------------------------------");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}