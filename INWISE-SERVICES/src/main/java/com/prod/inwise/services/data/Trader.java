package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity TRADER
 * 
 * @author mohan.kandasamy
 *
 */
@Entity
@Table(name = "TRADER")
@ApiModel
public class Trader extends NameCodeModel {
	
	@NotNull(message = "Address can't be null")
	@NotBlank(message = "Address can't be blank")
	@Column(name = "ADDRESS", nullable = false)
	@ApiModelProperty(name="Address", value="Address of the Trader")
	private String address;
	
	@NotNull(message = "UIN can't be null")
	@NotBlank(message = "UIN can't be blank")
	@Column(name = "UIN", nullable = false) 	
	@ApiModelProperty(name="UIN", value="UIN number of the Trader")
	private String uin;
	
	@NotNull(message = "Phone can't be null")
	@Column(name = "PHONE", nullable = false)
	@ApiModelProperty(name="Phone", value="Phone number of the Trader")
	private BigInteger phone;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
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
}