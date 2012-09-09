package com.chinal.exception;

import com.chinal.domain.base.DomainObj;

public class DomainObjectNotExistException extends  Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1898633985079216745L;
	
	private Class domainObj;

	public <T extends DomainObj> DomainObjectNotExistException(Class<T> domainObj) {
		this.domainObj = domainObj;
	}

	@Override
	public String toString() {
		return domainObj.getName() + " not exist";
	}
	
	
}
