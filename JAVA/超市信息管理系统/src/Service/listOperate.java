package Service;

import DAO.Goods;
import DAO.shopList;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName listOperate
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/26 21:16
 */
public class listOperate {
    public  static String gettime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }
    public static shopList findlist(int id) throws SQLException {
        String sql = "select * from GOODS where RUNNING=?";
        shopList shopList=new shopList();
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            shopList.setId(rs.getInt("ID"));
            shopList.setName(rs.getString("NAME"));
            shopList.setPrice(rs.getInt("OUTPRICE"));
            shopList.setTime(gettime());
        }
        return shopList;
    }
    public static shopList addlistcount(shopList shopList){
        shopList.setCount(+1);
        String sql="update list SET ACCOUNT=? where ID=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,shopList.getCount());
            ps.setInt(2,shopList.getId());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopList;
    }
    public static shopList dellistcount(shopList shopList){
        shopList.setCount(-1);
        String sql="update list SET ACCOUNT=? where ID=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,shopList.getCount());
            ps.setInt(2,shopList.getId());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopList;
    }
    public static void addlistgoods(shopList shopList){
        String sql="insert into `list`(`ID`,`NAME`,`COUNT`,`PRICE`,`TIME`) "+"VALUES (?,?,?,?,?)";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,shopList.getId());
            ps.setString(2,shopList.getName());
            ps.setDouble(3,shopList.getCount());
            ps.setDouble(4,shopList.getPrice());
            ps.setString(5,gettime());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void delgoodslist(shopList shopList){
        String sql="delete from list where ID=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,shopList.getId());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
