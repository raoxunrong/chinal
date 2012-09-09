package com.chinal.util.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

public class Parameters implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Parameter> paramList = new ArrayList<Parameter>();

	private List<String> strList = new ArrayList<String>();

	/**
	 * 
	 * @param param
	 *            produce.util.param.Parameters
	 */
	public void add(Parameter param) {
		paramList.add(param);
	}

	public void add(String whereStr) {
		strList.add(whereStr);
	}

	/**
	 * 
	 * @return List
	 */
	public List getAll() {
		return paramList;
	}

	/**
	 * 
	 * @param params
	 */
	public void add(Parameters params) {
		List<Parameter> paramList = params.getParamList();
		if (paramList != null && !paramList.isEmpty()) {
			for (Parameter parameter : paramList) {
				this.paramList.add(parameter);
			}
		}
	}

	/**
	 * 
	 * @return List
	 */
	public List getAllNames() {
		List<String> nameList = new ArrayList<String>();
		for (int i = 0; i < paramList.size(); i++) {
			Parameter param = (Parameter) paramList.get(i);
			nameList.add(param.getName());
		}
		return nameList;
	}

	/**
	 * 
	 * @return List
	 */
	public List<Object> getAllValues() {
		List<Object> nameList = new ArrayList<Object>();
		for (int i = 0; i < paramList.size(); i++) {
			Parameter param = (Parameter) paramList.get(i);
			Object value = null;
			switch (param.getType()) {
			case ParameterType.pString:
				value = param.getValue();
				break;
			case ParameterType.pInteger:
				value = new Integer(param.getValue());
				break;
			case ParameterType.pLong:
				value = new Long(param.getValue());
				break;
			case ParameterType.pFloat:
				value = new Float(param.getValue());
				break;
			case ParameterType.pDouble:
				value = new Double(param.getValue());
				break;
			case ParameterType.pBoolean:
				value = new Boolean(param.getValue());
				break;
//			case ParameterType.pDate:
//				query
//						.setDate(i, DateUtil.toDate(param
//								.getValue()));
//				break;
			}
			nameList.add(value);
		}
		return nameList;
	}

	/**
	 * 
	 * @return int
	 */
	public int getCount() {
		return paramList.size();
	}

	/**
	 * 
	 * @return String
	 */
	public String getWhere() {
		String where = "";
		for (int i = 0; i < paramList.size(); i++) {
			Parameter param = (Parameter) paramList.get(i);
			if (i == 0)
				where = " where ";
			else
				where = where + " " + param.getLink();
			if (param.getOperator().equalsIgnoreCase(
					ParameterOperator.pLikeLeft)
					|| param.getOperator().equalsIgnoreCase(
							ParameterOperator.pLikeRight)) {
				where = where + " " + param.getName() + " "
						+ ParameterOperator.pLike + " ? ";
			} else if (param.getOperator().equals(ParameterOperator.pIs)) {
				where = where + " " + param.getName() + " "
						+ ParameterOperator.pIs + " null ";
			} else if (param.getOperator().equals(ParameterOperator.pIsNot)) {
				where = where + " " + param.getName() + " "
						+ ParameterOperator.pIs + " not null ";
			} else if (param.getOperator().equals(ParameterOperator.pIn)) {
				where = where + " " + param.getName() + " "
						+ ParameterOperator.pIn + "( ? )";
			} else {
				where = where + " " + param.getName() + " "
						+ param.getOperator() + " ? ";
			}
		}
		return where;
	}

	public String getWhereStr() {
		String whereStr = "";
		if (strList.size() != 0 && getWhere().equals("")) {
			whereStr = " where ";
		}
		for (int i = 0; i < strList.size(); i++) {
			if (whereStr.equals(" where ")) {
				whereStr = whereStr + " " + strList.get(i);
			} else
				whereStr = whereStr + "  and" + strList.get(i);
		}
		return whereStr;
	}

	/**
	 * 
	 * @param query
	 *            org.hibernate.Query
	 * @return org.hibernate.Query
	 */
	public Query setValue(Query query) {
		for (int i = 0; i < paramList.size(); i++) {
			Parameter param = (Parameter) paramList.get(i);
			switch (param.getType()) {
			case ParameterType.pString:
				if (param.getOperator().equalsIgnoreCase(
						ParameterOperator.pLike))
					query
							.setString(i, new String("%" + param.getValue()
									+ "%"));
				else if (param.getOperator().equalsIgnoreCase(
						ParameterOperator.pLikeLeft))
					query.setString(i, new String(param.getValue() + "%"));
				else if (param.getOperator().equalsIgnoreCase(
						ParameterOperator.pLikeRight))
					query.setString(i, new String("%" + param.getValue()));
				else
					query.setString(i, new String(param.getValue()));
				break;
			case ParameterType.pInteger:
				query.setInteger(i, new Integer(param.getValue()));
				break;
			case ParameterType.pLong:
				query.setLong(i, new Long(param.getValue()));
				break;
			case ParameterType.pFloat:
				query.setFloat(i, new Float(param.getValue()));
				break;
			case ParameterType.pDouble:
				query.setDouble(i, new Double(param.getValue()));
				break;
			case ParameterType.pBoolean:
				query.setBoolean(i, new Boolean(param.getValue()));
				break;
//			case ParameterType.pDate:
//				query
//						.setDate(i, DateUtil.toDate(param
//								.getValue()));
//				break;
			}
		}
		return query;
	}

	public List<Parameter> getParamList() {
		return paramList;
	}
}