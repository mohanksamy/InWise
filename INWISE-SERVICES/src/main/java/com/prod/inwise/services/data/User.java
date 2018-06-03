package com.prod.inwise.services.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity USER
 * 
 * @author mohan_kandasamy
 *
 */
@Entity
@Table(name = "USERS") // Postgres doesn't allow table name to be USER because it's a reserved word
@XmlRootElement
@ApiModel
public class User extends BaseModel {

	@NotNull(message = "Name can't be null")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty
	private String name;

	@NotNull(message = "Username can't be null")
	@Column(name = "USER_NAME", nullable = false)
	@ApiModelProperty
	private String username;
	
	@NotNull(message = "Password can't be null")
	@Column(name = "PASSWORD", nullable = false)
	@ApiModelProperty
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "TRADER_ID", nullable = false)
	@ApiModelProperty
	private Trader trader;
	
	@Column(name = "LAST_LOGIN")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(name="LastLogin TS", value="Last login of the user", hidden = true)
	private Timestamp lastLogin;

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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the trader
	 */
	public Trader getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	/**
	 * @return the lastLogin
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}