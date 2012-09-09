package com.chinal.vo.base;

import java.io.Serializable;

public abstract class ValueObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6321419975370560426L;
	
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
