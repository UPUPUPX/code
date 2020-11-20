package Service;

import DAO.BOOK;
import Model.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {
    public BOOK FindBook(String str) throws SQLException {
        String sql = "select * from BOOK where name=?";
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,str);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            BOOK book = new BOOK();
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getInt("price"));
            book.setPress(rs.getString("press"));
            book.setSupplier(rs.getString("supplier"));
            book.setContract(rs.getString("contract"));
            book.setNum(rs.getInt("num"));
            return book;
        }else{
            return null;
        }
    }
    public void Insert(BOOK book) throws SQLException{
        String sql = "insert into 'BOOK'('name','press','author','price','supplier','num','contract','cID','tID')";
        Connection conn = DBUtil.getConn();
        BOOK book1 = FindBook(book.getName());
        if(book1==null){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setString(2,book.getPress());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getPrice());
            ps.setString(5,book.getSupplier());
            ps.setInt(6,book.getNum());
            ps.setString(7,book.getContract());
            ps.setInt(8,book.getaClass().getID());
            ps.setInt(9,book.getTeacher().getID());
            ps.executeLargeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,"注册成功");
        }
    }
    public  void update(BOOK book) throws SQLException{
        String sql = "update `BOOK` set name=?,press=?,author=?,price=?,supplier=?,num=?,contract=?,cID=?,tID=?";
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,book.getName());
        ps.setString(2,book.getPress());
        ps.setString(3,book.getAuthor());
        ps.setInt(4,book.getPrice());
        ps.setString(5,book.getSupplier());
        ps.setInt(6,book.getNum());
        ps.setString(7,book.getContract());
        ps.setInt(8,book.getaClass().getID());
        ps.setInt(9,book.getTeacher().getID());
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
}
