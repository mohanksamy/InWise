package com.prod.inwise.dto;

import java.math.BigDecimal;

public class InvoiceDTO extends BaseDTO {

	private TraderDTO trader;

	private BigDecimal totalTax;

	private BigDecimal totalPrice;

	private String buyerName;

	private String dispatchedThrough;

	private String dispatchedDocumentNo;

	private String destination;

	private String modeOfPayment;

	private String supplierReference;

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
	 * @param totalTax
	 *            the totalTax to set
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
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * @param buyerName
	 *            the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * @return the dispatchedThrough
	 */
	public String getDispatchedThrough() {
		return dispatchedThrough;
	}

	/**
	 * @param dispatchedThrough
	 *            the dispatchedThrough to set
	 */
	public void setDispatchedThrough(String dispatchedThrough) {
		this.dispatchedThrough = dispatchedThrough;
	}

	/**
	 * @return the dispatchedDocumentNo
	 */
	public String getDispatchedDocumentNo() {
		return dispatchedDocumentNo;
	}

	/**
	 * @param dispatchedDocumentNo
	 *            the dispatchedDocumentNo to set
	 */
	public void setDispatchedDocumentNo(String dispatchedDocumentNo) {
		this.dispatchedDocumentNo = dispatchedDocumentNo;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}

	/**
	 * @param modeOfPayment
	 *            the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	/**
	 * @return the supplierReference
	 */
	public String getSupplierReference() {
		return supplierReference;
	}

	/**
	 * @param supplierReference
	 *            the supplierReference to set
	 */
	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}
}