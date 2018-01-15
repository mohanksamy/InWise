package com.prod.inwise.dto;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxDTO extends BaseDTO {
	
	private Long id;
	
	private Float cgst;
	
	private Float sgst;
	
	private StoreDTO store;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the store
	 */
	public StoreDTO getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(StoreDTO store) {
		this.store = store;
	}
}