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
 * Entity INVOICE
 * 
 * @author Logu
 *
 */

@Entity
@Table(name = "INVOICE")
@XmlRootElement
@ApiModel
public class Invoice extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "invoice_seq", allocationSize = 1, sequenceName = "INVOICE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;*/

	@ManyToOne
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	@ApiModelProperty
	private Merchant merchant;

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
	
	@Column(name = "BUYER_ADDRESS")
	@ApiModelProperty
	private String buyerAddress;
	
	@Column(name = "REFERENCE_1")
	@ApiModelProperty
	private String reference1;

	@Column(name = "REFERENCE_2")
	@ApiModelProperty
	private String reference2;

	@Column(name = "REFERENCE_3")
	@ApiModelProperty
	private String reference3;

	@Column(name = "REFERENCE_4")
	@ApiModelProperty
	private String reference4;

	@Column(name = "REFERENCE_5")
	@ApiModelProperty
	private String reference5;

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
	 * @return the buyerAddress
	 */
	public String getBuyerAddress() {
		return buyerAddress;
	}

	/**
	 * @param buyerAddress the buyerAddress to set
	 */
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	/**
	 * @return the reference1
	 */
	public String getReference1() {
		return reference1;
	}

	/**
	 * @param reference1 the reference1 to set
	 */
	public void setReference1(String reference1) {
		this.reference1 = reference1;
	}

	/**
	 * @return the reference2
	 */
	public String getReference2() {
		return reference2;
	}

	/**
	 * @param reference2 the reference2 to set
	 */
	public void setReference2(String reference2) {
		this.reference2 = reference2;
	}

	/**
	 * @return the reference3
	 */
	public String getReference3() {
		return reference3;
	}

	/**
	 * @param reference3 the reference3 to set
	 */
	public void setReference3(String reference3) {
		this.reference3 = reference3;
	}

	/**
	 * @return the reference4
	 */
	public String getReference4() {
		return reference4;
	}

	/**
	 * @param reference4 the reference4 to set
	 */
	public void setReference4(String reference4) {
		this.reference4 = reference4;
	}

	/**
	 * @return the reference5
	 */
	public String getReference5() {
		return reference5;
	}

	/**
	 * @param reference5 the reference5 to set
	 */
	public void setReference5(String reference5) {
		this.reference5 = reference5;
	}
}