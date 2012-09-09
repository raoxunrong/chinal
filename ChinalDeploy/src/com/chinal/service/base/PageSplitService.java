package com.chinal.service.base;

import java.util.List;

import com.chinal.vo.base.ValueObject;

public interface PageSplitService<T extends ValueObject> extends BaseService<T> {

	public List<T> getByPageSplit(int curPage, int pageSize);
}
