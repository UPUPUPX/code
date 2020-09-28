package Service;

import DAO.Goods;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName findGoods
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/21 22:45
 */
public class GoodsOperate {
    public Goods findGoods(int id){
        String sql = "select * from GOODS where ID=?";
        Goods goods=new Goods();
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                goods.setID(rs.getInt("ID"));
                goods.setName(rs.getString("NAME"));
                goods.setInprice(rs.getInt("INPRICE"));
                goods.setOutprice(rs.getInt("OUTPRICE"));
                goods.setAccount(rs.getInt("ACCOUNT"));
                if (goods.getAccount()<10){
                    JOptionPane.showMessageDialog(null, "库存不足,请通知相关人员补货,还剩"+goods.getAccount()+"个");
                }
            } else{
                return goods=null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }
    public Goods addacount(Goods goods){
        goods.setAccount(-1);
        String sql="update GOODS SET ACCOUNT=? where ID=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getAccount()+1);
            ps.setInt(2,goods.getID());
            ps.executeUpdate();
            conn.close();
            if (goods.getAccount()<=0){
                JOptionPane.showMessageDialog(null, "库房已无货");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }
    public Goods delaccount(Goods goods){
        goods.setAccount(+1);
        String sql="update GOODS SET ACCOUNT=? where ID=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getAccount());
            ps.setInt(2,goods.getID());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }
    public Goods delgoods(Goods goods){
        goods=delaccount(goods);
        return goods;
    }
    public void addgoods(Goods goods){
        String sql="insert into `GOODS`(`ID`, `NAME`,`INPRICE`,`OUTPRICE`,`ACCOUNT`) "+"VALUES (?,?,?,?,?)";
        try { Connection conn = DBUtil.getConn();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,goods.getID());
        ps.setString(2,goods.getName());
        ps.setDouble(3,goods.getInprice());
        ps.setDouble(4,goods.getOutprice());
        ps.setInt(5,goods.getAccount());
        ps.executeUpdate();
        conn.close();
        } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
        JOptionPane.showMessageDialog(null, "添加成功");
    }
    public Goods update(Goods goods){
        String sql="update GOODS SET ACCOUNT=? where ID!=?";
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getAccount());
            ps.setInt(2,goods.getID());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }
}

