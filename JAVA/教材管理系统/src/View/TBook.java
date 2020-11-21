package View;

import DAO.BOOK;
import DAO.TEACHER;
import Service.TeacherService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TBook extends JFrame implements ActionListener, TableModelListener {
    JButton BookAdmin;
    JButton UBookAdmin;
    JButton RBookAdmin;
    JButton PersonAdmin;
    JButton jButton;
    BOOK book;
    JTable table;
    DefaultTableModel tableModel;
    JTextField textField;
    int rows;
    TEACHER Teacher=new TEACHER();
    TeacherService teacherService = new TeacherService();

    public TBook(String name){
        super();
        BookAdmin = new JButton("教材管理");
        BookAdmin.setText("教材管理");
        BookAdmin.setBounds(10,48,190,46);
        BookAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(BookAdmin);

        UBookAdmin = new JButton("未过审教材");
        UBookAdmin.setText("未过审教材");
        UBookAdmin.setBounds(10,106,190,46);
        UBookAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(UBookAdmin);

        RBookAdmin = new JButton("已入库教材");
        RBookAdmin.setText("已入库教材");
        RBookAdmin.setBounds(10,164,190,46);
        RBookAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(RBookAdmin);

        PersonAdmin = new JButton("个人信息管理");
        PersonAdmin.setText("个人信息管理");
        PersonAdmin.setBounds(10,222,190,46);
        PersonAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(PersonAdmin);

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为教师");
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
        //n1 = new JLabel("课程名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("推荐教材");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);

        //n1 = new JLabel("教材名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("可否领书");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);

        n1 = new JLabel("教师名称");
        n1.setFont(new Font("宋体", Font.BOLD, 20));
        n1.setBounds(228, 48, 202, 50);
        getContentPane().add(n1);
        n2 = new JLabel("所授课程");
        n2.setFont(new Font("宋体", Font.BOLD, 20));
        n2.setBounds(430, 48, 202, 50);
        getContentPane().add(n2);
        PersonAdmin.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PersonAdmin){
            String[] rowValues = {String.valueOf(Teacher.getTName()),String.valueOf(Teacher.getCourseName())};
            tableModel.addRow(rowValues);
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
        new TBook("1");
    }
}
