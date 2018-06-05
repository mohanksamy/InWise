package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

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
public class Vendor extends NameCodeModel {

	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	@ApiModelProperty(name="Address", value="Address of the Trader")
	private Address address;

	@NotNull(message = "Phone can't be null")
	@Column(name = "PHONE", nullable = false)
	@ApiModelProperty
	private BigInteger phone;
	
	@ManyToOne
	@JoinColumn(name = "TRADER_ID", nullable = false)
	@ApiModelProperty
	private Trader trader;

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
	 * @return the trader
	 */
	public Trader getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
}