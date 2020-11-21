package Service;

import DAO.TEACHER;
import DAO.USER;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherService {
    public TEACHER FindTeacher(String str) throws SQLException {
        String sql = "select * from TEACHER where TName=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            TEACHER teacher = new TEACHER();
            teacher.setID(rs.getInt("ID"));
            teacher.setTName(rs.getString("TName"));
            teacher.setCourseName(rs.getString("CourseName"));
            teacher.setBName(rs.getString("BName"));
            teacher.setFlag(rs.getInt("flag"));
            conn.close();
            return teacher;
        }else{
            conn.close();
            return null;
        }
    }
    public void Insert(TEACHER teacher) throws SQLException{
        String sql = "insert into `TEACHER`(`TName`,`CourseName`,`BName`,`flag`)"+"VALUES (?,?,?,?)";
        TEACHER teacher1 = FindTeacher(teacher.getTName());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(teacher1==null){
            ps.setString(1,teacher.getTName());
            ps.setString(2,teacher.getCourseName());
            ps.setString(3,teacher.getBName());
            ps.setInt(4,teacher.getFlag());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }else{

        }
    }
    public  void update(TEACHER teacher) throws SQLException{
        String sql = "update `TEACHER` set TName=?,CourseName=?,BName=?,flag=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,teacher.getTName());
        ps.setString(2,teacher.getCourseName());
        ps.setString(3,teacher.getBName());
        ps.setInt(4,teacher.getFlag());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(TEACHER teacher) throws SQLException,InterruptedException{
        String sql = "delete from `TEACHER` where TName=?";
        Connection conn=DBUtil.getConn();
        TEACHER teacher1 = FindTeacher(teacher.getTName());
        if(teacher1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacher.getTName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该数据不存在");
        }
    }
}
