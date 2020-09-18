package VIEW;

import DAO.User;
import Model.Encrypt;
import Model.listModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;

/**
 * @ClassName regVIew
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/15 22:28
 */
public class regView extends JFrame implements ActionListener {
    JButton register ;
    JButton cancel;
    JButton lab;
    JLabel regname;
    JLabel regpasswd;
    JLabel question;
    JLabel ans;
    JLabel department;
    JComboBox jComboBox;
    JTextField username;
    JTextField answer;
    JPasswordField ipassword;
    private int flag;
    public int getFlag() { return flag; }
    public void setFlag(int flag) { this.flag = flag; }
    public String getp(){ return String.valueOf(ipassword.getPassword()); }
    public regView(int n) {
        if (n==0) {
            regname = new JLabel("用户名");
            regname.setBounds(76, 90, 120, 30);
            regname.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(regname);
            getContentPane().setLayout(null);
            regpasswd = new JLabel("密 码");
            regpasswd.setBounds(76, 140, 120, 30);
            regpasswd.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(regpasswd);
            question = new JLabel("密保问题");
            question.setBounds(76, 190, 120, 30);
            question.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(question);
            ans = new JLabel("密保答案");
            ans.setBounds(76, 240, 120, 30);
            ans.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(ans);
            username = new JTextField();
            username.setBounds(176, 90, 240, 30);
            username.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(username);
            ipassword = new JPasswordField();
            ipassword.setBounds(176, 140, 240, 30);
            ipassword.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(ipassword);
            jComboBox = new JComboBox(new listModel());
            jComboBox.setBounds(176, 190, 240, 30);
            getContentPane().add(jComboBox);
            answer = new JTextField();
            answer.setBounds(176, 240, 240, 30);
            answer.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(answer);
            register = new JButton("注册");
            register.setText("注册");
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
            lab.setText("注册操作员账号");
            lab.setSize(200, 50);
            lab.setBorderPainted(false);
            lab.setFocusPainted(false);
            lab.setContentAreaFilled(false);
            getContentPane().add(lab);
            setSize(560, 420);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon imageIcon = new ImageIcon("./lib/.png");
            this.setIconImage(imageIcon.getImage());
            this.setLocationRelativeTo(null);
            cancel.addActionListener(this);
            register.addActionListener(this);
            setVisible(true);
        }
        else{
            regname = new JLabel("用户名");
            regname.setBounds(76, 90, 120, 30);
            regname.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(regname);
            getContentPane().setLayout(null);
            regpasswd = new JLabel("密 码");
            regpasswd.setBounds(76, 140, 120, 30);
            regpasswd.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(regpasswd);
            question = new JLabel("密保问题");
            question.setBounds(76, 190, 120, 30);
            question.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(question);
            ans = new JLabel("密保答案");
            ans.setBounds(76, 240, 120, 30);
            ans.setFont(new Font("", Font.BOLD, 24));
            getContentPane().add(ans);
            username = new JTextField();
            username.setBounds(176, 90, 240, 30);
            username.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(username);
            ipassword = new JPasswordField();
            ipassword.setBounds(176, 140, 240, 30);
            ipassword.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(ipassword);
            jComboBox = new JComboBox(new listModel());
            jComboBox.setBounds(176, 190, 240, 30);
            getContentPane().add(jComboBox);
            answer = new JTextField();
            answer.setBounds(176, 240, 240, 30);
            answer.setFont(new Font("", Font.BOLD, 22));
            getContentPane().add(answer);
            register = new JButton("注册");
            register.setText("注册");
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
            lab.setText("注册主管账号");
            lab.setSize(200, 50);
            lab.setBorderPainted(false);
            lab.setFocusPainted(false);
            lab.setContentAreaFilled(false);
            getContentPane().add(lab);
            setSize(560, 420);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon imageIcon = new ImageIcon("./lib/TextBank.png");
            this.setIconImage(imageIcon.getImage());
            this.setLocationRelativeTo(null);
            cancel.addActionListener(this);
            register.addActionListener(this);
            setVisible(true);
        }
        setFlag(n);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource()==cancel){
            dispose();
            //new loginView();
        }else{
            //UserOperator userOperator=new UserOperator();
            try {
                User user;
                user=userOperator.FindUser(id);
                if (user!=null){
                    JOptionPane.showMessageDialog(null, "用户已存在");;
                }else {
                    if (flag == 0) {
                        user = new User();
                        user.setName(username.getText());
                        user.setPass(regpasswd.getText());
                        user.setQuestion((String) jComboBox.getSelectedItem());
                        user.setAnswer(ans.getText());
                        user.setState(0);
                        dispose();
                        new loginView();
                    } else {
                        user.setName(username.getText());
                        user.setPass(regpasswd.getText());
                        user.setQuestion((String) jComboBox.getSelectedItem());
                        user.setAnswer(ans.getText());
                        user.setState(1);
                        dispose();
                        new loginView();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
    }
}
