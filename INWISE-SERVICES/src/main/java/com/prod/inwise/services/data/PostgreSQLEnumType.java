package com.prod.inwise.services.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * This is the bridge class between Java Enum types and Postgres Enum types
 * 
 * @author mohan_kandasamy
 *
 */
public class PostgreSQLEnumType extends org.hibernate.type.EnumType {
	 
	private static final long serialVersionUID = 1L;
	
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor arg3) throws HibernateException, SQLException {
		
		if ( null == value ) {
            
			st.setNull(index, Types.OTHER);
        
    		} else {
            
    			st.setObject(index, value.toString(), Types.OTHER);
        }
	}
}