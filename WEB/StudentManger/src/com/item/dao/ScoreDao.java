package com.item.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.item.model.Attendance;
import com.item.model.Page;
import com.item.model.Score;
import com.item.utiles.C3P0Utiles;

/**
 * 成绩表数据库基础操作
 * @author llq
 *
 */
public class ScoreDao {
	/**
	 * 成绩录入
	 * @param score
	 * @return
	 */
	private QueryRunner queryRunner=new QueryRunner(C3P0Utiles.getDataSource());
	public boolean addScore(Score score) throws SQLException{
		String sql = "insert into s_score values(null,"+score.getStudentId()+","+score.getCourseId()+","+score.getScore()+",'"+score.getRemark()+"')";
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * 修改成绩信息
	 * @param score
	 * @return
	 * @throws SQLException 
	 */
	public boolean editScore(Score score) throws SQLException{
		String sql = "update s_score set studentId = " + score.getStudentId();
		sql += ",courseId = " + score.getCourseId();
		sql += ",score = " + score.getScore();
		sql += ",remark = '" + score.getRemark() + "'";
		sql += " where id = " + score.getId();
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	/**
	 * 判断成绩是否录入
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	public boolean isAdd(int studentId,int courseId) throws SQLException{
		String sql = "select * from s_score where studentId = " + studentId + " and courseId = " + courseId;
		Score res=queryRunner.query(sql, new BeanHandler<>(Score.class));
		return res==null?false:true;
	}

	/**
	 * 分页获取成绩列表
	 * @param score
	 * @param page
	 * @return
	 * @throws SQLException 
	 */
	public List<Score> getScoreList(Score score, Page page) throws SQLException {
		// TODO Auto-generated method stub
		List<Score> ret = new ArrayList<Score>();
		String sql = "select * from s_score ";
		if(score.getStudentId() != 0){
			sql += " and studentId = " + score.getStudentId();
		}
		if(score.getCourseId() != 0){
			sql += " and courseId = " + score.getCourseId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		sql = sql.replaceFirst("and", "where");
		ret=queryRunner.query(sql, new BeanListHandler<>(Score.class));
		return ret;
	}

	/**
	 * 获取符合某一条件的所有成绩列表
	 * @param score
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> getScoreList(Score score) throws SQLException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		String sql = "select s_score.*,s_student.name as studentName,s_course.name as courseName from s_score,s_student,s_course where s_score.studentId=s_student.id and s_score.courseId=s_course.id ";
		if(score.getStudentId() != 0){
			sql += " and studentId = " + score.getStudentId();
		}
		if(score.getCourseId() != 0){
			sql += " and courseId = " + score.getCourseId();
		}
		ret=queryRunner.query(sql, new MapListHandler());
		return ret;
	}
	
	/**
	 * 获取成绩总记录数
	 * @param score
	 * @return
	 * @throws SQLException 
	 */
	public int getScoreListTotal(Score score) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) as total from s_score ";
		if(score.getStudentId() != 0){
			sql += " and studentId = " + score.getStudentId();
		}
		if(score.getCourseId() != 0){
			sql += " and courseId = " + score.getCourseId();
		}
		sql = sql.replaceFirst("and", "where");
		Long total=queryRunner.query(sql, new ScalarHandler<>());
		return total.intValue();
	}

	/**
	 * 删除成绩
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public boolean deleteScore(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from s_score where id = " + id;
		int cnt=queryRunner.update(sql);
		return cnt>0?true:false;
	}
	
	public Map<String, Object> getAvgStats(Score score) throws SQLException{
		Map<String,Object> ret = new HashMap<String, Object>();
		String sql = "select max(s_score.score) as max_score,avg(s_score.score) as avg_score,min(s_score.score) as min_score,s_course.name as courseName from s_score,s_course where s_score.courseId=s_course.id and s_score.courseId = " + score.getCourseId();
		ret=queryRunner.query(sql, new MapHandler());
		return ret;
	}
}
