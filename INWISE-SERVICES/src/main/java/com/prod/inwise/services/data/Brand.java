package com.prod.inwise.services.data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity BRAND
 * 
 * @author mohan_kandasamy
 *
 */
@Entity
@Table(name = "BRAND")
@XmlRootElement
@ApiModel
public class Brand extends NameCodeModel {

	@OneToOne
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