package com.prod.inwise.dto;

public class BuyerDTO extends NameCodeDTO {

	private AddressDTO address;
	
	private String reference1;
	
	private String reference2;
	
	private String reference3;

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
	 * @return the reference1
	 */
	public String getReference1() {
		return reference1;
	}

	/**
	 * @param reference1 the reference1 to set
	 */
	public void setReference1(String reference1) {
		this.reference1 = reference1;
	}

	/**
	 * @return the reference2
	 */
	public String getReference2() {
		return reference2;
	}

	/**
	 * @param reference2 the reference2 to set
	 */
	public void setReference2(String reference2) {
		this.reference2 = reference2;
	}

	/**
	 * @return the reference3
	 */
	public String getReference3() {
		return reference3;
	}

	/**
	 * @param reference3 the reference3 to set
	 */
	public void setReference3(String reference3) {
		this.reference3 = reference3;
	}
}