package com.prod.inwise.services.test.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for Tax
 * 
 * @author mohan_kandasamy
 *
 */
public class TaxTests {

	private static QueryExecutor queryExecutor;
	
	private static boolean closeConnection;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		queryExecutor = new PGQueryExecutor();
		
		queryExecutor.open();
	}

	@Test
	public void test() throws Exception {
		
		BigInteger storeId = queryExecutor.getParentId("SELECT ID FROM STORE WHERE NAME = ?", "Anand Texttiles", closeConnection);
		
		String query = "INSERT INTO TAX(ID, CGST, SGST, STORE_ID, ACTIVE, CREATED_USER, MODIFIED_USER)" + 
				"VALUES(NEXTVAL('TAX_SEQ'), ?, ?, ?, TRUE, 'APP-SERVICES', 'APP-SERVICES')";
		
		PreparedStatement preparedStatement = queryExecutor.getPreparedStatement(query);
		
		preparedStatement.setFloat(1, 2.5F);
		preparedStatement.setFloat(2, 2.5F);
		preparedStatement.setBigDecimal(3, new BigDecimal(storeId));
		
		queryExecutor.executeUpdate(preparedStatement);
		
		queryExecutor.close(preparedStatement, !closeConnection);
	}
}