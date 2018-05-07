package com.prod.inwise.services.data;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * Base model for all Entities
 * 
 * @author mohan.kandasamy
 *
 */
@MappedSuperclass
public abstract class BaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	@ApiModelProperty(name="Id", value="Id of the entity", hidden = true)
	private BigInteger id;
	
	@Column(name = "ACTIVE")
	@ApiModelProperty(name="Active", value="Active flag of the entity", hidden = true)
	private boolean active = true;
	
	@Column(name = "CREATED_USER", nullable = false, insertable = true, updatable = false)
	@ApiModelProperty(name="Created User", value="Created User of the entity", hidden = true)
	private String createdUser;

	@Column(name = "CREATED_TS", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(name="Created TS", value="Created Timestamp of the entity", hidden = true)
	private Timestamp createdTS;
	
	@Column(name = "MODIFIED_USER", nullable = false, insertable = true, updatable = true)
	@ApiModelProperty(name="Modified User", value="Modified User of the entity", hidden = true)
	private String modifiedUser;
	
	@Column(name = "MODIFIED_TS", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(name="Modified TS", value="Modified Timestamp of the entity", hidden = true)
	private Timestamp modifiedTS;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the createdTS
	 */
	public Timestamp getCreatedTS() {
		return createdTS;
	}

	/**
	 * @param createdTS the createdTS to set
	 */
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}

	/**
	 * @return the modifiedUser
	 */
	public String getModifiedUser() {
		return modifiedUser;
	}

	/**
	 * @param modifiedUser the modifiedUser to set
	 */
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	/**
	 * @return the modifiedTS
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

	/**
	 * @param modifiedTS the modifiedTS to set
	 */
	public void setModifiedTS(Timestamp modifiedTS) {
		this.modifiedTS = modifiedTS;
	}
}