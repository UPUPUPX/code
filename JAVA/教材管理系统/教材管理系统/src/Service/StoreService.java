package Service;

import DAO.STORE;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreService {
    public static STORE FindStore(String str) throws SQLException {
        String sql = "select * from STORE where name=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            STORE store = new STORE();
            store.setID(rs.getInt("ID"));
            store.setName(rs.getString("name"));
            store.setFlag(rs.getInt("flag"));
            store.setTotal(rs.getInt("total"));
            conn.close();
            return store;
        }else{
            conn.close();
            return null;
        }
    }

    public static STORE FindStoreID(int id) throws SQLException {
        String sql = "select * from STORE where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            STORE store = new STORE();
            store.setID(rs.getInt("ID"));
            store.setName(rs.getString("name"));
            store.setFlag(rs.getInt("flag"));
            store.setTotal(rs.getInt("total"));
            conn.close();
            return store;
        }else{
            conn.close();
            return null;
        }
    }

    public void Insert(STORE store) throws SQLException{
        String sql = "insert into `STORE`(`name`,`flag`,`total`)"+"VALUES (?,?,?)";
        STORE store1 = FindStore(store.getName());
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(store1==null){
            ps.setString(1,store.getName());
            ps.setInt(2,store.getFlag());
            ps.setInt(3,store.getTotal());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功");
        }else{

        }
    }
    public  void update(STORE store) throws SQLException{
        String sql = "update `STORE` set name=?,flag=?,total=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,store.getName());
        ps.setInt(2,store.getFlag());
        ps.setInt(3,store.getTotal());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(STORE store) throws SQLException,InterruptedException{
        String sql = "delete from `STORE` where name=?";
        Connection conn=DBUtil.getConn();
        STORE store1 = FindStore(store.getName());
        if(store1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,store.getName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该数据1不存在");
        }
    }

    public int getCount() {
        int count = -1;
        String sql = "select count(*) from `STORE`";
        try {
            Connection conn=DBUtil.getConn();
            if (conn!=null) {
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                if(rs.next()) {
                    count=rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
