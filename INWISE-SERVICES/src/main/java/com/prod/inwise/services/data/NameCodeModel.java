package com.prod.inwise.services.data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

/**
 * Name & Code model for relevant Entities
 * 
 * @author mohan.kandasamy
 *
 */
@MappedSuperclass
public abstract class NameCodeModel extends BaseModel {

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	@Column(name = "NAME", nullable = false)
	@ApiModelProperty(name="Name", value="Name of the entity")
	private String name;

	@NotNull(message = "Code can't be null")
	@NotBlank(message = "Code can't be blank")
	@Column(name = "CODE", nullable = false)
	@ApiModelProperty(name="Code", value="Code of the entity")
	private String code;

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}