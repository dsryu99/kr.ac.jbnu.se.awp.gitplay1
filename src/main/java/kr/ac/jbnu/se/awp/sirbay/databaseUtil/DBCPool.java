package kr.ac.jbnu.se.awp.sirbay.databaseUtil;

import java.sql.DriverManager;

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
		String jdbcUrl = config.getInitParameter("jdbcUrl");
		String jdbcURL = config.getInitParameter("jdbcURL");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		
		int maxActive = 10;
		int maxIdle = 10;
		
		try {
			Class.forName(jdbcDriver);
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, user, password);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setMaxTotal(maxActive);
			poolConfig.setMaxIdle(maxIdle);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnFactory,poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:sirbay");
			
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