package com.prod.inwise.services.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class to execute queries in Postgresql DB
 * 
 * @author mohan_kandasamy
 *
 */
public class PGQueryExecutor implements QueryExecutor {
	
	Connection connection;

	@Override
	public void open() throws SQLException {
		
		connection = PGConnections.getConnection();
	}
	
	@Override
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		
		return connection.prepareStatement(query);
	}

	@Override
	public int executeUpdate(PreparedStatement preparedStatement) throws SQLException {
		
		return preparedStatement.executeUpdate();
	}
	
	@Override
	public void close(ResultSet resultSet, PreparedStatement preparedStatement) {
		
		try {
			
			// Closing ResultSet Object
			if ( null != resultSet ) {
				resultSet.close();
			}
			
			close(preparedStatement);
		
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
		}
	}

	@Override
	public void close(PreparedStatement preparedStatement) {
		
		try {
			
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
}