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
 * Entity MERCHANT
 * 
 * @author mohan.kandasamy
 *
 */
@Entity
@Table(name = "MERCHANT")
@ApiModel
public class Merchant extends BaseModel {
	
	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty(name="Name", value="Name of the Store")
	private String name;
	
	@NotNull(message = "Address can't be null")
	@NotBlank(message = "Address can't be blank")
	@Column(name = "ADDRESS", nullable = false)
	@ApiModelProperty(name="Address", value="Address of the Store")
	private String address;
	
	@NotNull(message = "UIN can't be null")
	@NotBlank(message = "UIN can't be blank")
	@Column(name = "UIN", nullable = false) 	
	@ApiModelProperty(name="UIN", value="UIN number of the Store")
	private String uin;
	
	@NotNull(message = "Phone can't be null")
	@Column(name = "PHONE", nullable = false)
	@ApiModelProperty(name="Phone", value="Phone number of the Store")
	private BigInteger phone;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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