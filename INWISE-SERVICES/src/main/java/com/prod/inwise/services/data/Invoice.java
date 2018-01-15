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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity INVOICE
 * 
 * @author Logu
 *
 */
// CREATE TABLE INVOICE (
// ID BIGINT NOT NULL,
// STORE_ID BIGINT NOT NULL,
// TOTAL_TAX FLOAT NOT NULL,
// TOTAL_PRICE FLOAT NOT NULL,
// BUYER_NAME TEXT,
// DESPATCHED_THROUGH TEXT,
// DESPATCHED_DOCUMENT_NO TEXT,
// DESTINATION TEXT,
// MODE_OR_TERMS_OF_PAYMENT TEXT,
// SUPPLIER_REFERENCE TEXT,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID),
// FOREIGN KEY (STORE_ID) REFERENCES STORE (ID)
// );

@Entity
@Table(name = "INVOICE")
@XmlRootElement
@ApiModel
public class Invoice extends BaseModel {

	@Id
	@SequenceGenerator(name = "invoice_seq", allocationSize = 1, sequenceName = "INVOICE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "STORE_ID", nullable = false)
	@ApiModelProperty
	private Store store;

	@NotNull(message = "TotalTax can't be null")
	@Column(name = "TOTAL_TAX", nullable = false)
	@ApiModelProperty
	private Float totalTax;

	@NotNull(message = "TotalPrice can't be null")
	@Column(name = "TOTAL_PRICE", nullable = false)
	@ApiModelProperty
	private Float totalPrice;

	@Column(name = "BUYER_NAME")
	@ApiModelProperty
	private String buyerName;

	@Column(name = "DESPATCHED_THROUGH")
	@ApiModelProperty
	private String dispatchedThrough;

	@Column(name = "DESPATCHED_DOCUMENT_NO")
	@ApiModelProperty
	private String dispatchedDocumentNo;

	@Column(name = "DESTINATION")
	@ApiModelProperty
	private String destination;

	@Column(name = "MODE_OR_TERMS_OF_PAYMENT")
	@ApiModelProperty
	private String modeOfPayment;

	@Column(name = "SUPPLIER_REFERENCE")
	@ApiModelProperty
	private String supplierReference;

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
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * @return the totalTax
	 */
	public Float getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(Float totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the totalPrice
	 */
	public Float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

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
	 * @return the dispatchedThrough
	 */
	public String getDispatchedThrough() {
		return dispatchedThrough;
	}

	/**
	 * @param dispatchedThrough the dispatchedThrough to set
	 */
	public void setDispatchedThrough(String dispatchedThrough) {
		this.dispatchedThrough = dispatchedThrough;
	}

	/**
	 * @return the dispatchedDocumentNo
	 */
	public String getDispatchedDocumentNo() {
		return dispatchedDocumentNo;
	}

	/**
	 * @param dispatchedDocumentNo the dispatchedDocumentNo to set
	 */
	public void setDispatchedDocumentNo(String dispatchedDocumentNo) {
		this.dispatchedDocumentNo = dispatchedDocumentNo;
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
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}

	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
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