package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity ADDRESS
 * 
 * @author mohan.kandasamy
 *
 */
@Entity
@Table(name = "ADDRESS")
@ApiModel
public class Address extends BaseModel {
	
	@NotNull(message = "Street1 can't be null")
	@NotBlank(message = "Street1 can't be blank")
	@Column(name = "STREET1", nullable = false)
	@ApiModelProperty(name="Street1", value="Street1")
	private String street1;
	
	@Column(name = "STREET2", nullable = true)
	@ApiModelProperty(name="Street2", value="Street2")
	private String street2;
	
	@NotNull(message = "City can't be null")
	@NotBlank(message = "City can't be blank")
	@Column(name = "CITY", nullable = false)
	@ApiModelProperty(name="City", value="City")
	private String city;
	
	@Column(name = "REGION", nullable = true)
	@ApiModelProperty(name="Region", value="Region")
	private String region;
	
	@NotNull(message = "State can't be null")
	@NotBlank(message = "State can't be blank")
	@Column(name = "STATE", nullable = false)
	@ApiModelProperty(name="State", value="State")
	private String state;
	
	@NotNull(message = "Country can't be null")
	@NotBlank(message = "Country can't be blank")
	@Column(name = "COUNTRY", nullable = false)
	@ApiModelProperty(name="Country", value="Country")
	private String country;
	
	@Column(name = "POSTALCODE", nullable = true)
	@ApiModelProperty(name="PostalCode", value="PostalCode")
	private String postalCode;

	/**
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * @param street1 the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * @param street2 the street2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}