package VIEW;

import DAO.User;
import Model.Encrypt;
import Service.UserOperator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName loginView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/15 22:06
 */
public class mainView extends JFrame implements ActionListener {
    JButton adminlog;
    JButton log;
    JButton forget;
    JButton jButton;
    JLabel name;
    JLabel passwd;
    JTextField username;
    JPasswordField ipass;
    User user;
    public mainView() {
            name = new JLabel("用户名");
            name.setBounds(76, 166, 120, 30);
            name.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(name);
            getContentPane().setLayout(null);
            username = new JTextField();
            username.setBounds(178, 160, 240, 42);
            username.setFont(new Font("", Font.BOLD, 24));
            username.setCaretColor(Color.CYAN);
            getContentPane().add(username);
            passwd = new JLabel("密码");
            passwd.setBounds(78, 214, 120, 30);
            passwd.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(passwd);
            ipass = new JPasswordField();
            ipass.setBounds(178, 208, 240, 42);
            ipass.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(ipass);
            adminlog = new JButton("主管登录");
            adminlog.setText("主管登录");
            adminlog.setBounds(282, 262, 136, 46);
            getContentPane().add(adminlog);
            adminlog.setFocusPainted(false);
            log = new JButton("登录");
            log.setText("登录");
            log.setBounds(134, 262, 136, 46);
            getContentPane().add(log);
            log.setFocusPainted(false);
            jButton = new JButton();
            jButton.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
            jButton.setForeground(new Color(255, 0, 0));
            jButton.setFont(new Font("", Font.BOLD, 36));
            jButton.setText("超市信息管理系统");
            jButton.setBounds(78, 56, 340, 72);
            jButton.setBorderPainted(false);
            jButton.setFocusPainted(false);
            jButton.setContentAreaFilled(false);
            getContentPane().add(jButton);
            setTitle("超市信息管理系统");
            setSize( 560, 420);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
            this.setIconImage(imageIcon.getImage());
            this.setLocationRelativeTo(null);
            forget= new JButton("忘记密码");
            forget.setBounds(400, 214, 100, 30);
            forget.setBorderPainted(false);
            forget.setFocusPainted(false);
            forget.setContentAreaFilled(false);
            forget.addActionListener(this::actionPerformed);
            getContentPane().add(forget);
            log.addActionListener(this);
            adminlog.addActionListener(this);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminlog) {
                dispose();
                new admainLog();
            } else if (e.getSource() == forget) {
                dispose();
                new forgetView();
            } else if (e.getSource() == log) {
                UserOperator userOperator = new UserOperator();
                try {
                    user = userOperator.FindUser(username.getText());
                   /* Encrypt encrypt = new Encrypt();
                    String str = encrypt.encode(getp());*/
                    if (user != null) {
                        if (user.getName().equals(username.getText()) && user.getPass().equals(String.valueOf(ipass.getPassword()))) {
                            dispose();
                            new userOperateView();
                        } else {
                            JOptionPane.showMessageDialog(null, "用户名或密码错误");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "用户未注册");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
    }
}
