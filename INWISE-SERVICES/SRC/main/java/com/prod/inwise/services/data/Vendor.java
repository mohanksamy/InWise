/**
 * 
 */
package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity VENDOR
 * 
 * @author Logu
 *
 */

// CREATE TABLE VENDOR (
// ID BIGINT NOT NULL,
// NAME TEXT NOT NULL,
// CODE TEXT NOT NULL,
// ADDRESS TEXT NOT NULL,
// PHONE BIGINT NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID)
// );

@Entity
@Table(name = "VENDOR")
@XmlRootElement
public class Vendor extends BaseModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull(message = "Code can't be null")
	@NotBlank(message = "Code can't be blank")
	@Column(name = "CODE", nullable = false)
	private String code;

	@NotNull(message = "Address can't be null")
	@NotBlank(message = "Address can't be blank")
	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@NotNull(message = "Phone can't be null")
	@Column(name = "PHONE", nullable = false)
	private BigInteger phone;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param code
	 *            the code to set
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
	 * @param address
	 *            the address to set
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
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

}
