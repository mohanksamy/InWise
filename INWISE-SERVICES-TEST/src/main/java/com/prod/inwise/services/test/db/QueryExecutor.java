package com.prod.inwise.services.test.db;

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
	
	int executeUpdate(PreparedStatement preparedStatement) throws SQLException;
	
	void close(ResultSet resultSet, PreparedStatement preparedStatement);
	
	void close(PreparedStatement preparedStatement);
}