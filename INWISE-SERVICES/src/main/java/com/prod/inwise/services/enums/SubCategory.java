package com.prod.inwise.services.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Enum component for SubCategory
 * 
 * @author Logu
 *
 */
// CREATE TYPE SUB_CATEGORY AS ENUM ('INNERS', 'OUT FITTINGS', 'TOP', 'BOTTOM',
// 'FROCK');
public enum SubCategory {

	// Enums
	INNERS("Inners", "INNERS"),
	OUT FITTINGS("Out Fittings", "OUT FITTINGS"), TOP("Top", "TOP"), BOTTOM("Bottom", "BOTTOM"),
	FROCK("Frock", "FROCK");
	
	// Maps loaded with enums
	private static Map<String, SubCategory> nameMap = new HashMap<String, SubCategory>();

	private static Map<String, SubCategory> codeMap = new HashMap<String, SubCategory>();

	// Static block to load the maps
	static {

		for (SubCategory subCategory : EnumSet.allOf(SubCategory.class)) {

			nameMap.put(StringUtils.upperCase(subCategory.name), subCategory);

			codeMap.put(StringUtils.upperCase(subCategory.code), subCategory);
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
	SubCategory(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/**
	 * Method to lookup enum from given name
	 * 
	 * @param name
	 * @return
	 */
	public static SubCategory getEnumFromName(String name) {

		return nameMap.get(StringUtils.upperCase(name));
	}

	/**
	 * Method to lookup enum from give code
	 * 
	 * @param code
	 * @return
	 */
	public static SubCategory getEnumFromCode(String code) {

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

		SubCategory subCategory = getEnumFromName(name);

		if (null != subCategory) {

			code = subCategory.code;
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

		SubCategory subCategory = getEnumFromCode(code);

		if (null != subCategory) {

			name = subCategory.name;
		}

		return name;
	}
}