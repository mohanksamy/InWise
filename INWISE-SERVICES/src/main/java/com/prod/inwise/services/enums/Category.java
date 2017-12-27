package com.prod.inwise.services.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Enum component for Category
 * 
 * @author Logu
 *
 */
// CREATE TYPE CATEGORY AS ENUM ('MENS', 'WOMENS', 'BOYS', 'GIRLS', 'BABY BOYS',
// 'BABY GIRLS', 'INFANTS');
public enum Category {

	// Enums
	MENS("Mens", "MENS"), WOMENS("Womens", "WOMENS"), BOYS("Boys", "BOYS"), GIRLS("Girls", "GIRLS"),
	BABY BOYS("Baby Boys", "BABY BOYS"), BABY GIRLS("Baby Girls", "BABY GIRLS"),
	INFANTS("Infants", "INFANTS");
	
	// Maps loaded with enums
	private static Map<String, Category> nameMap = new HashMap<String, Category>();

	private static Map<String, Category> codeMap = new HashMap<String, Category>();

	// Static block to load the maps
	static {

		for (Category category : EnumSet.allOf(Category.class)) {

			nameMap.put(StringUtils.upperCase(category.name), category);

			codeMap.put(StringUtils.upperCase(category.code), category);
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
	Category(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/**
	 * Method to lookup enum from given name
	 * 
	 * @param name
	 * @return
	 */
	public static Category getEnumFromName(String name) {

		return nameMap.get(StringUtils.upperCase(name));
	}

	/**
	 * Method to lookup enum from give code
	 * 
	 * @param code
	 * @return
	 */
	public static Category getEnumFromCode(String code) {

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

		Category category = getEnumFromName(name);

		if (null != category) {

			code = category.code;
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

		Category category = getEnumFromCode(code);

		if (null != category) {

			name = category.name;
		}

		return name;
	}
}