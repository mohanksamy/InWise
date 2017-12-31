package com.prod.inwise.services.test.db;

import java.math.BigInteger;
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
	public ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException {
		
		return preparedStatement.executeQuery();
	}

	@Override
	public int executeUpdate(PreparedStatement preparedStatement) throws SQLException {
		
		return preparedStatement.executeUpdate();
	}
	
	@Override
	public int[] executeBatch(PreparedStatement preparedStatement) throws SQLException {
		
		return preparedStatement.executeBatch();
	}
	
	@Override
	public BigInteger getParentId(String query, String searchBy, boolean closeConnection) throws SQLException {
		
		PreparedStatement preparedStatement = getPreparedStatement(query);
		
		preparedStatement.setString(1, searchBy);
		
		ResultSet resultSet = executeQuery(preparedStatement);
		
		BigInteger parentId = resultSet.next() ? resultSet.getBigDecimal(1).toBigInteger() : null;
		
		close(resultSet, preparedStatement, closeConnection);
		
		return parentId;
	}
	
	@Override
	public void close(ResultSet resultSet, PreparedStatement preparedStatement, boolean closeConnection) {
		
		try {
			
			// Closing ResultSet Object
			if ( null != resultSet ) {
				resultSet.close();
			}
			
			close(preparedStatement, closeConnection);
		
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
		}
	}

	@Override
	public void close(PreparedStatement preparedStatement, boolean closeConnection) {
		
		try {
			
			// Closing PreparedStatement Object
			if ( null != preparedStatement ) {
				preparedStatement.close();
			}
			
			// Closing Connection Object
			if ( closeConnection && null != connection ) {
				connection.close();
			}
		
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
		}
	}
}