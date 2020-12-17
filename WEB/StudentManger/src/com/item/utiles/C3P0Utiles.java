package com.item.utiles;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utiles {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return dataSource;
	}
}
