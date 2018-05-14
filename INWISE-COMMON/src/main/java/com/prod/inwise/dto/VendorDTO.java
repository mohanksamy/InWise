package com.prod.inwise.dto;

import java.math.BigInteger;

public class VendorDTO extends NameCodeDTO {

	private AddressDTO address;

	private BigInteger phone;

	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public BigInteger getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}
}