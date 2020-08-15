package DataService;

import Model.DBUtil;

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
    public String Find(int id) throws SQLException {
        String sql = "select * from DataSource where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Data data=new Data();
            data.setId(rs.getInt("ID"));
            data.setText(rs.getString("CONTENT"));
            return data.getText();
        } else{
            return null;
        }
    }
    public void Insert(Data data) throws SQLException {
        String sql="insert into `DataSource`(`ID`, `CONTENT`) "+"VALUES (?,?)";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,data.getId());
        ps.setString(2,data.getText());
        ps.executeUpdate();
        conn.close();
    }
    public void Update(Data data) throws SQLException {
        String sql="update DataSource SET CONTENT=? where ID=?"+"VALUES (?,?)";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,data.getText());
        ps.setInt(2,data.getId());
        ps.executeUpdate();
        conn.close();
    }
    public void delete(Data data) throws SQLException, InterruptedException {
        String sql="delete from `DataSource` where CONTENT=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,data.getText());
        ps.executeUpdate();
        conn.close();
        Thread.currentThread().sleep(10);
        String sqlw="delete from `user` where ID=?";
        Connection connw=DBUtil.getConn();
        PreparedStatement psw=connw.prepareStatement(sqlw);
        psw.setInt(1,data.getId());
        psw.executeUpdate();
        conn.close();
    }
}
