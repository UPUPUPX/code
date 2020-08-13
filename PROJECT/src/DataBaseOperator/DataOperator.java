package DataBaseOperator;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName InsertDatabase
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/13 16:02
 */
public class DataOperator {
    public void Insert(String str) throws SQLException {
        String sql="insert into `DataSource`(`CONTENT`) "+"VALUES (?)";
        Connection conn=DBUtil.getConn();
        Database database=new Database();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,database.getString());
        ps.executeUpdate();
        conn.close();
    }

    public void Delete(String str) throws SQLException {
        String sql="";
        Connection conn=DBUtil.getConn();
        Database database=new Database();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,database.getString());
        ps.executeUpdate();
        conn.close();
    }
    /*public String search() throws SQLException {
        String sql = "select * from datasource where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,phone);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

        } else{
            return null;
        }
    }*/
}
