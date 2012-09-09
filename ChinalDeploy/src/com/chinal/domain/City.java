package com.chinal.domain;

import com.chinal.domain.base.DomainObj;

public class City extends DomainObj {

	private String name;

	private Province province;

	private String description;

	public City() {
		super();
	}

	public City(long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
