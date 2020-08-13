package VIEW;

import GetContent.GetContentFromClipboard;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName AddJtextField
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/13 17:28
 */
public class AddJtextField extends JFrame implements ActionListener {
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void Add() {
        String str;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lab1 = new JLabel();
        lab1.setBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        lab1.setFont(new Font("", Font.BOLD, 36));
        GetContentFromClipboard getContentFromClipboard = new GetContentFromClipboard();
        str = getContentFromClipboard.getClipboard();
        setFlag(str);
        lab1.setText(str);
        lab1.setSize(460, 72);
        getContentPane().add(lab1);

        JButton copy = new JButton("复制");
        JButton delete = new JButton("删除");

        copy = new JButton("复制");
        copy.setText("复制");
        copy.setSize(40, 46);
        getContentPane().add(copy, BorderLayout.BEFORE_LINE_BEGINS);

        delete = new JButton("删除");
        delete.setText("删除");
        delete.setSize(40, 46);
        getContentPane().add(delete, BorderLayout.AFTER_LINE_ENDS);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == "copy") {
            GetContentFromClipboard getContentFromClipboard = new GetContentFromClipboard();
            getContentFromClipboard.setSysClipboardText(getFlag());
        } else {
           /* try {
                Connection con=DbUtil.getCon();

                if(currentuserUser!=null)
                {
                    MainFrame mainFrame=new MainFrame();
                    mainFrame.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "�û������������");
                }
            } catch (Exception p) {
                p.printStackTrace();
            }*/
        }

    }
}