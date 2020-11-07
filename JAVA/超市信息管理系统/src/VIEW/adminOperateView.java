package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName adminOperateView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/17 17:05
 * 网格布局
 */
public class adminOperateView extends JFrame implements ActionListener {
    JButton useroperate;
    JButton adminoperate;
    JButton bill;
    JButton state;
    JButton salary;
    JButton exit;
    public Color bluegreen =new Color(0,127,127);
    public Color heavyyello=new Color(254,220,0);
    public Color heavygreen= new Color(19,191,112);
    public Color heavywrite=new Color(233,243,243);
    public adminOperateView() {
        this.setLayout(new GridLayout(2, 3, 0, 0));
        setBackground(heavygreen);
        useroperate= new JButton("员工管理");
        useroperate.setFocusPainted(false);
        useroperate.setBorderPainted(false);
        useroperate.setBackground(heavyyello);
        useroperate.setFont(new Font("", Font.BOLD, 40));
        useroperate.setForeground(heavywrite);
        adminoperate = new JButton("主管管理");
        adminoperate.setFocusPainted(false);
        adminoperate.setBorderPainted(false);
        adminoperate.setBackground(heavyyello);
        adminoperate.setFont(new Font("", Font.BOLD, 40));
        adminoperate.setForeground(heavywrite);
        exit = new JButton("退出");
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setBackground(heavyyello);
        exit.setFont(new Font("", Font.BOLD, 40));
        exit.setForeground(heavywrite);
        bill=new JButton("查看流水");
        bill.setFocusPainted(false);
        bill.setBorderPainted(false);
        bill.setBackground(heavygreen);
        bill.setFont(new Font("", Font.BOLD, 40));
        bill.setForeground(heavywrite);
        salary=new JButton("工资管理");
        salary.setFocusPainted(false);
        salary.setBorderPainted(false);
        salary.setBackground(heavygreen);
        salary.setFont(new Font("", Font.BOLD, 40));
        salary.setForeground(heavywrite);
        state=new JButton("待定功能");
        state.setFocusPainted(false);
        state.setBorderPainted(false);
        state.setBackground(heavygreen);
        state.setFont(new Font("", Font.BOLD, 40));
        state.setForeground(heavywrite);
        setSize(750,480);
        getContentPane().add(useroperate);
        getContentPane().add(adminoperate);
        getContentPane().add(exit);
        getContentPane().add(bill);
        getContentPane().add(salary);
        getContentPane().add(state);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("./lib/.png");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);
        useroperate.addActionListener(this);
        adminoperate.addActionListener(this);
        exit.addActionListener(this);
        bill.addActionListener(this);
        salary.addActionListener(this);
        state.addActionListener(this);
        setVisible(true);
        this.setResizable(true);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==useroperate){
            dispose();
            new manageUser(0);
        }
        if (e.getSource()==adminoperate){
            dispose();
            new manageUser(1);
        }
        if (e.getSource()==exit){
            dispose();
            new mainView();
        }
        if (e.getSource()==bill){
            dispose();
            adminprintlist bills=new adminprintlist();
            bills.mainrun();
        }
        if (e.getSource()==salary){

        }
        if (e.getSource()==state){
            JOptionPane.showMessageDialog(null, "新功能正在开发当中");
        }
    }
}