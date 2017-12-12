package com.prod.inwise.services.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Enum component for Brand
 * 
 * @author mohan.kandasamy
 *
 */
public enum Brand {

	// Enums
	POOMER("Poomer", "POOMER"),
	POOMEX("Poomex", "POOMEX"),
	GRS("GRS", "GRS"),
	EFRESH("e-fresh", "E-FRESH");
	
	// Maps loaded with enums
	private static Map<String, Brand> nameMap = new HashMap<String, Brand>();
	
	private static Map<String, Brand> codeMap = new HashMap<String, Brand>();
	
	// Static block to load the maps
	static {
		
		for ( Brand brand : EnumSet.allOf(Brand.class) ) {
			
			nameMap.put(StringUtils.upperCase(brand.name), brand);
			
			codeMap.put(StringUtils.upperCase(brand.code), brand);
		}
	}
	
	// Attribute: Name
	private String name;
	
	// Attribute: Code
	private String code;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param code
	 */
	Brand(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	/**
	 * Method to lookup enum from given name
	 * 
	 * @param name
	 * @return
	 */
	public static Brand getEnumFromName(String name) {
		
		return nameMap.get(StringUtils.upperCase(name));
	}
	
	/**
	 * Method to lookup enum from give code
	 * 
	 * @param code
	 * @return
	 */
	public static Brand getEnumFromCode(String code) {
		
		return codeMap.get(StringUtils.upperCase(code));
	}
	
	/**
	 * Get Code as string from given name
	 * 
	 * @param name
	 * @return
	 */
	public static String getCodeFromName(String name) {
		
		String code = null;
		
		Brand brand = getEnumFromName(name);
		
		if ( null != brand ) {
			
			code = brand.code;
		}
		
		return code;
	}
	
	/**
	 * Get Name as string from given code
	 * 
	 * @param code
	 * @return
	 */
	public static String getNameFromCode(String code) {
		
		String name = null;
		
		Brand brand = getEnumFromCode(code);
		
		if ( null != brand ) {
			
			name = brand.name;
		}
		
		return name;
	}
}