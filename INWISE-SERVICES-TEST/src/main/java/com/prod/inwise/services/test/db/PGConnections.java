package com.prod.inwise.services.test.db;

import static com.prod.inwise.services.test.db.util.Constants.JDBC_DB_URL;
import static com.prod.inwise.services.test.db.util.Constants.JDBC_DRIVER;
import static com.prod.inwise.services.test.db.util.Constants.JDBC_PASS;
import static com.prod.inwise.services.test.db.util.Constants.JDBC_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * Data source to connect to Postgresql DB
 * 
 * @author mohan_kandasamy
 *
 */
public class PGConnections {

	private static DataSource pgDataSource;
	
	private static GenericObjectPool<?> connectionPool;

	static {
		
		try {
			Class.forName(JDBC_DRIVER);
	
			// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
			connectionPool = new GenericObjectPool<Object>();
			
			connectionPool.setMaxActive(5);
	
			// Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
			ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
	
			// Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
			new PoolableConnectionFactory(cf, connectionPool, null, null, false, true);
			
			pgDataSource = new PoolingDataSource(connectionPool);
		
		} catch (ClassNotFoundException cnfe) {
			
			System.out.println("Exception loading the driver class: " + JDBC_DRIVER);
		}
	}

	// This Method Is Used To Print The Connection Pool Status
	private void printDBStatus() {
		System.out.println("Max.: " + connectionPool.getMaxActive() + "; Active: " + connectionPool.getNumActive() + "; Idle: " + connectionPool.getNumIdle());
	}
	
	public DataSource getDataSource() {
		return pgDataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return pgDataSource.getConnection();
	}

	public static void main(String[] args) {
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		PGConnections pgConnections = new PGConnections();
		
		try {	
			
			pgConnections.printDBStatus();

			// Performing Database Operation!
			System.out.println("\n=====Making A New Connection Object For DB Transaction=====\n");
			connection = pgConnections.getDataSource().getConnection();
			pgConnections.printDBStatus(); 

			preparedStatement = connection.prepareStatement("SELECT * FROM STORE");
			resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() ) {
				System.out.println("Store Name: " + resultSet.getString("name"));
			}
			
			System.out.println("\n=====Releasing Connection Object To Pool=====\n");			
		
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
		
		} finally {
			
			try {
				
				// Closing ResultSet Object
				if ( null != resultSet ) {
					resultSet.close();
				}
				
				// Closing PreparedStatement Object
				if ( null != preparedStatement ) {
					preparedStatement.close();
				}
				
				// Closing Connection Object
				if ( null != connection ) {
					connection.close();
				}
			
			} catch(Exception sqlException) {
				
				sqlException.printStackTrace();
			}
		}
		
		pgConnections.printDBStatus();
	}
}