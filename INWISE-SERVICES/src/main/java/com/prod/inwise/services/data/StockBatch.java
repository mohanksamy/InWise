package com.prod.inwise.services.data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity STOCK_BATCH
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "STOCK_BATCH")
@XmlRootElement
@ApiModel
public class StockBatch extends BaseModel {
	
	@ManyToOne
	@JoinColumn(name = "TRADER_ID", nullable = false)
	@ApiModelProperty
	private Trader trader;

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