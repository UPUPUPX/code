package Service;

import DAO.CLASS;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassService {
    public CLASS FindClass(String str) throws SQLException {
        String sql = "select * from CLASS where ClassName=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            CLASS aClass = new CLASS();
            aClass.setID(rs.getInt("ID"));
            aClass.setXName(rs.getString("XName"));
            aClass.setClassName(rs.getString("ClassName"));
            aClass.setNum(rs.getInt("num"));
            aClass.setBnum(rs.getInt("bnum"));
            conn.close();
            return aClass;
        }else{
            conn.close();
            return null;
        }
    }
    public void Insert(CLASS aClass) throws SQLException{
        String sql = "insert into `CLASS`(`XName`,`ClassName`,`num`,`bnum`)"+"VALUES (?,?,?,?)";
        CLASS aClass1 = FindClass(aClass.getClassName());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(aClass1==null){
            ps.setString(1,aClass.getXName());
            ps.setString(2,aClass.getClassName());
            ps.setInt(3,aClass.getNum());
            ps.setInt(4,aClass.getBnum());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }else{

        }
    }
    public  void update(CLASS aClass) throws SQLException{
        String sql = "update `CLASS` set XName=?,ClassName=?,num=?,bnum=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,aClass.getXName());
        ps.setString(2,aClass.getClassName());
        ps.setInt(3,aClass.getNum());
        ps.setInt(4,aClass.getBnum());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(CLASS aClass) throws SQLException,InterruptedException{
        String sql = "delete from `CLASS` where ClassName=?";
        Connection conn=DBUtil.getConn();
        CLASS aClass1 = FindClass(aClass.getClassName());
        if(aClass1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,aClass.getClassName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该班级不存在");
        }
    }
}
