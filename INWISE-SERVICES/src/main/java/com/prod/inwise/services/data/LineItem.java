package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity LINE_ITEM
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "LINE_ITEM")
@XmlRootElement
@ApiModel
public class LineItem extends BaseModel {

	@ManyToOne
	@JoinColumn(name = "INVOICE_ID", nullable = false)
	@ApiModelProperty
	private Invoice invoice;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	@ApiModelProperty
	private Item item;

	@NotNull(message = "Quantity can't be null")
	@Column(name = "QUANTITY", nullable = false)
	@ApiModelProperty
	private Integer quantity;
	
	@JsonIgnore
	@Transient
	private Integer quantityInStock;

	@NotNull(message = "TotalTax can't be null")
	@Column(name = "TOTAL_TAX", nullable = false)
	@ApiModelProperty
	private Float totalTax;

	@NotNull(message = "TotalPrice can't be null")
	@Column(name = "TOTAL_PRICE", nullable = false)
	@ApiModelProperty
	private Float totalPrice;

	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
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
	 * @param item the item to set
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
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the quantityInStock
	 */
	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
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
}