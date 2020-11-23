package View;

import DAO.BOOK;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBook extends JFrame implements ActionListener {
    JButton Course;
    JButton BookTake;
    JButton ClassAdmin;
    JButton jButton;
    JButton increase;
    JButton decrease;
    BOOK book;
    JTable table;
    DefaultTableModel tableModel;
    JTextField textField;
    int rows;

    public CBook(){
        super();
        Course = new JButton("查看课程安排");
        Course.setText("查看课程安排");
        Course.setBounds(10,48,190,46);
        Course.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Course);

        BookTake = new JButton("教材领取");
        BookTake.setText("教材领取");
        BookTake.setBounds(10,106,190,46);
        BookTake.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(BookTake);

        ClassAdmin = new JButton("班级信息管理");
        ClassAdmin.setText("班级信息管理");
        ClassAdmin.setBounds(10,164,190,46);
        ClassAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(ClassAdmin);

        increase = new JButton("+");
        increase.setText("+");
        increase.setBounds(925,48,50,46);
        increase.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(increase);

        decrease = new JButton("-");
        decrease.setText("-");
        decrease.setBounds(985,48,50,46);
        decrease.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(decrease);

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
        JLabel n5;
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(40);
        table.setFont(new Font("宋体", Font.BOLD, 20));
        scrollPane.setViewportView(table);
        table.setBounds(228, 100, 1024, 750);
        getContentPane().add(table);
        //n1 = new JLabel("课程名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("授课用书");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("教材单价");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);
        //n4 = new JLabel("购买人数");
        //n4.setFont(new Font("宋体", Font.BOLD, 20));
        //n4.setBounds(834, 48, 202, 50);
        //getContentPane().add(n4);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("可否领取");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);

        n1 = new JLabel("教材名称");
        n1.setFont(new Font("宋体", Font.BOLD, 20));
        n1.setBounds(228, 48, 202, 50);
        getContentPane().add(n1);
        n2 = new JLabel("总价");
        n2.setFont(new Font("宋体", Font.BOLD, 20));
        n2.setBounds(430, 48, 202, 50);
        getContentPane().add(n2);
        n3 = new JLabel("是否已支付");
        n3.setFont(new Font("宋体", Font.BOLD, 20));
        n3.setBounds(632, 48, 202, 50);
        getContentPane().add(n3);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
