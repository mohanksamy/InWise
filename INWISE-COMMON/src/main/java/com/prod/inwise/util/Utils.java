package com.prod.inwise.util;

/**
 * Utility class for basic checks
 * 
 * @author mohan_kandasamy
 *
 */
public class Utils {

	/**
	 * Method to check that the object is null
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		
		boolean isNull = false;
		
		if ( null == object ) {
			isNull = true;
		}
		
		return isNull;
	}
}