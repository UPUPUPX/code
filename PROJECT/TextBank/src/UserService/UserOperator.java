package UserService;

import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName UserOperator
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 14:07
 */
public class UserOperator {
    public  User FindUser(String str) throws SQLException {
        String sql = "select * from userdata where ACCOUNT=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, str);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getString("ACCOUNT"));
            user.setPasswd(rs.getString("PASSWD"));
            user.setQuestion(rs.getString("QUESTION"));
            user.setAnswer(rs.getString("ANSWER"));
            return user;
        } else {
            return null;
        }
    }
    public void Insert(User user) throws SQLException {
        String sql="insert into `userdata`(`ACCOUNT`, `PASSWD`, `QUESTION`, `ANSWER`) "+"VALUES (?,?,?,?)";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getId());
        ps.setString(2,user.getPasswd());
        ps.setString(3,user.getQuestion());
        ps.setString(4,user.getAnswer());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "注册成功");
    }
    public void update(User user) throws SQLException {
        String sql="update `userdata` set PASSWD=? where ACCOUNT=?";
        /*String sql="update `userdata` set PASSWD=? where ACCOUNT=?"+"VALUES(?,?)";*/
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getPasswd());
        ps.setString(2,user.getId());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "修改成功");
    }
}
