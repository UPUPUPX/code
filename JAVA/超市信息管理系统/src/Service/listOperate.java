package Service;
import DAO.RUNNING;
import DAO.shopList;
import com.sun.org.apache.xpath.internal.objects.XString;
import com.sun.org.apache.xpath.internal.objects.XStringForChars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
    public static String getdate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t= formatter.format(calendar.getTime());
        return t;
    }
    public static shopList findlist(int id) throws SQLException {
        String sql = "select * from GOODS where ID=?";
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
        conn.close();
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
        String sql="insert into `list`(`ID`,`NAME`,`COUNT`,`PRICE`,`TIME`,`RUNNIMG`) "+"VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,shopList.getId());
            ps.setString(2,shopList.getName());
            ps.setDouble(3,shopList.getCount());
            ps.setDouble(4,shopList.getPrice());
            ps.setString(5,gettime());
            ps.setString(6,getdate());
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
    public static void Print() throws SQLException {
        Connection conn = DBUtil.getConn();
        String sql = "SELECT ID,NAME,COUNT,PRICE,TIME FROM list";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while(rs.next()){
            int id  = rs.getInt("ID");
            String name = rs.getString("NAME");
            int count = rs.getInt("COUNT");
            double price=rs.getDouble("PRICE");
            String time=rs.getString("TIME");
            String fn = "../销售清单.txt";
            wf(fn, "商品编号: " + id);
            wf(fn, "商品名称: " + name);
            wf(fn, "商品价格: " + price);
            wf(fn, "商品数量: " + count);
        }
        rs.close();
        ps.close();
        conn.close();
    }
    public static void wf(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



