package com.chinal.domain;

import com.chinal.domain.base.DomainObj;

public class LoanCompany extends DomainObj {

	private String name;
	
	private City city;
	
	private String description;

	public LoanCompany() {
		super();
	}

	public LoanCompany(long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
