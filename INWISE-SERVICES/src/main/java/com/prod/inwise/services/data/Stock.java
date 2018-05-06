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
 * Entity STOCK
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "STOCK")
@XmlRootElement
@ApiModel
public class Stock extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "stock_seq", allocationSize = 1, sequenceName = "STOCK_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;*/

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	@ApiModelProperty
	private Item item;

	@Column(name = "QUANTITY", nullable = false)
	@NotNull(message = "Quantity can't be null")
	@ApiModelProperty
	private Integer quantity;

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
}