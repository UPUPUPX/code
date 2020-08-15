package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName LoginView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/14 18:31
 */
public class LoginView extends JFrame implements ActionListener {

        JButton register ;
        JButton login;
        JButton forgetPasswd;
        JButton jButton;
        JLabel name;
        JLabel password ;
        JTextField username;
        JPasswordField ipassword ;

        public LoginView() {
            name = new JLabel("用户名");
            name.setBounds(76, 166, 120, 30);
            name.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(name);
            getContentPane().setLayout(null);

            username = new JTextField();
            username.setBounds(178, 160, 240, 42);
            username.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(username);

            password = new JLabel("密码");
            password.setBounds(78, 214, 120, 30);
            password.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(password);

            ipassword = new JPasswordField();
            ipassword.setBounds(178, 208, 240, 42);
            ipassword.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(ipassword);

            forgetPasswd.setBounds(400, 214, 100, 30);
            getContentPane().add(forgetPasswd);
            forgetPasswd.setBorderPainted(false);
            forgetPasswd.setFocusPainted(false);
            forgetPasswd.setContentAreaFilled(false);
            forgetPasswd.addActionListener(this::actionPerformed);

            register = new JButton("注册");
            register.setText("注册");
            register.setBounds(282, 262, 136, 46);
            getContentPane().add(register);
            register.setFocusPainted(false);

            login = new JButton("登录");
            login.setText("登录");
            login.setBounds(134, 262, 136, 46);
            getContentPane().add(login);
            login.setFocusPainted(false);

            jButton = new JButton();
            jButton.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
            jButton.setForeground(new Color(255, 0, 0));
            jButton.setFont(new Font("", Font.BOLD, 36));
            jButton.setText("登录到我的文本银行");
            jButton.setBounds(78, 56,340, 72);
            jButton.setBorderPainted(false);
            jButton.setFocusPainted(false);
            jButton.setContentAreaFilled(false);
            getContentPane().add(jButton);

            setTitle("登录窗口");
            setBounds(200, 200, 560, 420);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            login.addActionListener(this);
            register.addActionListener(this);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == register) {

            } else {
                if (username.getText().equals("username") && String.valueOf(ipassword.getPassword()).equals("180580219")) {
                    /*
                    * 跳转界面
                    * */
                } else if (e.getSource() == forgetPasswd){
                    /*
                     * 跳转界面
                     * */
                } else if(e.getSource()==login){
                    BankView bankView = new BankView();
                    bankView.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
            }
        }
/*
        public static void main(String[] args) {
            new LoginView();
        }*/
}

