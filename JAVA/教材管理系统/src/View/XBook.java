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

public class XBook extends JFrame implements ActionListener {
    JButton CourseAdmin;
    JButton BookAdmin;
    JButton TeacherAdmin;
    JButton ClassAdmin;
    JButton jButton;
    JButton Out;
    JLabel n1;
    JLabel n2;
    JLabel n3;
    JLabel n4;
    DefaultTableModel tableModel;
    int rows;
    TEACHER Teacher=new TEACHER();
    COURSE course = new COURSE();
    AUDIT audit = new AUDIT();
    CLASS aClass = new CLASS();
    ClassService classService = new ClassService();
    AuditService auditService = new AuditService();
    TeacherService teacherService = new TeacherService();

    public XBook(){
        super();

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

        CourseAdmin = new JButton("课程管理");
        CourseAdmin.setText("课程管理");
        CourseAdmin.setBounds(10,48,190,46);
        CourseAdmin.setFont(new Font("", Font.BOLD,24));
        CourseAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("课程名称");
                n2.setText("授课老师");
                n3.setText(" ");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= CourseService.getCount();
                if (counts>0){
                    for (int i = 0; i < counts+2; i++) {
                        try {
                            course = CourseService.FindCourse(i);
                            if (course != null) {
                                String[] rowValue = {course.getNAME(),course.getTName()};
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
        getContentPane().add(CourseAdmin);

        BookAdmin = new JButton("教材审核");
        BookAdmin.setText("教材审核");
        BookAdmin.setBounds(10,106,190,46);
        BookAdmin.setFont(new Font("", Font.BOLD,24));
        BookAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("课程名称");
                n2.setText("授课老师");
                n3.setText("推荐教材");
                n4.setText("是否通过");
                tableModel.setRowCount(0);
                int counts= auditService.getCount();
                if (counts>0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            audit = AuditService.FindAudit(i);
                            if (audit != null) {
                                String[] rowValue = {audit.getCoName(), audit.getTName(), audit.getBName(), String.valueOf(audit.getFlag())};
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
        getContentPane().add(BookAdmin);

        TeacherAdmin = new JButton("教师管理");
        TeacherAdmin.setText("教师管理");
        TeacherAdmin.setBounds(10,164,190,46);
        TeacherAdmin.setFont(new Font("", Font.BOLD,24));
        TeacherAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("教师名称");
                n2.setText("所教课程");
                n3.setText(" ");
                n4.setText(" ");
                tableModel.setRowCount(0);
                int counts= teacherService.getCount();
                if (counts>0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            Teacher = TeacherService.FindTeacher(i);
                            if (Teacher != null) {
                                String[] rowValue = {Teacher.getTName(), Teacher.getCourseName()};
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
        getContentPane().add(TeacherAdmin);

        ClassAdmin = new JButton("班级管理");
        ClassAdmin.setText("班级管理");
        ClassAdmin.setBounds(10,222,190,46);
        ClassAdmin.setFont(new Font("", Font.BOLD,24));
        ClassAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("班级编号");
                n2.setText("所属系部");
                n3.setText("班级名称");
                n4.setText("班级人数");
                tableModel.setRowCount(0);
                int counts= classService.getCount();
                if (counts>0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            aClass = ClassService.FindClass(i);
                            if (aClass != null) {
                                String[] rowValue = {String.valueOf(aClass.getID()), aClass.getXName(), aClass.getClassName(), String.valueOf(aClass.getNum())};
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
