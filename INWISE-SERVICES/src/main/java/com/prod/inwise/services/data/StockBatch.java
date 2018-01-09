/**
 * 
 */
package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity STOCK_BATCH
 * 
 * @author Logu
 *
 */

// CREATE TABLE STOCK_BATCH (
// ID BIGINT NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID)
// );

@Entity
@Table(name = "STOCK_BATCH")
@XmlRootElement
public class StockBatch extends BaseModel {

	@Id
	@SequenceGenerator(name = "stock_batch_seq", allocationSize = 1, sequenceName = "STOCK_BATCH_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_batch_seq")
	@Column(name="ID")
	private Long id;

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

}
