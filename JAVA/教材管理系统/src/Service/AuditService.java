package Service;

import DAO.AUDIT;
import DAO.USER;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditService {
    public AUDIT FindAudit(String str) throws SQLException {
        String sql = "select * from AUDIT where BName=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            AUDIT audit = new AUDIT();
            audit.setID(rs.getInt("ID"));
            audit.setBName(rs.getString("BName"));
            audit.setCoName(rs.getString("CoName"));
            audit.setTName(rs.getString("TName"));
            audit.setFlag(rs.getInt("flag"));
            conn.close();
            return audit;
        }else{
            conn.close();
            return null;
        }
    }

    public static AUDIT FindAudit(int id) throws SQLException {
        String sql = "select * from AUDIT where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            AUDIT audit = new AUDIT();
            audit.setID(rs.getInt("ID"));
            audit.setBName(rs.getString("BName"));
            audit.setCoName(rs.getString("CoName"));
            audit.setTName(rs.getString("TName"));
            audit.setFlag(rs.getInt("flag"));
            conn.close();
            return audit;
        }else{
            conn.close();
            return null;
        }
    }

    public void Insert(AUDIT audit) throws SQLException{
        String sql = "insert into `AUDIT`(`BName`,`CoName`,`TName`,`flag`)"+"VALUES (?,?,?,?)";
        AUDIT audit1 = FindAudit(audit.getBName());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(audit1==null){
            ps.setString(1,audit.getBName());
            ps.setString(2,audit.getCoName());
            ps.setString(3,audit.getTName());
            ps.setInt(4,audit.getFlag());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }
    }
    public  void update(AUDIT audit) throws SQLException{
        String sql = "update `AUDIT` set BName=?,CoName=?,TName=?,flag=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,audit.getBName());
        ps.setString(2,audit.getCoName());
        ps.setString(3,audit.getTName());
        ps.setInt(4,audit.getFlag());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(AUDIT audit) throws SQLException,InterruptedException{
        String sql = "delete from `USER` where USERNAME=?";
        Connection conn=DBUtil.getConn();
        AUDIT audit1 = FindAudit(audit.getBName());
        if(audit1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,audit.getBName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该用户不存在");
        }
    }

    public int getCount() {
        int count = -1;
        String sql = "select count(*) from `AUDIT`";
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
