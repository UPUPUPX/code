package View;

import Model.ListModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName ForgetPasswdView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 10:54
 */
public class ForgetPasswdView extends JFrame implements ActionListener {
    JButton register ;
    JButton cancel;
    JButton lab;
    JLabel name;
    JLabel newpasswd;
    JLabel question;
    JLabel ans;
    JComboBox jComboBox;
    JTextField username;
    JTextField answer;
    JPasswordField ipassword;

    public ForgetPasswdView() {
        name = new JLabel("用户名");
        name.setBounds(76, 90, 120, 30);
        name.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(name);
        getContentPane().setLayout(null);

        newpasswd = new JLabel("密保问题");
        newpasswd.setBounds(76, 140, 120, 30);
        newpasswd.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(newpasswd);

        question = new JLabel("密保答案");
        question.setBounds(76, 190, 120, 30);
        question.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(question);

        ans = new JLabel("新密码");
        ans.setBounds(76, 240, 120, 30);
        ans.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(ans);

        username = new JTextField();
        username.setBounds(176, 90, 240, 30);
        username.setFont(new Font("", Font.BOLD, 22));
        getContentPane().add(username);

        jComboBox=new JComboBox(new ListModel());
        jComboBox.setBounds(176,140,240,30);
        getContentPane().add(jComboBox);

        answer = new JTextField();
        answer.setBounds(176, 190, 240, 30);
        answer.setFont(new Font("", Font.BOLD, 22));
        getContentPane().add(answer);

        ipassword = new JPasswordField();
        ipassword.setBounds(176, 240, 240, 30);
        ipassword.setFont(new Font("", Font.BOLD, 22));
        getContentPane().add(ipassword);

        register = new JButton("提交");
        register.setText("提交");
        register.setBounds(134, 300, 136, 40);
        getContentPane().add(register);
        register.setFocusPainted(false);

        cancel = new JButton("取消");
        cancel.setText("取消");
        cancel.setBounds(282, 300, 136, 40);
        getContentPane().add(cancel);
        cancel.setFocusPainted(false);

        lab = new JButton();
        lab.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lab.setForeground(new Color(0, 130, 114));
        lab.setFont(new Font("", Font.BOLD, 40));
        lab.setText("忘记密码");
        lab.setSize(200, 50);
        lab.setBorderPainted(false);
        lab.setFocusPainted(false);
        lab.setContentAreaFilled(false);
        getContentPane().add(lab);

        setBounds(200, 200, 560, 420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cancel.addActionListener(this);
        register.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
