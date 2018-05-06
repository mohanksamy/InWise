package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity CATEGORY
 * 
 * @author mohan_kandasamy
 *
 */

@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@ApiModel
public class Category extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "category_seq", allocationSize = 1, sequenceName = "CATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private BigInteger id;*/

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty(name="Name", value="Name of the Store")
	private String name;

	@OneToOne
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	@ApiModelProperty
	private Merchant merchant;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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