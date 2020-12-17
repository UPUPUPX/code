package com.item.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Attendance;
import com.item.model.Page;
import com.item.utiles.C3P0Utiles;
import com.item.utiles.StringUtiles;


/**
 *
 */
public class AttendanceDao  {
	/**
	 */
	private QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public boolean addAttendance(Attendance attendance) throws SQLException{
		String sql = "insert into s_attendance values(null,"+attendance.getCourseId()+","+attendance.getStudentId()+",'"+attendance.getType()+"','"+attendance.getDate()+"')";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * @throws SQLException 
	 */
	public boolean isAttendanced(int studentId,int courseId,String type,String date) throws SQLException{
		String sql = "select * from s_attendance where studentId = " + studentId + " and courseId = " + courseId + " and type = '" + type + "' and date = '" + date + "'";
		Attendance res=queryRunner.query(sql, new BeanHandler<>(Attendance.class));
		return res==null?false:true;
	}
	
	/**
	 * @throws SQLException 
	 */
	public List<Attendance> getSelectedCourseList(Attendance attendace,Page page) throws SQLException{
		List<Attendance> ret = new ArrayList<Attendance>();
		String sql = "select * from s_attendance ";
		if(attendace.getStudentId() != 0){
			sql += " and studentId = " + attendace.getStudentId();
		}
		if(attendace.getCourseId() != 0){
			sql += " and courseId = " + attendace.getCourseId();
		}
		if(!StringUtiles.isEmpty(attendace.getType())){
			sql += " and type = '" + attendace.getType() + "'";
		}
		if(!StringUtiles.isEmpty(attendace.getDate())){
			sql += " and date = '" + attendace.getDate() + "'";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		sql = sql.replaceFirst("and", "where");
		ret=queryRunner.query(sql, new BeanListHandler<>(Attendance.class));
		return ret;
	}
	
	/**
	 * @throws SQLException 
	 */
	public int getAttendanceListTotal(Attendance attendance) throws SQLException{
		String sql = "select count(*)as total from s_attendance ";
		if(attendance.getStudentId() != 0){
			sql += " and studentId = " + attendance.getStudentId();
		}
		if(attendance.getCourseId() != 0){
			sql += " and courseId = " + attendance.getCourseId();
		}
		Long total=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<>());
		return total.intValue();
	}
	
	/**
	 * @throws SQLException 
	 */
	public boolean deleteAttendance(int id) throws SQLException{
		String sql = "delete from s_attendance where id = " + id;
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
}
