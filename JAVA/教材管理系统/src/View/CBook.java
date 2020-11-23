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
import java.sql.SQLException;

public class CBook extends JFrame implements ActionListener {
    JButton Course;
    JButton BookTake;
    JButton ClassAdmin;
    JButton jButton;
    JButton Out;
    JLabel n1;
    JLabel n2;
    JLabel n3;
    JLabel n4;
    DefaultTableModel tableModel;
    int rows;
    STORE store = new STORE();
    COURSE course = new COURSE();
    CLASS aClass = new CLASS();
    BOOK book = new BOOK();
    CHARGE charge = new CHARGE();
    StoreService storeService = new StoreService();

    public CBook(String name){
        super();

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为班级");
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

        Course = new JButton("查看课程安排");
        Course.setText("查看课程安排");
        Course.setBounds(10,48,190,46);
        Course.setFont(new Font("", Font.BOLD,24));
        Course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("课程名称");
                n2.setText("课程用书");
                n3.setText("教材单价");
                n4.setText("购买人数");
                tableModel.setRowCount(0);
                int counts = storeService.getCount();
                if (counts > 0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            course = CourseService.FindCourse(name,i);
                            if (course != null) {
                                book = BookService.FindBook(course.getBName());
                                aClass = ClassService.FindClass(course.getCName());
                            }
                            if (course != null) {
                                String[] rowValue = {course.getNAME(), book.getName(), String.valueOf(book.getPrice()), String.valueOf(aClass.getBnum())};
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
        getContentPane().add(Course);

        BookTake = new JButton("教材领取");
        BookTake.setText("教材领取");
        BookTake.setBounds(10,106,190,46);
        BookTake.setFont(new Font("", Font.BOLD,24));
        BookTake.addActionListener(new ActionListener() {
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
        getContentPane().add(BookTake);

        ClassAdmin = new JButton("班级信息管理");
        ClassAdmin.setText("班级信息管理");
        ClassAdmin.setBounds(10,164,190,46);
        ClassAdmin.setFont(new Font("", Font.BOLD,24));
        ClassAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教材名称");
                n2.setText("总价");
                n3.setText("是否已支付");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= storeService.getCount();
                if (counts>0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            charge = ChargeService.FindCharge(name,i);
                            if (charge != null) {
                                book = BookService.FindBook(charge.getBName());
                                aClass = ClassService.FindClass(charge.getCName());
                            }
                            if (charge != null) {
                                String[] rowValue = {charge.getBName(), String.valueOf(book.getPrice() * aClass.getBnum()), String.valueOf(charge.getFlag())};
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
        getContentPane().add(ClassAdmin);

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
