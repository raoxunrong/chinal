package com.chinal.vo;

import com.chinal.vo.base.ValueObject;

public class LoanCompanyVO extends ValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2569836364362396806L;

	private String name;

	private long cityId;
	
	private String cityName;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityID) {
		this.cityId = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
