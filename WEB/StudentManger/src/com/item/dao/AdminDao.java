package com.item.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.item.model.Admin;
import com.item.utiles.C3P0Utiles;

public class AdminDao {
	public Admin login(Admin admin) throws SQLException{
		String sql="select * from s_admin where name=? and password=?";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		Admin result=queryRunner.query(sql, new BeanHandler<Admin>(Admin.class), admin.getName(),admin.getPassword());
		return result;	
	}

	public boolean editPassword(Admin admin, String newPassword) throws SQLException {
		String sql = "update s_admin set password = '"+newPassword+"' where name = " +"'"+admin.getName()+"'";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
}
