package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity STOCK_HISTORY
 * 
 * @author Logu
 *
 */

// CREATE TABLE STOCK_HISTORY (
// ID BIGINT NOT NULL,
// STOCK_BATCH_ID BIGINT NOT NULL,
// ITEM_ID BIGINT NOT NULL,
// VENDOR_ID BIGINT NOT NULL,
// BASE_PRICE FLOAT NOT NULL,
// QUANTITY INTEGER NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID),
// FOREIGN KEY (STOCK_BATCH_ID) REFERENCES STOCK_BATCH (ID),
// FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID),
// FOREIGN KEY (VENDOR_ID) REFERENCES VENDOR (ID)
// );

@Entity
@Table(name = "STOCK_HISTORY")
@XmlRootElement
public class StockHistory extends BaseModel {

	@Id
	@SequenceGenerator(name = "stock_history_seq", allocationSize = 1, sequenceName = "STOCK_HISTORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_history_seq")
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "STOCK_BATCH_ID", nullable = false)
	private StockBatch stockBatch;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	@ManyToOne
	@JoinColumn(name = "VENDOR_ID", nullable = false)
	private Vendor vendor;

	@Column(name = "BASE_PRICE", nullable = false)
	@NotNull(message = "Base Price can't be null")
	private Long basePrice;

	@Column(name = "QUANTITY", nullable = false)
	@NotNull(message = "Quantity can't be null")
	private Integer quantity;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the stockBatch
	 */
	public StockBatch getStockBatch() {
		return stockBatch;
	}

	/**
	 * @param stockBatch
	 *            the stockBatch to set
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
	 * @param item
	 *            the item to set
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
	 * @param vendor
	 *            the vendor to set
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
	 * @param basePrice
	 *            the basePrice to set
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
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}