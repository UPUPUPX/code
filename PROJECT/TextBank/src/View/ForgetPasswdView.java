package View;

import Model.Encrypt;
import Model.ListModel;
import UserService.User;
import UserService.UserOperator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName ForgetPasswdView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 10:54
 */
public class ForgetPasswdView extends JFrame implements ActionListener {
    JButton update;
    JButton cancel;
    JButton lab;
    JLabel name;
    JLabel newpasswd;
    JLabel question;
    JLabel ans;
    private final JComboBox jComboBox;
    private final JTextField username;
    private final JTextField answer;
    private final JPasswordField ipassword;

    public String getp() { return String.valueOf(ipassword.getPassword()); }
    public ForgetPasswdView() {
        name = new JLabel("用户名");
        name.setBounds(76, 90, 120, 30);
        name.setFont(new Font("",Font.BOLD, 24));
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

        update = new JButton("提交");
        update.setText("提交");
        update.setBounds(134, 300, 136, 40);
        getContentPane().add(update);
        update.setFocusPainted(false);

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

        setSize(560, 420);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        cancel.addActionListener(this);
        update.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== update){
            UserOperator userOperator=new UserOperator();
            try {
                User user=userOperator.FindUser(username.getText());
                if(user==null){
                    JOptionPane.showMessageDialog(null, "未查询到用户");
                }else{
                    String ques=(String)jComboBox.getSelectedItem();
                    if (user.getAnswer().equals(answer.getText())&&user.getQuestion().equals(ques)&&user.getId().equals(username.getText())){
                        Encrypt encrypt=new Encrypt();
                        user.setPasswd(encrypt.encode(getp()));
                        userOperator.update(user);
                        dispose();
                        new LoginView();
                    }else{
                        JOptionPane.showMessageDialog(null, "更新失败，请重试");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            new LoginView();
        }
    }
}
