package VIEW;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName userOperateView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/17 19:46
 */
public class userOperateView extends JFrame{
    JLabel goodsId;
    JLabel count;
    JLabel pay;
    JLabel balance;
    JLabel total;
    JTextField id;
    JTextField counts;
    JTextField money;
    JTextField bal;
    JTextField to;
    JButton print;
    public Color heavywrite=new Color(233,243,243);
    public Color bluegreen =new Color(0,127,127);
    public userOperateView(){
        setSize(1920,1030);
        getContentPane().setLayout(null);
        goodsId=new JLabel("商品编号" );
        goodsId.setFont(new Font("宋体",Font.BOLD,36));
        goodsId.setBounds(40,100,180,50);
        getContentPane().add(goodsId);
        id=new JTextField();
        id.setBackground(heavywrite);
        id.setFont(new Font("宋体",Font.BOLD,30));
        id.setBounds(260,100,300,50);
        getContentPane().add(id);
        count=new JLabel("商品件数");
        count.setFont(new Font("宋体",Font.BOLD,36));

        setVisible(true);
    }

    public static void main(String[] args) {
        new userOperateView();
    }
}
