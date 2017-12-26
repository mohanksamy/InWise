package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity LINE_ITEM
 * 
 * @author Logu
 *
 */
// CREATE TABLE LINE_ITEM (
// LINE_ITEM_ID BIGINT NOT NULL,
// INVOICE_ID BIGINT NOT NULL,
// ITEM_ID BIGINT NOT NULL,
// QUANTITY INTEGER NOT NULL,
// TOTAL_TAX FLOAT NOT NULL,
// TOTAL_PRICE FLOAT NOT NULL,
// --TOTAL_CGST FLOAT NOT NULL,
// --TOTAL_SGST FLOAT NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (LINE_ITEM_ID),
// FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE (ID),
// FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID)
// );

@Entity
@Table(name = "LINE_ITEM")
@XmlRootElement
public class LineItem extends BaseModel {

	@Id
	@Column(name = "LINE_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "INVOICE_ID", nullable = false)
	private Invoice invoice;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	@NotNull(message = "Quantity can't be null")
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;

	@NotNull(message = "TotalTax can't be null")
	@Column(name = "TOTAL_TAX", nullable = false)
	private Float totalTax;

	@NotNull(message = "TotalPrice can't be null")
	@Column(name = "TOTAL_PRICE", nullable = false)
	private Float totalPrice;

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
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice
	 *            the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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

	/**
	 * @return the totalTax
	 */
	public Float getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax
	 *            the totalTax to set
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
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
