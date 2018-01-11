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
 * Entity STOCK
 * 
 * @author Logu
 *
 */

//CREATE TABLE STOCK (
//		ID              	BIGINT      	NOT NULL,
//	  	ITEM_ID         	BIGINT      	NOT NULL,
//	  	QUANTITY			INTEGER     	NOT NULL,
//	  	ACTIVE          	BOOLEAN     	NOT NULL,
//	  	CREATED_USER    	TEXT        	NOT NULL,
//	  	CREATED_TS      	TIMESTAMP   	NOT NULL,
//	  	MODIFIED_USER   	TEXT        	NOT NULL,
//	  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
//	  	PRIMARY KEY     	(ID),
//	  	FOREIGN KEY     	(ITEM_ID)  		REFERENCES ITEM (ID)
//	);

@Entity
@Table(name = "STOCK")
@XmlRootElement
public class Stock extends BaseModel {

	@Id
	@SequenceGenerator(name = "stock_seq", allocationSize = 1, sequenceName = "STOCK_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

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

}
