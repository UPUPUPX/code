package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Admin;
import com.item.model.Page;
import com.item.model.Teacher;
import com.item.utiles.C3P0Utiles;
import com.item.utiles.StringUtiles;

/**
 * 
 */
public class TeacherDao {
	private QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public boolean addTeacher(Teacher teacher) throws SQLException{
		String sql = "insert into s_teacher values(null,'"+teacher.getSn()+"','"+teacher.getName()+"'";
		sql += ",'" + teacher.getPassword() + "'," + teacher.getClazzId();
		sql += ",'" + teacher.getSex() + "','" + teacher.getMobile() + "'";
		sql += ",'" + teacher.getQq() + "',null)";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public boolean editTeacher(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update s_teacher set name = '"+teacher.getName()+"'";
		sql += ",sex = '" + teacher.getSex() + "'";
		sql += ",mobile = '" + teacher.getMobile() + "'";
		sql += ",qq = '" + teacher.getQq() + "'";
		sql += ",clazzId = " + teacher.getClazzId();
		sql += " where id = " + teacher.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public boolean deleteTeacher(String ids) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from s_teacher where id in("+ids+")";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public Teacher getTeacher(int id) throws SQLException{
		String sql = "select * from s_teacher where id = " + id;
		Teacher teacher=queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class));
		return teacher;
	}
	public List<Teacher> getTeacherList(Teacher teacher,Page page) throws SQLException{
		List<Teacher> ret = new ArrayList<Teacher>();
		String sql = "select * from s_teacher ";
		if(!StringUtiles.isEmpty(teacher.getName())){
			sql += "and name like '%" + teacher.getName() + "%'";
		}
		if(teacher.getClazzId() != 0){
			sql += " and clazzId = " + teacher.getClazzId();
		}
		if(teacher.getId() !=0 ){
			sql += " and id = " + teacher.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ret=queryRunner.query(sql.replaceFirst("and", "where"), new BeanListHandler<>(Teacher.class));
		return ret;
	}
	public int getTeacherListTotal(Teacher teacher) throws SQLException{
		String sql = "select count(*)as total from s_teacher ";
		if(!StringUtiles.isEmpty(teacher.getName())){
			sql += "and name like '%" + teacher.getName() + "%'";
		}
		if(teacher.getClazzId() != 0){
			sql += " and clazzId = " + teacher.getClazzId();
		}
		if(teacher.getId() !=0 ){
			sql += " and id = " + teacher.getId();
		}
		Long total=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<Long>());
		return total.intValue();
	}
	public Teacher login(String name ,String password) throws SQLException{
		String sql = "select * from s_teacher where name = '" + name + "' and password = '" + password + "'";
		Teacher teacher=queryRunner.query(sql, new BeanHandler<>(Teacher.class));
		return teacher;
	}
	public boolean editPassword(Teacher teacher,String newPassword) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update s_teacher set password = '"+newPassword+"' where id = " + teacher.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
}
