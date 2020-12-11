package VIEW;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class purchaseView extends JFrame implements ActionListener{
    private JLabel dealid;
    private JLabel dealname;
    private JLabel dealgoodid;
    private JLabel dealcount;
    private JLabel dealgoodname;
    private JLabel producetime;
    private JLabel deadline;
    private JTextField tdealid;
    private JTextField tdealname;
    private JTextField tdealgoodid;
    private JTextField tdealcount;
    private JTextField tdealgoodname;
    private JTextField tproducetime;
    private JTextField tdeadline;
    private JButton save;
    private JButton exit;
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public int windowsWedth =800;
    public int windowsHeight = 600;
    public purchaseView(){
        getContentPane().setLayout(null);
        this.setTitle("进货管理");
        this.setVisible(true);
        int x = (width - windowsWedth) / 2;
        int y = (height - windowsHeight) / 2;
        this.setBounds(x, y, windowsWedth, windowsHeight);
        dealid = new JLabel("供货商编号:");
        dealid.setFont(new Font("", Font.BOLD, 30));
        dealid.setBounds(100, 10, 200, 30);
        tdealid=new JTextField();
        tdealid.setBounds(302,10,300,30);
        dealname = new JLabel("供货商名称:");
        dealname.setBounds(100, 60, 200, 30);
        dealname.setFont(new Font("", Font.BOLD, 30));
        tdealname=new JTextField();
        tdealname.setBounds(302,60,300,30);
        dealgoodid = new JLabel("商品编号:");
        dealgoodid.setBounds(100, 110, 200, 30);
        dealgoodid.setFont(new Font("", Font.BOLD, 30));
        tdealgoodid=new JTextField();
        tdealgoodid.setBounds(302,110,300,30);
        dealcount=new JLabel("商品数量:");
        dealcount.setBounds(100,160,200,30);
        dealcount.setFont(new Font("",Font.BOLD,30));
        tdealcount=new JTextField();
        tdealcount.setBounds(302,160,300,30);
        dealgoodname=new JLabel("商品名称:");
        dealgoodname.setBounds(100,210,200,30);
        dealgoodname.setFont(new Font("",Font.BOLD,30));
        tdealgoodname=new JTextField();
        tdealgoodname.setBounds(302,210,300,30);
        producetime=new JLabel("生产日期:");
        producetime.setBounds(100,260,200,30);
        producetime.setFont(new Font("",Font.BOLD,30));
        tproducetime=new JTextField();
        tproducetime.setBounds(302,260,300,30);
        deadline=new JLabel("有效日期:");
        deadline.setBounds(100,310,200,30);
        deadline.setFont(new Font("",Font.BOLD,30));
        tdeadline=new JTextField();
        tdeadline.setBounds(302,310,300,30);
        save = new JButton("保存");
        save.setBounds(500, 500, 200, 40);
        save.setFont(new Font("", Font.BOLD, 30));
        save.addActionListener((ActionListener) this);
        save.setBackground(new Color(0,127,127));
        exit = new JButton("退出");
        exit.setBounds(100, 500, 200, 40);
        exit.setFont(new Font("", Font.BOLD, 30));
        exit.addActionListener((ActionListener) this);
        exit.setBackground(new Color(0,127,127));
        getContentPane().add(dealgoodname);
        getContentPane().add(dealname);
        getContentPane().add(dealcount);
        getContentPane().add(dealgoodid);
        getContentPane().add(dealid);
        getContentPane().add(producetime);
        getContentPane().add(deadline);
        getContentPane().add(save);
        getContentPane().add(exit);
        getContentPane().add(tdealgoodname);
        getContentPane().add(tdealname);
        getContentPane().add(tdeadline);
        getContentPane().add(tdealcount);
        getContentPane().add(tdealgoodid);
        getContentPane().add(tdealid);
        getContentPane().add(tproducetime);

        setVisible(true);
    }

    public static void main(String[] args) {
        new purchaseView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
