package com.prod.inwise.services.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

/**
 * Entity STOCK_BATCH
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "STOCK_BATCH")
@XmlRootElement
@ApiModel
public class StockBatch extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "stock_batch_seq", allocationSize = 1, sequenceName = "STOCK_BATCH_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_batch_seq")
	@Column(name="ID")
	@ApiModelProperty(hidden = true)
	private Long id;
	
	*//**
	 * @return the id
	 *//*
	public Long getId() {
		return id;
	}

	*//**
	 * @param id the id to set
	 *//*
	public void setId(Long id) {
		this.id = id;
	}*/
}