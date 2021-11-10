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
		String poolName = config.getInitParameter("poolName");
		String jdbcDriver = config.getInitParameter("jdbcDriver");
		String jdbcURL = config.getInitParameter("jdbcURL");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		int maxActive = 10;
		int maxIdle = 10;
		
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