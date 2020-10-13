package VIEW;

import DAO.Goods;
import Service.GoodsOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.XMLFormatter;

/**
 * @ClassName addGoods
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/22 21:46
 */
public class addGoods extends JFrame implements ActionListener {
    JLabel [] jButtons=new JLabel[5];
    JButton save;
    JButton exit;
    JTextField[] jTextFields=new JTextField[5];
    String[] strings={"商品编号","商品名称","商品进价","商品售价","商品数量"};
    GoodsOperate goodsOperate=new GoodsOperate();
    public addGoods(){
        setSize(800,680);
        setVisible(true);
        getContentPane().setLayout(null);
        for (int i = 0; i < 5; i++) {
            jButtons[i]=new JLabel(strings[i]);
            jButtons[i].setFont(new Font("宋体",Font.BOLD,36));
            jButtons[i].setBounds(50,80+i*100,180,50);
            getContentPane().add(jButtons[i]);
        }
        for (int i = 0; i < 5; i++) {
            jTextFields[i]=new JTextField();
            jTextFields[i].setBounds(270,80+i*100,400,50);
            jTextFields[i].setFont(new Font("宋体",Font.BOLD,36));
            getContentPane().add(jTextFields[i]);
        }
        save=new JButton("保存");
        save.setFont(new Font("宋体",Font.BOLD,36));
        save.setBounds(50,580,300,50);
        exit=new JButton("退出");
        exit.setFont(new Font("宋体",Font.BOLD,36));
        exit.setBounds(370,580,300,50);
        getContentPane().add(save);
        getContentPane().add(exit);
        save.addActionListener(this);
        exit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==save){
            Goods goods=new Goods();
            goods.setID(Integer.parseInt(jTextFields[0].getText()));
            goods.setName(jTextFields[1].getText());
            goods.setInprice(Float.parseFloat(jTextFields[2].getText()));
            goods.setOutprice(Float.parseFloat(jTextFields[3].getText()));
            goods.setAccount(Integer.parseInt(jTextFields[4].getText()));
            goodsOperate.addgoods(goods);
        }
        else{
            dispose();
            new userOperateView();
        }
    }
}
