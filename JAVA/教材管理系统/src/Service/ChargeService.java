package Service;

import DAO.CHARGE;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChargeService {
    public CHARGE FindCharge(String str) throws SQLException {
        String sql = "select * from CHARGE where BName=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            CHARGE charge = new CHARGE();
            charge.setID(rs.getInt("ID"));
            charge.setBName(rs.getString("BName"));
            charge.setCName(rs.getString("CName"));
            charge.setFlag(rs.getInt("flag"));
            conn.close();
            return charge;
        }else{
            conn.close();
            return null;
        }
    }
    public void Insert(CHARGE charge) throws SQLException{
        String sql = "insert into `CHARGE`(`BName`,`CName`,`flag`)"+"VALUES (?,?,?)";
        CHARGE charge1 = FindCharge(charge.getBName());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(charge1==null){
            ps.setString(1,charge.getBName());
            ps.setString(2,charge.getCName());
            ps.setInt(3,charge.getFlag());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }else{

        }
    }
    public  void update(CHARGE charge) throws SQLException{
        String sql = "update `CHARGE` set BName=?,CName=?,flag=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,charge.getBName());
        ps.setString(2,charge.getCName());
        ps.setInt(3,charge.getFlag());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(CHARGE charge) throws SQLException,InterruptedException{
        String sql = "delete from `CHARGE` where BName=?";
        Connection conn=DBUtil.getConn();
        CHARGE charge1 = FindCharge(charge.getBName());
        if(charge1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,charge.getBName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该数据不存在");
        }
    }
}
