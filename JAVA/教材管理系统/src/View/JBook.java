package View;

import DAO.*;
import Service.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.SQLException;

public class JBook extends JFrame implements ActionListener {

    JButton BookBuy;
    JButton Store;
    JButton Deliver;
    JButton Charge;
    JButton Supplier;
    JButton jButton;
    JButton Out;
    JLabel n1;
    JLabel n2;
    JLabel n3;
    JLabel n4;
    DefaultTableModel tableModel;
    int rows;
    STORE store = new STORE();
    CLASS aClass = new CLASS();
    BOOK book = new BOOK();
    CHARGE charge = new CHARGE();
    ChargeService chargeService = new ChargeService();
    BookService bookService = new BookService();
    StoreService storeService = new StoreService();


    public JBook(){
        super();

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

        BookBuy = new JButton("教材订购管理");
        BookBuy.setText("教材订购管理");
        BookBuy.setBounds(10,48,190,46);
        BookBuy.setFont(new Font("", Font.BOLD,24));
        BookBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("教材单价");
                n3.setText("订购数量");
                n4.setText("总计");
                tableModel.setRowCount(0);
                int counts= bookService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            book = BookService.FindBook(i);
                            if (book != null) {
                                String[] rowValue = {book.getName(), String.valueOf(book.getPrice()), String.valueOf(book.getBnum()), String.valueOf(book.getPrice()*book.getBnum())};
                                //tableModel.removeRow(0);
                                tableModel.addRow(rowValue);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        getContentPane().add(BookBuy);

        Store = new JButton("库存管理");
        Store.setText("库存管理");
        Store.setBounds(10,106,190,46);
        Store.setFont(new Font("", Font.BOLD,24));
        Store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("总数");
                n3.setText(" ");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= storeService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            store = StoreService.FindStore(i);
                            if (store!=null){
                                String[] rowValue = {store.getName(), String.valueOf(store.getTotal())};
                                //tableModel.removeRow(0);
                                tableModel.addRow(rowValue);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        getContentPane().add(Store);

        Deliver = new JButton("出库管理");
        Deliver.setText("出库管理");
        Deliver.setBounds(10,164,190,46);
        Deliver.setFont(new Font("", Font.BOLD,24));
        Deliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("可否领取");
                n3.setText(" ");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= storeService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            store = StoreService.FindStore(i);
                            if (store!=null){
                                String[] rowValue = {store.getName(), String.valueOf(store.getFlag())};
                                //tableModel.removeRow(0);
                                tableModel.addRow(rowValue);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        getContentPane().add(Deliver);

        Charge = new JButton("收费管理");
        Charge.setText("收费管理");
        Charge.setBounds(10,222,190,46);
        Charge.setFont(new Font("", Font.BOLD,24));
        Charge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("班级名称");
                n3.setText("订购人数");
                n4.setText("是否已支付");
                tableModel.setRowCount(0);
                int counts= chargeService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            charge = ChargeService.FindCharge(i);
                            if (charge != null) {
                                aClass = ClassService.FindClass(charge.getCName());
                            }
                            if (charge!=null){
                                String[] rowValue = {charge.getBName(), charge.getCName(), String.valueOf(aClass.getBnum()), String.valueOf(charge.getFlag())};
                                //tableModel.removeRow(0);
                                tableModel.addRow(rowValue);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        getContentPane().add(Charge);

        Supplier = new JButton("供应商管理");
        Supplier.setText("供应商管理");
        Supplier.setBounds(10,280,190,46);
        Supplier.setFont(new Font("", Font.BOLD,24));
        Supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("供应商名称");
                n3.setText(" ");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= bookService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            book = BookService.FindBook(i);
                            if (book!=null){
                                String[] rowValue = {book.getName(), book.getSupplier()};
                                //tableModel.removeRow(0);
                                tableModel.addRow(rowValue);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        getContentPane().add(Supplier);

        Out = new JButton("退出登录");
        Out.setText("退出登录");
        Out.setBounds(10,600,190,46);
        Out.setFont(new Font("", Font.BOLD,24));
        Out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });
        getContentPane().add(Out);

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
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(40);
        table.setFont(new Font("宋体", Font.BOLD, 20));
        scrollPane.setViewportView(table);
        table.setBounds(228, 100, 1024, 750);
        getContentPane().add(table);

        n1 = new JLabel();
        n1.setFont(new Font("宋体", Font.BOLD, 20));
        n1.setBounds(228, 48, 202, 50);
        getContentPane().add(n1);
        n2 = new JLabel();
        n2.setFont(new Font("宋体", Font.BOLD, 20));
        n2.setBounds(482, 48, 202, 50);
        getContentPane().add(n2);
        n3 = new JLabel();
        n3.setFont(new Font("宋体", Font.BOLD, 20));
        n3.setBounds(738, 48, 202, 50);
        getContentPane().add(n3);
        n4 = new JLabel();
        n4.setFont(new Font("宋体", Font.BOLD, 20));
        n4.setBounds(996, 48, 202, 50);
        getContentPane().add(n4);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
