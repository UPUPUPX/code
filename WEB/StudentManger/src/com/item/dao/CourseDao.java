package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Course;
import com.item.model.Page;
import com.item.utiles.C3P0Utiles;
import com.item.utiles.StringUtiles;

public class CourseDao {
	private QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public boolean deleteCourse(String idStr) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from s_course where id in("+idStr+")";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}

	public boolean editCourse(Course course) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update s_course set name = '"+course.getName()+"',teacherId = "+course.getTeacherId()+",courseDate = '"+course.getCourseDate()+"',maxNum = "+course.getMaxNum()+" ,info = '"+course.getInfo()+"' where id = " + course.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}

	public int getCourseListTotal(Course course) throws SQLException {
		String sql = "select count(*)as total from s_course ";
		if(!StringUtiles.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
		}
		if(course.getTeacherId() != 0){
			sql += " and teacherId = " + course.getTeacherId() + "";
		}
		Long cnt=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<Long>());
		return cnt.intValue();
	}

	public List<Course> getCourseList(Course course, Page page) throws SQLException {
		// TODO Auto-generated method stub
		List<Course> ret = new ArrayList<Course>();
		String sql = "select * from s_course ";
		if(!StringUtiles.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
		}
		if(course.getTeacherId() != 0){
			sql += " and teacherId = " + course.getTeacherId() + "";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ret=queryRunner.query(sql.replaceFirst("and", "where"), new BeanListHandler<>(Course.class));
		return ret;
	}
	/**
	 * 检查该课程是否已选满
	 * @param courseId
	 * @return
	 */
	public boolean addCourse(Course course) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into s_course values(null,'"+course.getName()+"',"+course.getTeacherId()+",'"+course.getCourseDate()+"',0,"+course.getMaxNum()+",'"+course.getInfo()+"') ";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}

	public boolean isFull(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		boolean ret = false;
		String sql = "select * from s_course where selectedNum >= maxNum and id = " + courseId;
		Course cous=queryRunner.query(sql, new BeanHandler<>(Course.class));
		return cous==null?false:true;
	}
	/**
	 * 更新课程已选人数
	 * @param courseId
	 * @throws SQLException 
	 */
	public void updateCourseSelectedNum(int courseId ,int num) throws SQLException{
		String sql = "";
		if(num > 0){
			sql = "update s_course set selectedNum = selectedNum + "+ num + " where id = " + courseId;
		}else{
			sql = "update s_course set selectedNum = selectedNum - " + Math.abs(num) + " where id = " + courseId;
		}
		queryRunner.update(sql);
	}

	public List<Course> getCourse(String ids) throws SQLException {
		List<Course> ret = new ArrayList<Course>();
		String sql = "select * from s_course where id in(";
		if(!StringUtiles.isEmpty(ids)) {//ids=null说明该同学没有选修课程
			sql+=ids+")";
		}else {
			sql+="-1)";
		}
		ret=queryRunner.query(sql, new BeanListHandler<>(Course.class));
		return ret;
	}

	public Course getCourse(int id) throws SQLException {
		String sql = "select * from s_course where id = " + id;
		Course cous=queryRunner.query(sql, new BeanHandler<>(Course.class));
		return cous;
	}

}
