package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginFrame extends JFrame implements ActionListener {

    JButton exit = new JButton("退出");
    JButton login=new JButton("登录");
    JLabel name = new JLabel("用户名");
    JLabel password = new JLabel("密码");
    JTextField username = new JTextField();
    JPasswordField ipassword = new JPasswordField();
    JLabel lab1 = new JLabel();
    JLabel lab2=new JLabel();

    public LoginFrame() {
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

        exit = new JButton("退出");
        exit.setText("退出");
        exit.setBounds(282, 262, 136, 46);
        getContentPane().add(exit);

        login = new JButton("登录");
        login.setText("登录");
        login.setBounds(134, 262, 136, 46);
        getContentPane().add(login);


        lab1 = new JLabel();
        lab1.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lab1.setForeground(new Color(255, 0, 0));
        lab1.setFont(new Font("", Font.BOLD, 36));
        lab1.setText("登录到我的剪切板");
        lab1.setBounds(78, 56,340, 72);
        getContentPane().add(lab1);

        this.setTitle("剪切板");
        this.setBounds(200, 200, 560, 420);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("登录窗口");
        setBounds(200, 200, 560, 420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        login.addActionListener(this);
        exit.addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else {
            if (username.getText().equals("username") && String.valueOf(ipassword.getPassword()).equals("180580219")) {
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
