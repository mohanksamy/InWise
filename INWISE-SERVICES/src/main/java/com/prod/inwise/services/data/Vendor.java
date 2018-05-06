package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity VENDOR
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "VENDOR")
@XmlRootElement
@ApiModel
public class Vendor extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "vendor_seq", allocationSize = 1, sequenceName = "VENDOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;*/

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty
	private String name;

	@NotNull(message = "Code can't be null")
	@NotBlank(message = "Code can't be blank")
	@Column(name = "CODE", nullable = false)
	@ApiModelProperty
	private String code;

	@NotNull(message = "Address can't be null")
	@NotBlank(message = "Address can't be blank")
	@Column(name = "ADDRESS", nullable = false)
	@ApiModelProperty
	private String address;

	@NotNull(message = "Phone can't be null")
	@Column(name = "PHONE", nullable = false)
	@ApiModelProperty
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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