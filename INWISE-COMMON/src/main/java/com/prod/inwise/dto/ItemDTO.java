package com.prod.inwise.dto;

import java.math.BigInteger;

import com.prod.inwise.enums.Brand;
import com.prod.inwise.enums.Category;
import com.prod.inwise.enums.Size;
import com.prod.inwise.enums.SubCategory;

/**
 * @author mohan_kandasamy
 *
 */
public class ItemDTO extends BaseDTO {
	
	private Long id;
	
	private String name;

	private BigInteger partNo;

	private Float price;

	private String hsnSac;

	private Category category;

	private SubCategory subCategory;

	private Brand brand;

	private Size size;

	private StoreDTO store;
	
	private TaxDTO tax;

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
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * @return the store
	 */
	public StoreDTO getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(StoreDTO store) {
		this.store = store;
	}

	/**
	 * @return the tax
	 */
	public TaxDTO getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(TaxDTO tax) {
		this.tax = tax;
	}
}