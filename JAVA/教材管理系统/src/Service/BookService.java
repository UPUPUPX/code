package Service;

import DAO.BOOK;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {
    public static BOOK FindBook(String str) throws SQLException {
        String sql = "select * from BOOK where name=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            BOOK book = new BOOK();
            book.setName(rs.getString("name"));
            book.setPress(rs.getString("press"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getInt("price"));
            book.setSupplier(rs.getString("supplier"));
            book.setBnum(rs.getInt("bnum"));
            return book;
        }else{
            return null;
        }
    }

    public static BOOK FindBook(int id) throws SQLException {
        String sql = "select * from BOOK where ID=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            BOOK book = new BOOK();
            book.setName(rs.getString("name"));
            book.setPress(rs.getString("press"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getInt("price"));
            book.setSupplier(rs.getString("supplier"));
            book.setBnum(rs.getInt("bnum"));
            return book;
        }else{
            return null;
        }
    }

    public void Insert(BOOK book) throws SQLException{
        String sql = "insert into 'BOOK'('name','press','author','price','supplier','bnum')"+"VALUES(?,?,?,?,?,?)";
        Connection conn = DBUtil.getConn();
        BOOK book1 = FindBook(book.getName());
        if(book1==null){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setString(2,book.getPress());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getPrice());
            ps.setString(5,book.getSupplier());
            ps.setInt(6,book.getBnum());
            ps.executeLargeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"添加成功");
        }
    }
    public  void update(BOOK book) throws SQLException{
        String sql = "update `BOOK` set name=?,press=?,author=?,price=?,supplier=?,bnum=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,book.getName());
        ps.setString(2,book.getPress());
        ps.setString(3,book.getAuthor());
        ps.setInt(4,book.getPrice());
        ps.setString(5,book.getSupplier());
        ps.setInt(6,book.getBnum());
        ps.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null,"修改成功");

    }
    public  void delete(BOOK book) throws SQLException,InterruptedException{
        String sql = "delete from `BOOK` where name=?";
        Connection conn=DBUtil.getConn();
        BOOK book1 = FindBook(book.getName());
        if(book1 == null){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"删除成功");
        }
        else{
            JOptionPane.showMessageDialog(null,"该教材不存在");
        }
    }

    public int getCount() {
        int count = -1;
        String sql = "select count(*) from `BOOK`";
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
