package com.chinal.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinal.domain.base.DomainObj;
import com.chinal.util.param.Parameters;

public abstract class BaseDao<T extends DomainObj> extends HibernateDaoSupport {

	private Class<T> entityClass;

	protected String domainName;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}

	public List<T> find(Parameters parameters) {

		StringBuffer queryString = generateSelectSql();
		queryString.append(parameters.getWhere());
		return find(queryString.toString(), parameters.getAllValues().toArray());
	}

	public List<T> find(Parameters parameters, int curPage, int pageSize) {
		StringBuffer queryString = generateSelectSql();
		queryString.append(parameters.getWhere());
		return find(queryString.toString(),
				parameters.getAllValues().toArray(), pageSize * (curPage - 1),
				pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}

	public void deleteAll(Collection<T> c) {
		getHibernateTemplate().deleteAll(c);
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> find(String queryString, Object param) {
		return getHibernateTemplate().find(queryString, param);
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> find(String queryString, Object[] params) {
		return getHibernateTemplate().find(queryString, params);
	}

	public List<T> find(String queryString, int first, int max) {
		return find(queryString, new Object[] {}, first, max);
	}

	public List<T> find(String queryString, Object param, int first, int max) {
		return find(queryString, new Object[] { param }, first, max);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object[] params, int first, int max) {
		Query query = getSession().createQuery(queryString);
		for (int i = 0; i < params.length; i++)
			query.setParameter(i, params[i]);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public T getByID(Serializable pk) {
		return getHibernateTemplate().get(entityClass, pk);
	}

	public void save(T obj) {
		getHibernateTemplate().save(obj);
	}

	public Serializable saveObject(T obj) {
		return getHibernateTemplate().save(obj);

	}

	public void saveOrUpdate(T obj) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	public void saveOrUpdateAll(Collection<T> c) {
		getHibernateTemplate().saveOrUpdateAll(c);

	}

	public void update(T obj) {
		getHibernateTemplate().update(obj);

	}

	public long getCount(String queryString, Object[] params) {
		@SuppressWarnings("rawtypes")
		List list = find(queryString, params);
		if (list == null) {
			return 0;
		}
		long count = 0;
		try {
			count = (Long) list.get(0);
		} catch (Exception e) {
			// do nothing, just keep the original 0 value
		}
		return count;

	}

	public long getCount(String queryString) {
		return getCount(queryString, new Object[] {});
	}
	
	public long getCount(Parameters params) {
		String select = "select count(*) from " + getDomainName();
		String where = params.getWhere();
		return getCount(select + where, params.getAllValues().toArray());
	}

	public void merge(T obj) {
		getHibernateTemplate().merge(obj);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	public String getDomainName() {
		return domainName;
	}

	@Required
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	private StringBuffer generateSelectSql() {
		StringBuffer queryString = new StringBuffer("from ").append(
				getDomainName()).append(" as domain");
		return queryString;
	}
}
