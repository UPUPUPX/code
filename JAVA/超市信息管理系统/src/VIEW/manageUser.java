package VIEW;

import DAO.User;
import Service.UserOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName manageUser
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/19 20:54
 */
public class manageUser extends JFrame implements ActionListener {
    JLabel username;
    JLabel changepass;
    JTextField jusername;
    JPasswordField jchangepass;
    JButton exit;
    JButton delete;
    JButton add;
    User user;
    private int status;
    public int getStatus() {return status; }
    public void setStatus(int status) { this.status = status; }
    public Color bluegreen =new Color(0,127,127);
    public manageUser(int status){
        setBounds(1,1,720,480);
        username=new JLabel("用户名");
        username.setFont(new Font("宋体",Font.BOLD,36));
        username.setBounds(80,80,150,50);
        getContentPane().add(username);
        jusername=new JTextField();
        jusername.setFont(new Font("宋体",Font.BOLD,36));
        jusername.setBounds(250,80,390,50);
        getContentPane().add(jusername);
        changepass=new JLabel("用户密码");
        changepass.setFont(new Font("宋体",Font.BOLD,36));
        changepass.setBounds(80,160,160,50);
        getContentPane().add(changepass);
        jchangepass=new JPasswordField();
        jchangepass.setFont(new Font("宋体",Font.BOLD,36));
        jchangepass.setBounds(250,160,390,50);
        getContentPane().add(jchangepass);
        delete=new JButton("删除");
        delete.setFont(new Font("宋体",Font.BOLD,36));
        delete.setBounds(80,300,150,50);
        delete.setBackground(bluegreen);
        getContentPane().add(delete);
        exit=new JButton("退出");
        exit.setFont(new Font("宋体",Font.BOLD,36));
        exit.setBounds(285,300,150,50);
        exit.setBackground(bluegreen);
        getContentPane().add(exit);
        add=new JButton("注册");
        add.setFont(new Font("宋体",Font.BOLD,36));
        add.setBounds(490,300,150,50);
        add.setBackground(bluegreen);
        getContentPane().add(add);
        exit.addActionListener(this);
        delete.addActionListener(this);
        add.addActionListener(this);
        getContentPane().setLayout(null);
        setVisible(true);
        setStatus(status);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            new regView(getStatus());
        }
        if (e.getSource()==delete){
            UserOperator userOperator=new UserOperator();
            User user= null;
            try {
                user = userOperator.FindUser(jusername.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (user!=null){
                try {
                    userOperator.delete(user);
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "用户不存在");
            }
        }
        if (e.getSource()==exit){
            dispose();
            new adminOperateView();
        }
    }
}
