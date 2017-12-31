package com.prod.inwise.services.test.db;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface declares operations of Query Executor
 * 
 * @author mohan_kandasamy
 *
 */
public interface QueryExecutor {

	void open() throws SQLException;
	
	PreparedStatement getPreparedStatement(String query) throws SQLException;
	
	ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException;
	
	int executeUpdate(PreparedStatement preparedStatement) throws SQLException;
	
	int[] executeBatch(PreparedStatement preparedStatement) throws SQLException;
	
	BigInteger getParentId(String query, String searchBy, boolean closeConnection) throws SQLException;
	
	void close(ResultSet resultSet, PreparedStatement preparedStatement, boolean closeConnection);
	
	void close(PreparedStatement preparedStatement, boolean closeConnection);
}