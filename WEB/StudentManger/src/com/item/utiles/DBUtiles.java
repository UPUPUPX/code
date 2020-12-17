package com.item.utiles;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class DBUtiles {
	public static void main(String[] args) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		int cnt=queryRunner.update("update stu set name='hhh' where sno=1");
		if(cnt>0) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
	}
}
