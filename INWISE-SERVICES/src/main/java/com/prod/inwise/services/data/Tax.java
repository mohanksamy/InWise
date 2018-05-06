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

@Entity
@Table(name = "TAX")
@XmlRootElement
@ApiModel
public class Tax extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "tax_seq", allocationSize = 1, sequenceName = "TAX_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;*/

	@NotNull(message = "CGST can't be null")
	@Column(name = "CGST", nullable = false)
	@ApiModelProperty
	private Float cgst;

	@NotNull(message = "SGST can't be null")
	@Column(name = "SGST", nullable = false)
	@ApiModelProperty
	private Float sgst;

	@OneToOne
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	@ApiModelProperty
	private Merchant merchant;

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
	 * @return the merchant
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
}