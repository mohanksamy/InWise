package com.prod.inwise.services.test.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for Store 
 * 
 * @author mohan_kandasamy
 *
 */
public class StoreTests {
	
	private static QueryExecutor queryExecutor;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		queryExecutor = new PGQueryExecutor();
		
		queryExecutor.open();
	}

	@Test
	public void test() throws Exception {
		
		String query = "INSERT INTO STORE(ID, NAME, ADDRESS, UIN, PHONE, ACTIVE, CREATED_USER, CREATED_TS, MODIFIED_USER, MODIFIED_TS)\n" + 
				"VALUES(?, ?, ?, ?, ?, TRUE, 'APP-SERVICES', NOW(), 'APP-SERVICES', NOW())";
		
		PreparedStatement preparedStatement = queryExecutor.getPreparedStatement(query);
		
		preparedStatement.setBigDecimal(1, new BigDecimal("123456"));
		preparedStatement.setString(2, "Anand Texttiles");
		preparedStatement.setString(3, "11, Palace road, Bangalore");
		preparedStatement.setString(4, "BLR343769364564");
		preparedStatement.setBigDecimal(5, new BigDecimal("9985645643"));
		
		queryExecutor.executeUpdate(preparedStatement);
		
		queryExecutor.close(preparedStatement);
	}
}