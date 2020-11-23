package View;

import DAO.USER;
import Model.Encrypt;
import Model.RegList;
import Service.UserService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register extends JFrame implements ActionListener {
    JButton register;
    JButton cancel;
    JButton lab;
    JLabel regname;
    JLabel regpass;
    JLabel regshen;
    JComboBox jComboBox;
    JTextField username;
    JPasswordField userpass;
    public String getPassword(){
        return String.valueOf(userpass.getPassword());
    }
    public Register(){
        regname = new JLabel("账号");
        regname.setBounds( 100, 166, 120,30);
        regname.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(regname);
        getContentPane().setLayout(null);
        regpass = new JLabel("密码");
        regpass.setBounds(100,214,120,30);
        regpass.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(regpass);
        regshen = new JLabel("用户");
        regshen.setBounds(100,118,120,30 );
        regshen.setFont(new Font("",Font.BOLD,24));
        getContentPane().add(regshen);

        username = new JTextField();
        username.setBounds(178,160,240,42);
        username.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(username);

        userpass = new JPasswordField();
        userpass.setBounds(178,208,240,42);
        userpass.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(userpass);

        jComboBox = new JComboBox(new RegList());
        jComboBox.setBounds(178,118,240,30);
        getContentPane().add(jComboBox);

        register = new JButton("注册");
        register.setText("注册");
        register.setBounds(134, 270, 136, 40);
        getContentPane().add(register);
        register.setFocusPainted(false);

        cancel = new JButton("取消");
        cancel.setText("取消");
        cancel.setBounds(282, 270, 136, 40);
        getContentPane().add(cancel);
        cancel.setFocusPainted(false);

        lab = new JButton();
        lab.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lab.setForeground(new Color(49, 130, 9));
        lab.setFont(new Font("", Font.BOLD, 40));
        lab.setText("注册账号");
        lab.setBounds(80,46,420,72);
        lab.setBorderPainted(false);
        lab.setFocusPainted(false);
        lab.setContentAreaFilled(false);
        getContentPane().add(lab);

        setSize(560, 420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon=new ImageIcon(" ");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        cancel.addActionListener(this);
        register.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel){
            dispose();
            new Login();
        }else{
            Encrypt encrypt=new Encrypt();
            String us=username.getText();
            String pa=encrypt.encode(getPassword());
            String sh=(String)jComboBox.getSelectedItem();
            UserService userService=new UserService();
            try {
                USER user=userService.FindUser(us);
                if (user!=null){
                    JOptionPane.showMessageDialog(null, "用户已存在");;
                }else{
                    USER user0=new USER();
                    user0.setUSERNAME(us);
                    user0.setUSERPASS(pa);
                    user0.setSHENFEN(sh);
                    user0.setSTATE(0);
                    userService.Insert(user0);
                    dispose();
                    new Login();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
