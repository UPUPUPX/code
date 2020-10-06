package Service;

import DAO.User;

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
    public User FindUser(String str) throws SQLException {
        String sql = "select * from user where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, str);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setName(rs.getString("ID"));
            user.setPass(rs.getString("PASSWD"));
            user.setQuestion(rs.getString("QUESTION"));
            user.setAnswer(rs.getString("ANSWER"));
            user.setState(rs.getInt("STATE"));
            return user;
        } else {
            return null;
        }
    }
    public void Insert(User user) throws SQLException {
        String sql="insert into `user`(`ID`, `PASSWD`, `QUESTION`, `ANSWER`,`STATE`,`DEPARTMENT`) "+"VALUES (?,?,?,?,?,?)";
        Connection conn=DBUtil.getConn();
        User user1=FindUser(user.getName());
        if (user1==null) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getQuestion());
            ps.setString(4, user.getAnswer());
            ps.setInt(5, user.getState());
            ps.setString(6, user.getDepartement());
            ps.executeUpdate();
            conn.close();
            if (user.getState() == 0) {
                JOptionPane.showMessageDialog(null, "员工注册成功");
            } else {
                JOptionPane.showMessageDialog(null, "主管注册成功");
            }
        } else{
            JOptionPane.showMessageDialog(null, "用户已注册");
        }
    }
    public void Update(User user) throws SQLException {
        String sql="update `user` set PASSWD=?,DEPARTMENT=?,QUESTION=?,ANSWER=? where ID=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getPass());
        ps.setString(2,user.getDepartement());
        ps.setString(3,user.getQuestion());
        ps.setString(4,user.getAnswer());
        ps.setString(5,user.getName());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "修改成功");
    }
    public void delete(User user) throws SQLException, InterruptedException {
        String sql="delete from `user` where ID=?";
        Connection conn=DBUtil.getConn();
        User user1=FindUser(user.getName());
        if (user1 == null) {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null, "该用户不存在");
        }
    }
}
