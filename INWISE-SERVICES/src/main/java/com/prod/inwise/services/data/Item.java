package com.prod.inwise.services.data;

import java.math.BigInteger;

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

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity ITEM
 * 
 * @author Logu
 *
 */
// CREATE TABLE ITEM (
// ID BIGINT NOT NULL,
// NAME TEXT NOT NULL,
// PART_NO BIGINT,
// PRICE FLOAT NOT NULL,
// HSN_SAC TEXT,
// CATEGORY CATEGORY,
// SUB_CATEGORY SUB_CATEGORY,
// BRAND BRAND,
// SIZE SIZE,
// STORE_ID BIGINT NOT NULL,
// TAX_ID BIGINT NOT NULL,
// ACTIVE BOOLEAN NOT NULL,
// CREATED_USER TEXT NOT NULL,
// CREATED_TS TIMESTAMP NOT NULL,
// MODIFIED_USER TEXT NOT NULL,
// MODIFIED_TS TIMESTAMP NOT NULL,
// PRIMARY KEY (ID),
// FOREIGN KEY (STORE_ID) REFERENCES STORE (ID),
// FOREIGN KEY (TAX_ID) REFERENCES TAX (ID)
// );

@Entity
@Table(name = "ITEM")
@XmlRootElement
@ApiModel
public class Item extends BaseModel {

	@Id
	@SequenceGenerator(name = "item_seq", allocationSize = 1, sequenceName = "ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@Column(name = "ID")
	@ApiModelProperty(hidden = true)
	private Long id;

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

	@Column(name = "CATEGORY")
	@ApiModelProperty
	private String category;

	@Column(name = "SUB_CATEGORY")
	@ApiModelProperty
	private String subCategory;

	@Column(name = "BRAND")
	@ApiModelProperty
	private String brand;

	@Column(name = "SIZE")
	@ApiModelProperty
	private String size;

	@ManyToOne
	@JoinColumn(name = "STORE_ID", nullable = false)
	@ApiModelProperty
	private Store store;

	@ManyToOne
	@JoinColumn(name = "TAX_ID", nullable = false)
	@ApiModelProperty
	private Tax tax;

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
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
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