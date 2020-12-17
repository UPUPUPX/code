package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Page;
import com.item.model.SelectedCourse;
import com.item.utiles.C3P0Utiles;

public class SelectedCourseDao {
	public static QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public List<SelectedCourse> getSelectedCourseList(SelectedCourse selectedCourse,Page page) throws SQLException{
		List<SelectedCourse> ret = new ArrayList<SelectedCourse>();
		String sql = "select * from s_selected_course ";
		if(selectedCourse.getStudentId() != 0){
			sql += " and studentId = " + selectedCourse.getStudentId();
		}
		if(selectedCourse.getCourseId() != 0){
			sql += " and courseId = " + selectedCourse.getCourseId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ret=queryRunner.query(sql.replaceFirst("and", "where"), new BeanListHandler<>(SelectedCourse.class));
		return ret;
	}
	public int getSelectedCourseListTotal(SelectedCourse selectedCourse) throws SQLException{
		String sql = "select count(*)as total from s_selected_course ";
		if(selectedCourse.getStudentId() != 0){
			sql += " and studentId = " + selectedCourse.getStudentId();
		}
		if(selectedCourse.getCourseId() != 0){
			sql += " and courseId = " + selectedCourse.getCourseId();
		}
		Long cnt=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<Long>());
		return cnt.intValue();
	}
	/**
	 * 检查学生是否已经选择该门课程
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	public boolean isSelected(int studentId,int courseId) throws SQLException{
		boolean ret = false;
		String sql = "select * from s_selected_course where studentId = " + studentId + " and courseId = " + courseId;
		SelectedCourse sc=queryRunner.query(sql, new BeanHandler<>(SelectedCourse.class));
		return sc==null?false:true;
	}
	/**
	 * 添加选课信息
	 * @param selectedCourse
	 * @return
	 * @throws SQLException 
	 */
	public boolean addSelectedCourse(SelectedCourse selectedCourse) throws SQLException{
		String sql = "insert into s_selected_course values(null,"+selectedCourse.getStudentId()+","+selectedCourse.getCourseId()+")";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	/**
	 * 删除所选课程
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public boolean deleteSelectedCourse(int id) throws SQLException{
		String sql = "delete from s_selected_course where id = " + id;
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	/**
	 * 获取一条选课数据
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public SelectedCourse getSelectedCourse(int id) throws SQLException{
		SelectedCourse ret = null;
		String sql = "select * from s_selected_course where id = " + id;
		ret=queryRunner.query(sql, new BeanHandler<>(SelectedCourse.class));
		return ret;
	}
	public static void main(String[] args) throws SQLException {
		String sql = "select * from s_selected_course where studentId =5 and courseId=6";
		SelectedCourse sc=queryRunner.query(sql, new BeanHandler<>(SelectedCourse.class));
		System.out.println(sc);
	}
}
