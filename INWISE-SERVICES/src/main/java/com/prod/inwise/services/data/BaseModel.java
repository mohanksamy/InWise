package com.prod.inwise.services.data;

import java.sql.Timestamp;

import javax.persistence.Column;
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
	
	@Column(name = "ACTIVE")
	@ApiModelProperty(hidden = true)
	private boolean active = true;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "CREATED_USER", nullable = false, insertable = true, updatable = false)
	private String createdUser;

	@ApiModelProperty(hidden = true)
	@Column(name = "CREATED_TS", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp createdTS;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "MODIFIED_USER", nullable = false, insertable = true, updatable = true)
	private String modifiedUser;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "MODIFIED_TS", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp modifiedTS;

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