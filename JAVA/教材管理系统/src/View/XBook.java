package View;

import DAO.BOOK;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XBook extends JFrame implements ActionListener {
    JButton CourseAdmin;
    JButton BookAdmin;
    JButton TeacherAdmin;
    JButton ClassAdmin;
    JButton UserAdmin;
    JButton jButton;
    BOOK book;
    JTable table;
    DefaultTableModel tableModel;
    JTextField textField;
    int rows;

    public XBook(){
        super();
        CourseAdmin = new JButton("课程管理");
        CourseAdmin.setText("课程管理");
        CourseAdmin.setBounds(10,48,190,46);
        CourseAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(CourseAdmin);

        BookAdmin = new JButton("教材审核");
        BookAdmin.setText("教材审核");
        BookAdmin.setBounds(10,106,190,46);
        BookAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(BookAdmin);

        TeacherAdmin = new JButton("教师管理");
        TeacherAdmin.setText("教师管理");
        TeacherAdmin.setBounds(10,164,190,46);
        TeacherAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(TeacherAdmin);

        ClassAdmin = new JButton("班级管理");
        ClassAdmin.setText("班级管理");
        ClassAdmin.setBounds(10,222,190,46);
        ClassAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(ClassAdmin);

        UserAdmin = new JButton("用户管理");
        UserAdmin.setText("用户管理");
        UserAdmin.setBounds(10,280,190,46);
        UserAdmin.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(UserAdmin);

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为系部");
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
        //n1 = new JLabel("课程编号");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("课程名称");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("授课老师");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);

        //n1 = new JLabel("课程名称");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("授课老师");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("推荐教材");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);
        //n4 = new JLabel("是否通过");
        //n4.setFont(new Font("宋体", Font.BOLD, 20));
        //n4.setBounds(834, 48, 202, 50);
        //getContentPane().add(n4);

        //n1 = new JLabel("教师编号");
        //n1.setFont(new Font("宋体", Font.BOLD, 20));
        //n1.setBounds(228, 48, 202, 50);
        //getContentPane().add(n1);
        //n2 = new JLabel("教师名称");
        //n2.setFont(new Font("宋体", Font.BOLD, 20));
        //n2.setBounds(430, 48, 202, 50);
        //getContentPane().add(n2);
        //n3 = new JLabel("所教课程");
        //n3.setFont(new Font("宋体", Font.BOLD, 20));
        //n3.setBounds(632, 48, 202, 50);
        //getContentPane().add(n3);

        n1 = new JLabel("班级编号");
        n1.setFont(new Font("宋体", Font.BOLD, 20));
        n1.setBounds(228, 48, 202, 50);
        getContentPane().add(n1);
        n2 = new JLabel("所属系部");
        n2.setFont(new Font("宋体", Font.BOLD, 20));
        n2.setBounds(430, 48, 202, 50);
        getContentPane().add(n2);
        n3 = new JLabel("班级名称");
        n3.setFont(new Font("宋体", Font.BOLD, 20));
        n3.setBounds(632, 48, 202, 50);
        getContentPane().add(n3);
        n4 = new JLabel("班级人数");
        n4.setFont(new Font("宋体", Font.BOLD, 20));
        n4.setBounds(834, 48, 202, 50);
        getContentPane().add(n4);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
