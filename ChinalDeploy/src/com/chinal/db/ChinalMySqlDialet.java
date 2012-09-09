package com.chinal.db;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class ChinalMySqlDialet extends MySQL5InnoDBDialect {

	@Override
	public String getTableTypeString() {
		return super.getTableTypeString() + "  DEFAULT CHARSET=utf8";
	}

}
