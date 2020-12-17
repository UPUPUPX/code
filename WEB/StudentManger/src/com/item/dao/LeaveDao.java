package com.item.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Attendance;
import com.item.model.Leave;
import com.item.model.Page;
import com.item.utiles.C3P0Utiles;


/**
 *
 */
public class LeaveDao  {
	/**
	 */
	private QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public boolean addLeave(Leave leave) throws SQLException{
		String sql = "insert into s_leave values(null,"+leave.getStudentId()+",'"+leave.getInfo()+"',"+Leave.LEAVE_STATUS_WAIT+",'"+leave.getRemark()+"')";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * @throws SQLException 
	 */
	public boolean editLeave(Leave leave) throws SQLException{
		String sql = "update s_leave set studentId = "+leave.getStudentId()+", info = '"+leave.getInfo()+"',status = "+leave.getStatus()+",remark = '"+leave.getRemark()+"' where id = " + leave.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * @throws SQLException 
	 */
	public boolean deleteLeave(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from s_leave where id = " + id ;
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * @throws SQLException 
	 */
	public List<Leave> getLeaveList(Leave leave,Page page) throws SQLException{
		List<Leave> ret = new ArrayList<Leave>();
		String sql = "select * from s_leave ";
		if(leave.getStudentId() != 0){
			sql += " and studentId = " + leave.getStudentId() + "";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ret=queryRunner.query(sql.replaceFirst("and", "where"), new BeanListHandler<>(Leave.class));
		return ret;
	}
	
	/**
	 * @throws SQLException 
	 */
	public int getLeaveListTotal(Leave leave) throws SQLException{
		String sql = "select count(*)as total from s_leave ";
		if(leave.getStudentId() != 0){
			sql += " and studentId = " + leave.getStudentId() + "";
		}
		Long total=queryRunner.query(sql.replaceFirst("and", "where"), new ScalarHandler<>());
		return total.intValue();
	}
}
