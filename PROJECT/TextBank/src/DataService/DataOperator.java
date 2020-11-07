package DataService;

import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName DataOperator
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 14:22
 */
public class DataOperator {
    public Data Find(int id) throws SQLException {
        String sql = "select * from DataSource where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Data data=new Data();
            data.setId(rs.getInt("ID"));
            data.setText(rs.getString("CONTENT"));
            data.setSummary(rs.getString("SUMMARY"));
            return data;
        } else{
            return null;
        }
    }
    public void Insert(Data data) throws SQLException {
        String sql="insert into `DataSource`(`ID`, `CONTENT`,`SUMMARY`) "+"VALUES (?,?,?)";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,data.getId());
        ps.setString(2,data.getText());
        ps.setString(3,data.getSummary());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "添加成功");
    }
    public void Update(Data data) throws SQLException {
        String sql="update DataSource SET CONTENT=? where ID=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,data.getText());
        ps.setInt(2,data.getId());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "更新成功");
        System.out.println(data.getText());
    }
    public void delete(Data data) throws SQLException, InterruptedException {
        String sql="delete from `DataSource` where CONTENT=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        if (data != null) {
            ps.setString(1,data.getText());
            ps.executeUpdate();
            conn.close();
            Thread.sleep(10);
            String sqlw="delete from `DataSource` where ID=?";
            Connection connw=DBUtil.getConn();
            PreparedStatement psw=connw.prepareStatement(sqlw);
            psw.setInt(1,data.getId());
            psw.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "删除成功");
        }
    }
    public int getCount() {
        int count = -1;
        String sql = "select count(*) from DataSource";
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
