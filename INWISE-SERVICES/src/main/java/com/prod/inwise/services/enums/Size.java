package com.prod.inwise.services.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Enum component for Size
 * 
 * @author Logu
 *
 */

// CREATE TYPE SIZE AS ENUM ('55', '60', '65', '70', '75', 'S', 'M', 'L', 'XL',
// 'XXL', 'NA');
public enum Size {

	// Enums
	_55("55","55"),
	_60("60","60"),
	_65("65","65"),
	_70("70","70"),
	_75("75","75"),
	S("S", "S"),
	M("M", "M"),
	L("L", "L"),
	XL("XL", "XL"),
	XXL("XXL", "XXL"),
	NA("NA", "NA");
	
	// Maps loaded with enums
	private static Map<String, Size> nameMap = new HashMap<String, Size>();

	private static Map<String, Size> codeMap = new HashMap<String, Size>();

	// Static block to load the maps
	static {

		for (Size size : EnumSet.allOf(Size.class)) {

			nameMap.put(StringUtils.upperCase(size.name), size);

			codeMap.put(StringUtils.upperCase(size.code), size);
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
	Size(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/**
	 * Method to lookup enum from given name
	 * 
	 * @param name
	 * @return
	 */
	public static Size getEnumFromName(String name) {

		return nameMap.get(StringUtils.upperCase(name));
	}

	/**
	 * Method to lookup enum from give code
	 * 
	 * @param code
	 * @return
	 */
	public static Size getEnumFromCode(String code) {

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

		Size size = getEnumFromName(name);

		if (null != size) {

			code = size.code;
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

		Size size = getEnumFromCode(code);

		if (null != size) {

			name = size.name;
		}

		return name;
	}
}