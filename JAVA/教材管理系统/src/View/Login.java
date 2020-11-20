package View;

import DAO.USER;
import Model.LoginList;
import Service.UserService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JButton login;
    JButton register;
    JButton forget;
    JButton jButton;
    JLabel shenfen;
    JLabel username;
    JLabel password;
    JTextField name;
    JPasswordField word;
    JComboBox jComboBox;
    public String getPassWord(){
        return String.valueOf(word.getPassword());
    }
    public Login(){
        username = new JLabel("账号");
        username.setBounds( 100, 166, 120,30);
        username.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(username);
        getContentPane().setLayout(null);
        name = new JTextField();
        name.setBounds(178,160,240,42);
        name.setFont(new Font("", Font.BOLD, 24));
        name.setCaretColor(Color.magenta);
        getContentPane().add(name);

        password = new JLabel("密码");
        password.setBounds(100,214,120,30);
        password.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(password);
        word = new JPasswordField();
        word.setBounds(178,208,240,42);
        word.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(word);

        shenfen = new JLabel("用户");
        shenfen.setBounds(100,118,120,30 );
        shenfen.setFont(new Font("",Font.BOLD,24));
        getContentPane().add(shenfen);
        jComboBox = new JComboBox(new LoginList());
        jComboBox.setBounds(178,118,240,30);
        getContentPane().add(jComboBox);

        login = new JButton("登录");
        login.setText("登录");
        login.setBounds(140,262,270,46);
        getContentPane().add(login);
        login.setFocusPainted(false);

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("欢迎登录教材管理系统");
        jButton.setBounds(68,46,420,72);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.setContentAreaFilled(false);
        getContentPane().add(jButton);
        setTitle("教材管理系统");
        setSize(560,420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        forget = new JButton("忘记密码");
        forget.setBounds(400,214,100,30);
        forget.setBorderPainted(false);
        forget.setFocusPainted(false);
        forget.setContentAreaFilled(false);
        forget.addActionListener(this);
        getContentPane().add(forget);

        register = new JButton("注册账号");
        register.setBounds(400,166,100,30);
        register.setBorderPainted(false);
        register.setFocusPainted(false);
        register.setContentAreaFilled(false);
        register.addActionListener(this);
        getContentPane().add(register);

        login.addActionListener(this);
        register.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register){
            dispose();
            new Register();
        }
        else if (e.getSource() == login) {
            UserService userService = new UserService();
            try {
                if (userService.FindUser(name.getText())!= null) {
                    if (userService.FindUser(name.getText()).getUSERNAME().equals(name.getText()) && userService.FindUser(name.getText()).getUSERPASS().equals(String.valueOf(word.getPassword()))) {
                        dispose();
                        new UserService();
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "用户未注册");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
