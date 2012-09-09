package com.chinal.vo;

import javax.xml.bind.annotation.XmlRootElement;

import com.chinal.vo.base.ValueObject;

@XmlRootElement
public class CityVO extends ValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9179849992476817327L;

	private String name;

	private long provinceId;

	private String description;

	public CityVO(long id) {
		this.id = id;
	}

	public CityVO() {
		super();
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

	public long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	@Override
	public String toString() {
		return "CityVO {id=[" + id + "], name=[" + name + "]}";
	}
	
}
