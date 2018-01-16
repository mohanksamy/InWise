package com.prod.inwise.dto;

/**
 * @author mohan_kandasamy
 *
 */
public abstract class BaseDTO {

	private boolean active;
	
	private String createdUser;

//	private Timestamp createdTS;
	
	private String modifiedUser;
	
//	private Timestamp modifiedTS;

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
	/*public Timestamp getCreatedTS() {
		return createdTS;
	}

	*//**
	 * @param createdTS the createdTS to set
	 *//*
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}*/

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
	/*public Timestamp getModifiedTS() {
		return modifiedTS;
	}

	*//**
	 * @param modifiedTS the modifiedTS to set
	 *//*
	public void setModifiedTS(Timestamp modifiedTS) {
		this.modifiedTS = modifiedTS;
	}*/
}