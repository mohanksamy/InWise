package com.prod.inwise.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class InvoiceDTO extends BaseDTO {

	private TraderDTO trader;

	private BigDecimal totalTax;

	private BigDecimal totalPrice;

	private BuyerDTO buyer;

	private BigInteger phone;
	
	private List<LineItemDTO> lineItems;

	/**
	 * @return the trader
	 */
	public TraderDTO getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(TraderDTO trader) {
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
	public BuyerDTO getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(BuyerDTO buyer) {
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

	/**
	 * @return the lineItems
	 */
	public List<LineItemDTO> getLineItems() {
		return lineItems;
	}

	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(List<LineItemDTO> lineItems) {
		this.lineItems = lineItems;
	}
}