package com.prod.inwise.dto;

/**
 * @author mohan_kandasamy
 *
 */
public class ModelDTO extends NameCodeDTO {

	private TraderDTO trader;

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