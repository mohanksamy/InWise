package com.prod.inwise.services.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity ITEM
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
@ApiModel
public class Item extends BaseModel {

	/*@Id
	@SequenceGenerator(name = "item_seq", allocationSize = 1, sequenceName = "ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private BigInteger id;*/

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty
	private String name;

	@Column(name = "PART_NO")
	@ApiModelProperty
	private BigInteger partNo;

	@NotNull(message = "Price can't be null")
	@Column(name = "PRICE", nullable = false)
	@ApiModelProperty
	private Float price;

	@Column(name = "HSN_SAC")
	@ApiModelProperty
	private String hsnSac;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	@ApiModelProperty
	private Category category;

	@ManyToOne
	@JoinColumn(name = "SUBCATEGORY_ID", nullable = false)
	@ApiModelProperty
	private SubCategory subCategory;

	@ManyToOne
	@JoinColumn(name = "BRAND_ID", nullable = false)
	@ApiModelProperty
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "MODEL_ID", nullable = false)
	@ApiModelProperty
	private Model model;

	@ManyToOne
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	@ApiModelProperty
	private Merchant merchant;

	@ManyToOne
	@JoinColumn(name = "TAX_ID", nullable = false)
	@ApiModelProperty
	private Tax tax;

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
	 * @return the partNo
	 */
	public BigInteger getPartNo() {
		return partNo;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(BigInteger partNo) {
		this.partNo = partNo;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the hsnSac
	 */
	public String getHsnSac() {
		return hsnSac;
	}

	/**
	 * @param hsnSac the hsnSac to set
	 */
	public void setHsnSac(String hsnSac) {
		this.hsnSac = hsnSac;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public SubCategory getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
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

	/**
	 * @return the tax
	 */
	public Tax getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Tax tax) {
		this.tax = tax;
	}
}