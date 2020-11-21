package VIEW;
import DAO.Goods;
import DAO.shopList;
import Service.GoodsOperate;
import Service.listOperate;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * @ClassName userOperateView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/17 19:46
 */
public class userOperateView extends JFrame implements ActionListener,TableModelListener {
    JLabel goodsId;
    JLabel count;
    JLabel pay;
    JLabel total;
    JLabel n1;
    JLabel n2;
    JLabel n3;
    JLabel n4;
    JTextField id;
    JTextField counts;
    JTextField jTextFieldpay;
    JLabel jTextFieldtotal;
    JButton print;
    JButton add;
    JButton delgoods;
    JButton addgoods;
    JTable table;
    Thread thread;
    public double a;
    DefaultTableModel tableModel;
    Goods goods=new Goods();
    shopList shopList=new shopList();
    GoodsOperate goodsOperate=new GoodsOperate();
    public int rows;
    private double s;
    public double getS() {
        return s;
    }
    public void setS(double s) {
        this.s = s;
    }
    private final LinkedList<shopList> p=new LinkedList<shopList>();
    public Color heavywrite = new Color(233, 243, 243);
    public Color bluegreen = new Color(0, 127, 127);
    final JScrollPane scrollPane = new JScrollPane();
    public userOperateView() {
        setSize(1920, 1030);
        getContentPane().setLayout(null);
        goodsId = new JLabel("商品编号");
        goodsId.setFont(new Font("宋体", Font.BOLD, 36));
        goodsId.setBounds(40, 100, 180, 50);
        getContentPane().add(goodsId);
        id = new JTextField();
        id.setBackground(heavywrite);
        id.setFont(new Font("宋体", Font.BOLD, 30));
        id.setBounds(260, 100, 300, 50);
        getContentPane().add(id);
        count = new JLabel("商品件数");
        count.setFont(new Font("宋体", Font.BOLD, 36));
        count.setBounds(40, 300, 180, 50);
        getContentPane().add(count);
        counts = new JTextField("1");
        counts.setFont(new Font("宋体", Font.BOLD, 36));
        counts.setBackground(heavywrite);
        counts.setBounds(260, 300, 300, 50);
        getContentPane().add(counts);
        total = new JLabel("总计");
        total.setFont(new Font("宋体", Font.BOLD, 36));
        total.setBounds(40, 400, 180, 50);
        getContentPane().add(total);
        jTextFieldtotal = new JLabel(String.valueOf(getS()));
        jTextFieldtotal.setFont(new Font("宋体", Font.BOLD, 36));
        jTextFieldtotal.setBounds(260, 400, 300, 50);
        jTextFieldtotal.setBackground(heavywrite);
        getContentPane().add(jTextFieldtotal);
        pay = new JLabel("付款");
        pay.setFont(new Font("宋体", Font.BOLD, 36));
        pay.setBounds(40, 500, 180, 50);
        getContentPane().add(pay);
        jTextFieldpay = new JTextField();
        jTextFieldpay.setFont(new Font("宋体", Font.BOLD, 36));
        jTextFieldpay.setBounds(260, 500, 300, 50);
        jTextFieldpay.setBackground(heavywrite);
        getContentPane().add(jTextFieldpay);
        print = new JButton("结算");
        print.setFont(new Font("宋体", Font.BOLD, 36));
        print.setBounds(40, 600, 200, 50);
        print.setBackground(bluegreen);
        getContentPane().add(print);
        addgoods = new JButton("商品入库");
        addgoods.setFont(new Font("宋体", Font.BOLD, 36));
        addgoods.setBounds(360, 600, 200, 50);
        addgoods.setBackground(bluegreen);
        getContentPane().add(addgoods);
        add = new JButton("添加");
        add.setBackground(bluegreen);
        add.setFont(new Font("宋体", Font.BOLD, 20));
        add.setBounds(400, 200, 160, 50);
        getContentPane().add(add);
        tableModel = new DefaultTableModel(rows = 0, 4);
        tableModel.addTableModelListener(e -> {
            int type = e.getType();
            int row = e.getFirstRow();
            if (type == TableModelEvent.INSERT) { rows=row;}
            else if (type == TableModelEvent.UPDATE){ rows=row;}
            else if (type == TableModelEvent.DELETE) { rows=row;}
            rows=row;
        });
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(40);
        table.setFont(new Font("宋体", Font.BOLD, 20));
        scrollPane.setViewportView(table);
        table.setBounds(900, 150, 600, 500);
        getContentPane().add(table);
        n1 = new JLabel("商品编号");
        n1.setFont(new Font("宋体", Font.BOLD, 20));
        n1.setBounds(925, 100, 150, 50);
        getContentPane().add(n1);
        n2 = new JLabel("商品名称");
        n2.setFont(new Font("宋体", Font.BOLD, 20));
        n2.setBounds(1075, 100, 150, 50);
        getContentPane().add(n2);
        n3 = new JLabel("商品数量");
        n3.setFont(new Font("宋体", Font.BOLD, 20));
        n3.setBounds(1230, 100, 150, 50);
        getContentPane().add(n3);
        n4 = new JLabel("商品单价");
        n4.setFont(new Font("宋体", Font.BOLD, 20));
        n4.setBounds(1375, 100, 150, 50);
        getContentPane().add(n4);
        delgoods = new JButton("移除");
        delgoods.setBackground(bluegreen);
        delgoods.setBounds(260, 200, 120, 50);
        delgoods.setFont(new Font("宋体", Font.BOLD, 20));
        getContentPane().add(delgoods);
        addgoods.addActionListener(this);
        print.addActionListener(this);
        add.addActionListener(this);
        delgoods.addActionListener(this);
        setVisible(true);
        goods.setID(Integer.parseInt(id.getText()));
        goods.setAccount(Integer.parseInt(counts.getText()));
        shopList.setId(Integer.parseInt(id.getText()));
    }
    public void actionPerformed(ActionEvent e) {
        try {
            shopList= Service.listOperate.findlist(Integer.parseInt(id.getText()));
            shopList.setCount(Integer.parseInt(counts.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (e.getSource() == delgoods) {
            tableModel.removeRow(rows);
            goodsOperate.delgoods(goods);
            Service.listOperate.delgoodslist(shopList);
            p.remove(shopList);
            double mon=Double.parseDouble(jTextFieldtotal.getText())-Double.parseDouble(String.valueOf(shopList.getCount()*shopList.getPrice()));
            jTextFieldtotal.setText(String.valueOf(mon));
            setS(mon);
        }
        else if (e.getSource()==add){
            String[] rowValues = {String.valueOf(shopList.getId()),String.valueOf(shopList.getName()),counts.getText(),String.valueOf(shopList.getPrice())};
            tableModel.addRow(rowValues);
            Calendar calendar = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            shopList.setRunning(String.valueOf(timeInMillis));
            Service.listOperate.addlistgoods(shopList);
            p.add(shopList);
            double mon=Double.parseDouble(jTextFieldtotal.getText())+Double.parseDouble(String.valueOf(shopList.getCount()*shopList.getPrice()));
            jTextFieldtotal.setText(String.valueOf(mon));
            setS(mon);
        }
        else if (e.getSource()==addgoods){
            new addGoods();
        }
        else if (e.getSource()==print){
            assert jTextFieldpay != null;
            if (Double.parseDouble(jTextFieldpay.getText())<getS()){
                JOptionPane.showMessageDialog(null, "金额不足");
            }
            else{
                new ReceivePayView(Double.parseDouble(jTextFieldpay.getText()),getS(),p);
                p.clear();
            }
            tableModel.setRowCount(0);
        }
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        int type = e.getType();
        int row = e.getFirstRow();
        if (type == TableModelEvent.INSERT) { rows=row;}
        else if (type == TableModelEvent.UPDATE){ rows=row;}
        else if (type == TableModelEvent.DELETE) { rows=row;}
        else { rows=row;}
    }
    public static void main(String[] args) {
        new userOperateView();
    }
}