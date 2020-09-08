package View;

import DataService.Data;
import DataService.DataOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.ImageGraphicAttribute;
import java.sql.SQLException;

/**
 * @ClassName AddTextView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/14 20:17
 */
public class AddTextView extends JFrame implements ActionListener {
    JFrame jFrame;
    JPanel jpanel;
    JButton saveButton;
    JButton exitButton;
    JScrollPane jscrollPane;
    Data data=new Data();
    JTextArea jTextArea;
    private String s;
    private int i;

    public AddTextView(int id, String str) {
        super();
        setUndecorated(true);
        jFrame = new JFrame("退出不要点击右上角");
        jFrame.setSize(600, 420);
        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setLocationRelativeTo(null);
        
        final JPanel panel = new JPanel();
        jTextArea = new JTextArea();

        panel.add(jTextArea);
        getContentPane().add(jTextArea);

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);

        jscrollPane = new JScrollPane(jTextArea);
        jpanel = new JPanel();
        jpanel.setLayout(new GridLayout());

        saveButton = new JButton("保存文本");
        saveButton.addActionListener(this::actionPerformed);
        saveButton.setFocusPainted(false);
        jpanel.add(saveButton);

        exitButton = new JButton("退出");
        exitButton.addActionListener(this::actionPerformed);
        exitButton.setFocusPainted(false);
        jpanel.add(exitButton);

        contentPane.add(jscrollPane, BorderLayout.CENTER);
        contentPane.add(jpanel, BorderLayout.SOUTH);

        jFrame.setVisible(true);

        jFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        i=id;
        s=str;
        jFrame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            DataOperator  dataOperator=new DataOperator();
            try {
                data.setId(i);
                data.setSummary(s);
                data.setText(jTextArea.getText());
                dataOperator.Insert(data);
                jFrame.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null, "请选中最后一行后进行添加文本");
            }
        } else {
            jFrame.dispose();
        }
    }
}
