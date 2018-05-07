package com.prod.inwise.services.data;

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
 * Entity STOCK_HISTORY
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "STOCK_HISTORY")
@XmlRootElement
@ApiModel
public class StockHistory extends BaseModel {

	@ManyToOne
	@JoinColumn(name = "STOCK_BATCH_ID", nullable = false)
	@ApiModelProperty
	private StockBatch stockBatch;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	@ApiModelProperty
	private Item item;

	@ManyToOne
	@JoinColumn(name = "VENDOR_ID", nullable = false)
	@ApiModelProperty
	private Vendor vendor;

	@Column(name = "BASE_PRICE", nullable = false)
	@NotNull(message = "Base Price can't be null")
	@ApiModelProperty
	private Long basePrice;

	@Column(name = "QUANTITY", nullable = false)
	@NotNull(message = "Quantity can't be null")
	@ApiModelProperty
	private Integer quantity;

	/**
	 * @return the stockBatch
	 */
	public StockBatch getStockBatch() {
		return stockBatch;
	}

	/**
	 * @param stockBatch the stockBatch to set
	 */
	public void setStockBatch(StockBatch stockBatch) {
		this.stockBatch = stockBatch;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the basePrice
	 */
	public Long getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}