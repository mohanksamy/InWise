package com.prod.inwise.dto;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxDTO extends BaseDTO {
	
	private Float cgst;
	
	private Float sgst;
	
	private TraderDTO trader;

	/**
	 * @return the cgst
	 */
	public Float getCgst() {
		return cgst;
	}

	/**
	 * @param cgst the cgst to set
	 */
	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}

	/**
	 * @return the sgst
	 */
	public Float getSgst() {
		return sgst;
	}

	/**
	 * @param sgst the sgst to set
	 */
	public void setSgst(Float sgst) {
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