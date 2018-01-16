package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity TAX
 * 
 * @author Logu
 *
 */
// CREATE TABLE TAX (
// ID BIGINT NOT NULL,
// CGST FLOAT NOT NULL,
// SGST FLOAT NOT NULL,
// STORE_ID BIGINT NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID),
// FOREIGN KEY (STORE_ID) REFERENCES STORE (ID)
// );

@Entity
@Table(name = "TAX")
@XmlRootElement
@ApiModel
public class Tax extends BaseModel {

	@Id
	@SequenceGenerator(name = "tax_seq", allocationSize = 1, sequenceName = "TAX_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;

	@NotNull(message = "CGST can't be null")
	@Column(name = "CGST", nullable = false)
	@ApiModelProperty
	private Float cgst;

	@NotNull(message = "SGST can't be null")
	@Column(name = "SGST", nullable = false)
	@ApiModelProperty
	private Float sgst;

	@OneToOne
	@JoinColumn(name = "STORE_ID", nullable = false)
	@ApiModelProperty
	private Shop store;

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
	public Shop getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Shop store) {
		this.store = store;
	}
}