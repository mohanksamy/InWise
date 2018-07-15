package com.prod.inwise.services.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity INVOICE
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "INVOICE")
@XmlRootElement
@ApiModel
public class Invoice extends BaseModel {

	@ManyToOne
	@JoinColumn(name = "TRADER_ID", nullable = false)
	@ApiModelProperty
	private Trader trader;

	@NotNull(message = "TotalTax can't be null")
	@Column(name = "TOTAL_TAX", nullable = false)
	@ApiModelProperty
	private BigDecimal totalTax;

	@NotNull(message = "TotalPrice can't be null")
	@Column(name = "TOTAL_PRICE", nullable = false)
	@ApiModelProperty
	private BigDecimal totalPrice;

	@ManyToOne
	@JoinColumn(name = "BUYER_ID")
	@ApiModelProperty
	private Buyer buyer;
	
	@Column(name = "PHONE")
	@ApiModelProperty
	private BigInteger phone;

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

	/**
	 * @return the totalTax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the buyer
	 */
	public Buyer getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
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