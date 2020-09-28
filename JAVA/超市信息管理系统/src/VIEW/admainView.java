package VIEW;

import DAO.User;
import Model.Encrypt;
import Model.listModel;
import Service.UserOperator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName admainView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/16 22:00
 */
public class admainView extends JFrame implements ActionListener {
    JLabel name;
    JLabel pass;
    JButton log;
    JButton forget;
    JButton exit;
    JTextField username;
    JButton lab;
    JPasswordField ipassword;
    User user;
    public admainView(){
        name=new JLabel("账号");
        pass=new JLabel("密码");
        log=new JButton("登录");
        forget=new JButton("忘记密码");
        exit=new JButton("退出");
        name.setBounds(76, 120, 120, 30);
        name.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(name);
        getContentPane().setLayout(null);
        pass.setBounds(76, 190, 120, 30);
        pass.setFont(new Font("", Font.BOLD, 24));
        getContentPane().add(pass);
        username = new JTextField();
        username.setBounds(176, 115, 240, 40);
        username.setFont(new Font("", Font.BOLD, 22));
        username.setCaretColor(Color.CYAN);
        getContentPane().add(username);
        ipassword = new JPasswordField();
        ipassword.setBounds(176, 185, 240, 40);
        ipassword.setFont(new Font("", Font.BOLD, 22));
        getContentPane().add(ipassword);
        log.setBounds(134, 300, 136, 40);
        getContentPane().add(log);
        log.setFocusPainted(false);
        exit.setBounds(282, 300, 136, 40);
        getContentPane().add(exit);
        exit.setFocusPainted(false);
        forget.setBounds(400, 190, 100, 30);
        forget.setBorderPainted(false);
        forget.setFocusPainted(false);
        forget.setContentAreaFilled(false);
        forget.addActionListener(this::actionPerformed);
        getContentPane().add(forget);
        lab = new JButton();
        lab.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lab.setForeground(new Color(0, 130, 114));
        lab.setFont(new Font("", Font.BOLD, 40));
        lab.setText("主管登录");
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
        log.addActionListener(this);
        forget.addActionListener(this);
        exit.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            dispose();
            new mainView();
        }
        if (e.getSource()==log){
            user.setName(username.getText());
            user.setPass(String.valueOf(ipassword.getPassword()));
            user.setState(1);
            UserOperator userOperator=new UserOperator();
            try {
                User u= userOperator.FindUser(username.getName());
                if (u!=null){
                    if (u.getPass().equals(user.getName())){
                        dispose();
                        new adminOperateView();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "用户密码错误");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户不存在");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
