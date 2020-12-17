package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Page;
import com.item.model.Student;
import com.item.utiles.C3P0Utiles;
import com.item.utiles.StringUtiles;

public class StudentDao {
	public Student login(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql = "select * from s_student where name = '" + name + "' and password = '" + password + "'";
		Student stu=queryRunner.query(sql, new BeanHandler<>(Student.class));
		return stu;
	}
	public Boolean addStuden(Student stu) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql="insert into s_student values(null,?,?,?,?,?,?,?,null)";
		Object parms[]= {stu.getSn(),stu.getName(),stu.getPassword(),stu.getClazzId()
				,stu.getSex(),stu.getMobile(),stu.getQq()};
		int cnt=queryRunner.update(sql,parms);
		if(cnt>0)return true;
		else return false;
	}
	public boolean editStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql = "update s_student set name = '"+student.getName()+"'";
		sql += ",sex = '" + student.getSex() + "'";
		sql += ",mobile = '" + student.getMobile() + "'";
		sql += ",qq = '" + student.getQq() + "'";
		sql += ",clazzId = " + student.getClazzId();
		sql += " where id = " + student.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public Student getStudent(int id) throws SQLException, ClassNotFoundException {
		String sql="select * from s_student where id=?";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		Student stu=queryRunner.query(sql, new BeanHandler<Student>(Student.class),id);
		return stu;
	}
	public List<Student> getStudentList(Student student,Page page) throws SQLException, ClassNotFoundException{
		List<Student> ret = new ArrayList<Student>();
		String sql = "select * from s_student ";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		if(!StringUtiles.isEmpty(student.getName())){
			sql += "and name like '%" + student.getName() + "%'";
		}
		if(student.getClazzId() != 0){
			sql += " and clazzId = " + student.getClazzId();
		}
		if(student.getId() != 0){
			sql += " and id = " + student.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ret=queryRunner.query(sql.replaceFirst("and", "where"), new BeanListHandler<Student>(Student.class));
		return ret;
	}
	public int getStudentListTotal(Student stu) throws SQLException {
		String sql = "select count(*)as total from s_student ";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		if(!StringUtiles.isEmpty(stu.getName())){
			sql += "and name like '%" + stu.getName() + "%'";
		}
		if(stu.getClazzId() != 0){
			sql += " and clazzId = " + stu.getClazzId();
		}
		if(stu.getId() != 0){
			sql += " and id = " + stu.getId();
		}
		Long total=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<Long>());
		return total.intValue();
	}
	public boolean setStudentPhoto(Student student) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update s_student set photo = ? where id = ?";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		int cnt=queryRunner.update(sql,student.getPhoto(),student.getId());
		return cnt>0?true:false;
	}
	public boolean deleteStudent(String ids) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql = "delete from s_student where id in("+ids+")";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public boolean editPassword(Student student, String newPassword) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		String sql = "update s_student set password = '"+newPassword+"' where id = " + student.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	public static void main(String[] args) throws SQLException {
		//测试addStuden
//		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
//		String sql="insert into s_student values(null,?,?,?,?,?,?,?,null)";
//		Object parms[]= {"111","2222","333",4,"555"
//				,"666","777"};
//		int cnt=queryRunner.update(sql,parms);
//		if(cnt>0) {
//			System.out.println("添加成功");
//		}else {
//			System.out.println("添加失败");
//		}
//		测试getStudent
		String sql="select * from s_student where id=?";
		QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
		Student stu=queryRunner.query(sql, new BeanHandler<Student>(Student.class),2);
		System.out.println(stu.getName()+" "+stu.getSex());
	}
}
