package View;

import Model.Encrypt;
import Model.GetCounts;
import UserService.User;
import UserService.UserOperator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName LoginView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/14 18:31
 */
public class LoginView extends JFrame implements ActionListener {

    JButton register;
    JButton login;
    JButton forgetPasswd;
    JButton jButton;
    JLabel name;
    JLabel password;
    JTextField username;
    JPasswordField ipassword;
    User user;

    public String getp() { return String.valueOf(ipassword.getPassword()); }
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
        jButton.setBounds(78, 56, 340, 72);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.setContentAreaFilled(false);
        getContentPane().add(jButton);

        setTitle("登录窗口");
        setSize( 560, 420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        forgetPasswd = new JButton("忘记密码");
        forgetPasswd.setBounds(400, 214, 100, 30);
        forgetPasswd.setBorderPainted(false);
        forgetPasswd.setFocusPainted(false);
        forgetPasswd.setContentAreaFilled(false);
        forgetPasswd.addActionListener(this::actionPerformed);
        getContentPane().add(forgetPasswd);

        login.addActionListener(this);
        register.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            dispose();
            new RegisterView();
        } else if (e.getSource() == forgetPasswd) {
            dispose();
            new ForgetPasswdView();
        } else if (e.getSource() == login) {
            UserOperator userOperator = new UserOperator();
            try {
                user = userOperator.FindUser(username.getText());
                Encrypt encrypt = new Encrypt();
                String str = encrypt.encode(getp());
                if (user != null) {
                    if (user.getId().equals(username.getText()) && user.getPasswd().equals(str)) {
                        dispose();
                        new BankView();
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

    public static void main(String[] args) {
        new LoginView();
    }
}

