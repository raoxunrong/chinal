package com.chinal.domain;

import java.util.Date;

import com.chinal.domain.base.DomainObj;

public class LendRecord extends DomainObj {

	private User user;

	private City city;

	private int money;

	private String allotedTime;

	private Date applyDate;

	private String extraInfo;

	private int interestRate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getAllotedTime() {
		return allotedTime;
	}

	public void setAllotedTime(String allotedTime) {
		this.allotedTime = allotedTime;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
}
