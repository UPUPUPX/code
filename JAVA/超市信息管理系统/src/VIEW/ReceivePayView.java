package VIEW;

import DAO.shopList;
import Service.printl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class ReceivePayView extends JFrame implements ActionListener {
    private JLabel charge;
    private JButton print;
    private JButton exit;
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public int windowsWedth = 600;
    public int windowsHeight = 400;
    LinkedList<shopList> p=new LinkedList<>();
    public ReceivePayView(double in, double charges, LinkedList<shopList> shoplist) {
        getContentPane().setLayout(null);
        this.setTitle("找零");
        this.setVisible(true);
        int x = (width - windowsWedth) / 2;
        int y = (height - windowsHeight) / 2;
        this.setBounds(x, y, windowsWedth, windowsHeight);
        charge = new JLabel("应找" + String.valueOf(in - charges));
        charge.setFont(new Font("", Font.BOLD, 80));
        charge.setBounds(100, 10, 400, 100);
        charge.setBackground(new Color(0,127,127));
        print = new JButton("打印");
        print.setBounds(100, 200, 200, 60);
        print.setFont(new Font("", Font.BOLD, 50));
        print.addActionListener(this);
        print.setBackground(new Color(0,127,127));
        exit = new JButton("退出");
        exit.setBounds(305, 200, 200, 60);
        exit.setFont(new Font("", Font.BOLD, 50));
        exit.addActionListener(this);
        exit.setBackground(new Color(0,127,127));
        getContentPane().add(charge);
        getContentPane().add(exit);
        getContentPane().add(print);
        getContentPane().add(exit);
        p.addAll(shoplist);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==print){
            try {
                new printl(p);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (e.getSource()==exit){
            dispose();
        }
    }
}
