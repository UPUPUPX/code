package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Clazz;
import com.item.model.Page;
import com.item.utiles.C3P0Utiles;
import com.item.utiles.StringUtiles;

public class ClazzDao {
	public List<Clazz>getClazzList(Clazz clazz,Page page) throws SQLException{
		List<Clazz>ret=new ArrayList<Clazz>();
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql="select * from s_clazz";
		if(!StringUtiles.isEmpty(clazz.getName())) {
			sql+=" where name like '%"+clazz.getName()+"%'";
		}
		sql+=" limit "+page.getStart()+","+page.getPageSize();
		ret=queryRunner.query(sql, new BeanListHandler<Clazz>(Clazz.class));
		return ret;
	}
	public int getClazzListTotal(Clazz clazz) throws SQLException {
		String sql="select count(*) as total  from s_clazz ";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		if(!StringUtiles.isEmpty(clazz.getName())) {
			sql+="where name like '%"+clazz.getName()+"%'";
		}
		Long total=queryRunner.query(sql, new ScalarHandler<Long>());
		return total.intValue();
	}
	public int addClazz(Clazz clazz) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql="insert into s_clazz values(null,?,?)";
		int cnt=queryRunner.update(sql,clazz.getName(),clazz.getInfo());
		return cnt;
	}
	public int deleteClazz(Integer id) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql="delete from s_clazz where id=?";
		int cnt=queryRunner.update(sql,id);
		return cnt;
	}
	public int editClazz(Clazz clazz) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql="update s_clazz set name=?,info=? where id=?";
		int cnt=queryRunner.update(sql,clazz.getName(),clazz.getInfo(),clazz.getId());
		return cnt;
	}
	public static void main(String[] args) throws SQLException {
//		1.测试getClazzList
//		List<Clazz>ret=new ArrayList<Clazz>();
//		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
//		String sql="select * from s_clazz";
//		sql+=" where name like '%"+"数媒"+"%'";
//		sql+=" limit 0,9";
//		ret=queryRunner.query(sql, new BeanListHandler<Clazz>(Clazz.class));
//		for(Clazz clazz:ret) {
//			System.out.println(clazz.getName()+" "+clazz.getInfo());
//		}
//		2.测试getClazzListTotal
//		String sql="select count(*) as total  from s_clazz ";
//		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
//		Long total=queryRunner.query(sql, new ScalarHandler<Long>());
//		System.out.println(total.intValue());
		
//		String sql="select name  from s_clazz where id=1";
//		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
//		String total=(String) queryRunner.query(sql, new ScalarHandler("name"));
//		System.out.println(total);
		
//		测试addClazz
//		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
//		String sql="insert into s_clazz values(null,?,?)";
//		int cnt=queryRunner.update(sql,"刘园","刘园");
//		if(cnt>0) {
//			System.out.println("成功");
//		}else {
//			System.out.println("失败");
//		}
		
	}
	


	
}
