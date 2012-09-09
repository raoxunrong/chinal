package com.chinal.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.chinal.vo.base.ValueObject;

public class AdminVO extends ValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2331563875141408683L;

	@NotEmpty(message = "LoginName should not to be empty")
	private String loginName;

	@NotEmpty
	@Size(max = 64)
	private String password;

	private String name;
	
	private String phone;

	private String email;
	
	private boolean superAdmin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.superAdmin = isSuperAdmin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
