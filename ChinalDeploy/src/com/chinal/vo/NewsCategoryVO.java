package com.chinal.vo;

import com.chinal.vo.base.ValueObject;


public class NewsCategoryVO extends ValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6755986736111295857L;

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
