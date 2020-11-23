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

public class Admin extends JFrame implements ActionListener{
    JButton User;
    JButton jButton;
    JButton Out;
    JButton AddUser;
    JLabel n1;
    JLabel n2;
    DefaultTableModel tableModel;
    int rows;
    USER user = new USER();
    StoreService storeService = new StoreService();

    public Admin(){
        super();

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为管理员");
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

        User = new JButton("查看用户");
        User.setText("查看用户");
        User.setBounds(10,48,190,46);
        User.setFont(new Font("", Font.BOLD,24));
        User.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1.setText("用户名称");
                n2.setText("身份");
                tableModel.setRowCount(0);
                int counts = storeService.getCount();
                if (counts > 0) {
                    for (int i = 0; i < counts + 2; i++) {
                        try {
                            user = UserService.FindUser(i);
                            if (user != null) {
                                String[] rowValue = {user.getUSERNAME(), user.getSHENFEN()};
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
        getContentPane().add(User);

        AddUser = new JButton("添加用户");
        AddUser.setText("添加用户");
        AddUser.setBounds(10,106,190,46);
        AddUser.setFont(new Font("", Font.BOLD,24));
        AddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getContentPane().add(AddUser);

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

        tableModel = new DefaultTableModel(rows = 0, 2);
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
        n2.setBounds(740, 48, 202, 50);
        getContentPane().add(n2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add) {
//            省略代码
            String []data={"","","",""};
            tableModel.addRow(data);
        }
    }
    public static void main(String[] args) {
        new Admin();
    }
}
