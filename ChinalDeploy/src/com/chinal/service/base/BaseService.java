package com.chinal.service.base;

import com.chinal.exception.DomainObjectNotExistException;
import com.chinal.vo.base.ValueObject;

public interface BaseService<T extends ValueObject> {

	public T getByID(long id) throws DomainObjectNotExistException;
	
	public void add(T valueObj);
	
	public void update(T valueObj);
	
	public void deleteByID(long id);
	
	public long getTotalCount();
}
