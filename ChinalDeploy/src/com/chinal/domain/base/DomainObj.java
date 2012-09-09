package com.chinal.domain.base;

public abstract class DomainObj {

	protected long id;
	
	public DomainObj(){}
	
	public DomainObj(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
