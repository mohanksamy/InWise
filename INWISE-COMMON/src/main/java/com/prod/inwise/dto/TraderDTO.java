package com.prod.inwise.dto;

import java.math.BigInteger;

/**
 * @author mohan_kandasamy
 *
 */
public class TraderDTO extends NameCodeDTO {
	
	private AddressDTO address;
	
	private String uin;
	
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
	 * @return the uin
	 */
	public String getUin() {
		return uin;
	}

	/**
	 * @param uin the uin to set
	 */
	public void setUin(String uin) {
		this.uin = uin;
	}

	/**
	 * @return the phone
	 */
	public BigInteger getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TraderDTO [address=" + address + ", uin=" + uin + ", phone=" + phone + ", getName()=" + getName()
				+ ", getCode()=" + getCode() + ", isActive()=" + isActive() + "]";
	}
}