package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity BUYER
 * 
 * @author mohan_kandasamy
 *
 */
@Entity
@Table(name = "BUYER")
@XmlRootElement
@ApiModel
public class Buyer extends NameCodeModel {
	
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID")
	@ApiModelProperty(name="Address", value="Address of the Buyer")
	private Address address;
	
	@Column(name = "PHONE")
	@ApiModelProperty
	private BigInteger phone;

	@Column(name = "REFERENCE_1")
	@ApiModelProperty
	private String reference1;

	@Column(name = "REFERENCE_2")
	@ApiModelProperty
	private String reference2;

	@Column(name = "REFERENCE_3")
	@ApiModelProperty
	private String reference3;

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
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