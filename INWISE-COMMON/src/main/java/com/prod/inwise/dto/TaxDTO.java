package com.prod.inwise.dto;

import java.math.BigDecimal;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxDTO extends BaseDTO {
	
	private BigDecimal cgst;
	
	private BigDecimal sgst;
	
	private TraderDTO trader;

	/**
	 * @return the cgst
	 */
	public BigDecimal getCgst() {
		return cgst;
	}

	/**
	 * @param cgst the cgst to set
	 */
	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	/**
	 * @return the sgst
	 */
	public BigDecimal getSgst() {
		return sgst;
	}

	/**
	 * @param sgst the sgst to set
	 */
	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

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
}