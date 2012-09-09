package com.chinal.domain;

import com.chinal.domain.base.DomainObj;

public class NewsCategory extends DomainObj {

	private String name;
	
	private String description;

	public NewsCategory() {
		super();
	}

	public NewsCategory(long id) {
		super(id);
	}

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
