package com.prod.inwise.dto;

public class BuyerDTO {

	private String buyerName;

	private String despatchedThrough;
	
	private String despatchedDocumentNumber;
	
	private String destination;
	
	private String modeOrTermsOfPayment;
	
	private String supplierReference;

	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * @return the despatchedThrough
	 */
	public String getDespatchedThrough() {
		return despatchedThrough;
	}

	/**
	 * @param despatchedThrough the despatchedThrough to set
	 */
	public void setDespatchedThrough(String despatchedThrough) {
		this.despatchedThrough = despatchedThrough;
	}

	/**
	 * @return the despatchedDocumentNumber
	 */
	public String getDespatchedDocumentNumber() {
		return despatchedDocumentNumber;
	}

	/**
	 * @param despatchedDocumentNumber the despatchedDocumentNumber to set
	 */
	public void setDespatchedDocumentNumber(String despatchedDocumentNumber) {
		this.despatchedDocumentNumber = despatchedDocumentNumber;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the modeOrTermsOfPayment
	 */
	public String getModeOrTermsOfPayment() {
		return modeOrTermsOfPayment;
	}

	/**
	 * @param modeOrTermsOfPayment the modeOrTermsOfPayment to set
	 */
	public void setModeOrTermsOfPayment(String modeOrTermsOfPayment) {
		this.modeOrTermsOfPayment = modeOrTermsOfPayment;
	}

	/**
	 * @return the supplierReference
	 */
	public String getSupplierReference() {
		return supplierReference;
	}

	/**
	 * @param supplierReference the supplierReference to set
	 */
	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}
}