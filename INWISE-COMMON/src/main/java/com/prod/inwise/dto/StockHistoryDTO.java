package com.prod.inwise.dto;

public class StockHistoryDTO extends BaseDTO {

	private Long id;

	private StockBatchDTO stockBatch;

	private ItemDTO item;

	private VendorDTO vendor;

	private Long basePrice;

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
	public StockBatchDTO getStockBatch() {
		return stockBatch;
	}

	/**
	 * @param stockBatch
	 *            the stockBatch to set
	 */
	public void setStockBatch(StockBatchDTO stockBatch) {
		this.stockBatch = stockBatch;
	}

	/**
	 * @return the item
	 */
	public ItemDTO getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(ItemDTO item) {
		this.item = item;
	}

	/**
	 * @return the vendor
	 */
	public VendorDTO getVendor() {
		return vendor;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(VendorDTO vendor) {
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