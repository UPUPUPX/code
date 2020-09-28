package VIEW;
import DAO.User;
import Model.listModel;
import Service.UserOperator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JTextField dep;
    JPasswordField ipassword;
    private int flag;
    public int getFlag() { return flag; }
    public void setFlag(int flag) { this.flag = flag; }
    public String getp(){ return String.valueOf(ipassword.getPassword()); }
    public regView(int n) {
        if (n==0) {
            regname = new JLabel("用户名");
            regname.setBounds(76, 90, 200, 40);
            regname.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(regname);
            getContentPane().setLayout(null);
            regpasswd = new JLabel("密 码");
            regpasswd.setBounds(76, 140, 200, 40);
            regpasswd.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(regpasswd);
            question = new JLabel("密保问题");
            question.setBounds(76, 190, 200, 40);
            question.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(question);
            ans = new JLabel("密保答案");
            ans.setBounds(76, 240, 200, 40);
            ans.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(ans);
            department=new JLabel("部门");
            department.setFont(new Font("宋体",Font.BOLD,36));
            department.setBounds(76,290,200,40);
            getContentPane().add(department);
            username = new JTextField();
            username.setBounds(300, 90, 350, 40);
            username.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(username);
            ipassword = new JPasswordField();
            ipassword.setBounds(300, 140, 350, 40);
            ipassword.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(ipassword);
            jComboBox = new JComboBox(new listModel());
            jComboBox.setBounds(300, 190, 350, 40);
            getContentPane().add(jComboBox);
            answer = new JTextField();
            answer.setBounds(300, 240, 350, 40);
            answer.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(answer);
            dep=new JTextField();
            dep.setBounds(300,290,350,40);
            dep.setFont(new Font("宋体",Font.BOLD,36));
            getContentPane().add(dep);
            register = new JButton("注册");
            register.setText("注册");
            register.setBounds(134, 400, 136, 40);
            getContentPane().add(register);
            register.setFocusPainted(false);
            cancel = new JButton("取消");
            cancel.setText("取消");
            cancel.setBounds(282, 400, 136, 40);
            getContentPane().add(cancel);
            cancel.setFocusPainted(false);
            lab = new JButton();
            lab.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
            lab.setForeground(new Color(0, 130, 114));
            lab.setFont(new Font("", Font.BOLD, 40));
            lab.setText("注册员工账号");
            lab.setSize(300, 50);
            lab.setBorderPainted(false);
            lab.setFocusPainted(false);
            lab.setContentAreaFilled(false);
            getContentPane().add(lab);
            setSize(800, 540);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            cancel.addActionListener(this);
            register.addActionListener(this);
            setVisible(true);
            getContentPane().setLayout(null);
        }
        else{
            regname = new JLabel("用户名");
            regname.setBounds(76, 90, 200, 40);
            regname.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(regname);
            getContentPane().setLayout(null);
            regpasswd = new JLabel("密 码");
            regpasswd.setBounds(76, 140, 200, 40);
            regpasswd.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(regpasswd);
            question = new JLabel("密保问题");
            question.setBounds(76, 190, 200, 40);
            question.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(question);
            ans = new JLabel("密保答案");
            ans.setBounds(76, 240, 200, 40);
            ans.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(ans);
            department=new JLabel("部门");
            department.setFont(new Font("宋体",Font.BOLD,36));
            department.setBounds(76,290,200,40);
            getContentPane().add(department);
            username = new JTextField();
            username.setBounds(300, 90, 350, 40);
            username.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(username);
            ipassword = new JPasswordField();
            ipassword.setBounds(300, 140, 350, 40);
            ipassword.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(ipassword);
            jComboBox = new JComboBox(new listModel());
            jComboBox.setBounds(300, 190, 350, 40);
            getContentPane().add(jComboBox);
            answer = new JTextField();
            answer.setBounds(300, 240, 350, 40);
            answer.setFont(new Font("", Font.BOLD, 36));
            getContentPane().add(answer);
            dep=new JTextField();
            dep.setBounds(300,290,350,40);
            dep.setFont(new Font("宋体",Font.BOLD,36));
            getContentPane().add(dep);
            register = new JButton("注册");
            register.setText("注册");
            register.setBounds(134, 400, 136, 40);
            getContentPane().add(register);
            register.setFocusPainted(false);
            cancel = new JButton("取消");
            cancel.setText("取消");
            cancel.setBounds(282, 400, 136, 40);
            getContentPane().add(cancel);
            cancel.setFocusPainted(false);
            lab = new JButton();
            lab.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
            lab.setForeground(new Color(0, 130, 114));
            lab.setFont(new Font("", Font.BOLD, 40));
            lab.setText("注册主管账号");
            lab.setSize(300, 50);
            lab.setBorderPainted(false);
            lab.setFocusPainted(false);
            lab.setContentAreaFilled(false);
            getContentPane().add(lab);
            setSize(800, 540);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            cancel.addActionListener(this);
            register.addActionListener(this);
            setVisible(true);
        }
        setFlag(n);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel){
            dispose();
            new mainView();
        }else{
            UserOperator userOperator=new UserOperator();
            try {
                User user;
                user=userOperator.FindUser(username.getText());
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
                        userOperator.Insert(user);
                        dispose();
                        new mainView();
                    } else {
                        user.setName(username.getText());
                        user.setPass(regpasswd.getText());
                        user.setQuestion((String) jComboBox.getSelectedItem());
                        user.setAnswer(ans.getText());
                        user.setState(1);
                        userOperator.Insert(user);
                        dispose();
                        new mainView();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
