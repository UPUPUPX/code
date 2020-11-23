package View;

import DAO.BOOK;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JBook extends JFrame implements ActionListener {

    JButton BookBuy;
    JButton Store;
    JButton Deliver;
    JButton Charge;
    JButton Supplier;
    JButton Jbook;
    JButton jButton;
    BOOK book;
    JTable table;
    DefaultTableModel tableModel;
    JTextField textField;
    int rows;

    public JBook(){
        super();
        BookBuy = new JButton("教材订购管理");
        BookBuy.setText("教材订购管理");
        BookBuy.setBounds(10,48,190,46);
        BookBuy.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(BookBuy);

        Store = new JButton("库存管理");
        Store.setText("库存管理");
        Store.setBounds(10,106,190,46);
        Store.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Store);

        Deliver = new JButton("出库管理");
        Deliver.setText("出库管理");
        Deliver.setBounds(10,164,190,46);
        Deliver.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Deliver);

        Charge = new JButton("收费管理");
        Charge.setText("收费管理");
        Charge.setBounds(10,222,190,46);
        Charge.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Charge);

        Supplier = new JButton("供应商管理");
        Supplier.setText("供应商管理");
        Supplier.setBounds(10,280,190,46);
        Supplier.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Supplier);

        Jbook = new JButton("教材科信息");
        Jbook.setText("教材科信息");
        Jbook.setBounds(10,338,190,46);
        Jbook.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Jbook);

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为教材科");
        jButton.setBounds(340,0,600,36);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.setContentAreaFilled(false);
        getContentPane().add(jButton);
        setTitle("教材管理系统");
        setSize(1280,900);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(rows = 0, 4);
        tableModel.addTableModelListener(e -> {
            int type = e.getType();
            int row = e.getFirstRow();
            if (type == TableModelEvent.INSERT) { rows=row;}
            else if (type == TableModelEvent.UPDATE){ rows=row;}
            else if (type == TableModelEvent.DELETE) { rows=row;}
            rows=row;
        });

        final JScrollPane scrollPane = new JScrollPane();
        JLabel n1;
        JLabel n2;
        JLabel n3;
        JLabel n4;
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(40);
        table.setFont(new Font("宋体", Font.BOLD, 20));
        scrollPane.setViewportView(table);
        table.setBounds(228, 100, 1024, 750);
        getContentPane().add(table);
        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 190, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("教材单价");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(400, 48, 190, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("订购数量");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(590, 48, 190, 50);
        //getContentPane().add(n3);
        //n4 = new JLabel("总计");
        //n4.setFont(new Font("宋体", Font.BOLD, 20));
        //n4.setBounds(780, 48, 190, 50);
        //getContentPane().add(n4);

        //n1 = new JLabel("教材编号");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("教材名称");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("总数");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("可否领取");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("班级名称");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("是否已付");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("供应商名称");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
