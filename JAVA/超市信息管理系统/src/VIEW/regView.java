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
    String name;
    String pass;
    String que;
    String an;
    String de;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getQue() {
        return que;
    }
    public void setQue(String que) {
        this.que = que;
    }
    public String getAn() {
        return an;
    }
    public void setAn(String an) {
        this.an = an;
    }
    public String getDe() {
        return de;
    }
    public void setDe(String de) {
        this.de = de;
    }
    private int flag;
    public void setFlag(int flag) { this.flag = flag; }
    public regView(int n) {
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
        setName(username.getText());
        setPass(String.valueOf(ipassword.getPassword()));
        setQue((String) jComboBox.getSelectedItem());
        setAn(answer.getText());
        setDe(dep.getText());
        setFlag(n);
        System.out.println(name);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel){
            dispose();
            new mainView();
        }else{
            UserOperator userOperator=new UserOperator();
            try {
                User users=userOperator.FindUser(username.getText());
                if (users!=null){
                    JOptionPane.showMessageDialog(null, "用户已存在");;
                }
                else {
                    User user = new User();
                    user.setName(getName());
                    user.setPass(getPass());
                    user.setQuestion(getQue());
                    user.setAnswer(getAn());
                    user.setDepartement(getDe());
                    if (flag == 0) {
                        user.setState(0);
                    } else {
                        user.setState(1);
                    }
                    userOperator.Insert(user);
                    System.out.println(name);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new regView(1);
    }
}
