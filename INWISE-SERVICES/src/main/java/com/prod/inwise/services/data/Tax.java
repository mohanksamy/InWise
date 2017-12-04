package com.prod.inwise.services.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

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
public class Tax extends BaseModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "CGST can't be null")
	@NotBlank(message = "CGST can't be blank")
	@Column(name = "CGST", nullable = false)
	private Float cgst;

	@NotNull(message = "SGST can't be null")
	@NotBlank(message = "SGST can't be blank")
	@Column(name = "SGST", nullable = false)
	private Float sgst;

	@OneToMany
	@JoinColumn(name = "STORE_ID", nullable = false)
	private List<Store> store;

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
	 * @return the cgst
	 */
	public Float getCgst() {
		return cgst;
	}

	/**
	 * @param cgst
	 *            the cgst to set
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
	 * @param sgst
	 *            the sgst to set
	 */
	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	/**
	 * @return the store
	 */
	public List<Store> getStore() {
		return store;
	}

	/**
	 * @param store
	 *            the store to set
	 */
	public void setStore(List<Store> store) {
		this.store = store;
	}

}