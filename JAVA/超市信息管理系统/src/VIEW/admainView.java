package VIEW;

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
    JFrame loginframe;
    public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)
    {
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        add(c,constraints);
    }
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
        JTextField username = new JTextField();
        username.setBounds(176, 115, 240, 40);
        username.setFont(new Font("", Font.BOLD, 22));
        username.setCaretColor(Color.CYAN);
        getContentPane().add(username);
        JPasswordField ipassword = new JPasswordField();
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
        JButton lab = new JButton();
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
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        new admainView();
    }
}
