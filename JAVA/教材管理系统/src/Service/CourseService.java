package Service;

import DAO.COURSE;
import DAO.USER;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseService {
    public static COURSE FindCourse(String str) throws SQLException {
        String sql = "select * from COURSE where CNAME=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            COURSE course = new COURSE();
            course.setID(rs.getInt("ID"));
            course.setNAME(rs.getString("NAME"));
            course.setBName(rs.getString("BName"));
            course.setTName(rs.getString("TName"));
            course.setCName(rs.getString("CName"));
            conn.close();
            return course;
        }else{
            conn.close();
            return null;
        }
    }

    public static COURSE FindCourse(int id) throws SQLException {
        String sql = "select * from COURSE where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            COURSE course = new COURSE();
            course.setID(rs.getInt("ID"));
            course.setNAME(rs.getString("NAME"));
            course.setBName(rs.getString("BName"));
            course.setTName(rs.getString("TName"));
            course.setCName(rs.getString("CName"));
            conn.close();
            return course;
        }else{
            conn.close();
            return null;
        }
    }

    public static COURSE FindCourse(String str,int id) throws SQLException {
        String sql = "select * from COURSE where CNAME=? and ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ps.setInt(2,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            COURSE course = new COURSE();
            course.setID(rs.getInt("ID"));
            course.setNAME(rs.getString("NAME"));
            course.setBName(rs.getString("BName"));
            course.setTName(rs.getString("TName"));
            course.setCName(rs.getString("CName"));
            conn.close();
            return course;
        }else{
            conn.close();
            return null;
        }
    }

    public void Insert(COURSE course) throws SQLException{
        String sql = "insert into `COURSE`(`NAME`,`BName`,`CName`,`TName`)"+"VALUES (?,?,?,?)";
        COURSE course1 = FindCourse(course.getNAME());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(course1==null){
            ps.setString(1,course.getNAME());
            ps.setString(2,course.getBName());
            ps.setString(3,course.getCName());
            ps.setString(4,course.getTName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }else{

        }
    }
    public  void update(COURSE course) throws SQLException{
        String sql = "update `COURSE` set NAME=?,BName=?,CName=?,TName=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,course.getNAME());
        ps.setString(2,course.getBName());
        ps.setString(3,course.getCName());
        ps.setString(4,course.getTName());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(COURSE course) throws SQLException,InterruptedException{
        String sql = "delete from `COURSE` where NAME=?";
        Connection conn=DBUtil.getConn();
        COURSE course1 = FindCourse(course.getNAME());
        if(course1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,course.getNAME());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该用户不存在");
        }
    }

    public static int getCount() {
        int count = -1;
        String sql = "select count(*) from `COURSE`";
        try {
            Connection conn=DBUtil.getConn();
            if (conn!=null) {
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                if(rs.next()) {
                    count=rs.getInt(1);
                }
            }else{}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
