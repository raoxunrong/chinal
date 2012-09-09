package com.chinal.vo;

import javax.validation.constraints.NotNull;

import com.chinal.vo.base.ValueObject;

public class ProvinceVO extends ValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 821616080893170055L;

	@NotNull
	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
