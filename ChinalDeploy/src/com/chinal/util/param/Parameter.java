package com.chinal.util.param;

import java.io.Serializable;


public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final String domain = "domain.";

	private String name; // ������

	private String value; // ����ֵ

	private int type = ParameterType.pString; // �������ͣ�Ĭ��ΪString

	private String link = ParameterLink.pAnd; // �������ӷ�Ĭ��Ϊand

	private String operator = ParameterOperator.pEqure; // �Ƚ�Ԥ���Ĭ��Ϊ=

	/**
	 * �����޲����췽��
	 */
	private Parameter() {
	}

	/**
	 * ���췽��
	 * 
	 * @param name
	 *            String
	 * @param value
	 *            String
	 */
	public Parameter(String name, String value) {
		this.name = domain + name;
		this.value = value;
	}

	/**
	 * ���췽��
	 * 
	 * @param name
	 *            String
	 * @param value
	 *            String
	 * @param type
	 *            int
	 */
	public Parameter(String name, String value, int type) {
		this.name = domain + name;
		this.value = value;
		this.type = type;
	}

	/**
	 * ���췽��
	 * 
	 * @param name
	 *            String
	 * @param value
	 *            String
	 * @param link
	 *            String
	 */
	public Parameter(String name, String value, String link) {
		this.name = domain + name;
		this.value = value;
		this.link = link;
	}

	/**
	 * ���췽��
	 * 
	 * @param name
	 *            String
	 * @param value
	 *            String
	 * @param type
	 *            int
	 * @param link
	 *            String
	 */
	public Parameter(String name, String value, int type, String link) {
		this.name = domain + name;
		this.value = value;
		this.type = type;
		this.link = link;
	}

	/**
	 * ���췽��
	 * 
	 * @param name
	 *            String
	 * @param value
	 *            String
	 * @param type
	 *            int
	 * @param link
	 *            String
	 * @param operator
	 *            String
	 */
	public Parameter(String name, String value, int type, String link,
			String operator) {
		this.name = domain + name;
		this.value = value;
		this.type = type;
		this.link = link;
		this.operator = operator;
	}
	
	/**
	 * ��ȡ������
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��ȡ����ֵ
	 * 
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * ��ȡ�������ӷ�
	 * 
	 * @return String
	 */
	public String getLink() {
		return link;
	}

	/**
	 * ��ȡ�Ƚϲ�����
	 * 
	 * @return String
	 */
	public String getOperator() {
		return operator;
	}

}
