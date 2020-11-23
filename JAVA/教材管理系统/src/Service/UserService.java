package Service;

import DAO.USER;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public  USER FindUser(String str) throws SQLException{
        String sql = "select * from USER where USERNAME=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            USER user = new USER();
            user.setID(rs.getInt("ID"));
            user.setSHENFEN(rs.getString("SHENFEN"));
            user.setUSERNAME(rs.getString("USERNAME"));
            user.setUSERPASS(rs.getString("USERPASS"));
            user.setSTATE(rs.getInt("STATE"));
            conn.close();
            return user;
        }else{
            conn.close();
            return null;
        }
    }

    public static USER FindUser(int id) throws SQLException{
        String sql = "select * from USER where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            USER user = new USER();
            user.setID(rs.getInt("ID"));
            user.setSHENFEN(rs.getString("SHENFEN"));
            user.setUSERNAME(rs.getString("USERNAME"));
            user.setUSERPASS(rs.getString("USERPASS"));
            user.setSTATE(rs.getInt("STATE"));
            conn.close();
            return user;
        }else{
            conn.close();
            return null;
        }
    }

    public void Insert(USER user) throws SQLException{
        String sql = "insert into `USER`(`USERNAME`,`USERPASS`,`STATE`,`SHENFEN`)"+"VALUES (?,?,?,?)";
        USER user01 = FindUser(user.getUSERNAME());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(user01==null){
            ps.setString(1,user.getUSERNAME());
            ps.setString(2,user.getUSERPASS());
            ps.setInt(3,user.getSTATE());
            ps.setString(4,user.getSHENFEN());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"注册成功");
        }else{

        }
    }
    public  void update(USER user) throws SQLException{
        String sql = "update `USER` set USERNAME=?,USERPASS=?,STATE=?,SHENFEN=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getUSERNAME());
        ps.setString(2,user.getUSERPASS());
        ps.setInt(3,user.getSTATE());
        ps.setString(4,user.getSHENFEN());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(USER user) throws SQLException,InterruptedException{
        String sql = "delete from `USER` where USERNAME=?";
        Connection conn=DBUtil.getConn();
        USER user01 = FindUser(user.getUSERNAME());
        if(user01 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUSERNAME());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该用户不存在");
        }
    }
}
