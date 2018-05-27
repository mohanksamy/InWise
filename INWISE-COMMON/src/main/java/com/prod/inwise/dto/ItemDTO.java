package com.prod.inwise.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author mohan_kandasamy
 *
 */
public class ItemDTO extends NameCodeDTO {
	
	private BigInteger partNo;

	private BigDecimal price;

	private String hsnSac;

	private CategoryDTO category;

	private SubCategoryDTO subCategory;

	private BrandDTO brand;

	private ModelDTO model;

	private TraderDTO trader;
	
	private TaxDTO tax;

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
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
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
	public CategoryDTO getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public SubCategoryDTO getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(SubCategoryDTO subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the brand
	 */
	public BrandDTO getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public ModelDTO getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(ModelDTO model) {
		this.model = model;
	}

	/**
	 * @return the trader
	 */
	public TraderDTO getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(TraderDTO trader) {
		this.trader = trader;
	}

	/**
	 * @return the store
	 */
	public TraderDTO getStore() {
		return trader;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(TraderDTO store) {
		this.trader = store;
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