package View;

import DataService.Data;
import DataService.DataOperator;
import Model.ClipBoardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * @ClassName CheckTextView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 8:06
 */
public class CheckTextView extends JFrame implements ActionListener {
        JFrame jFrame;
        JPanel jpanel;
        JButton copyButton;
        JButton saveButton;
        JButton exitButton;
        JTextArea jTextArea;
        ClipBoardModel clipBoardModel=new ClipBoardModel();
        DataOperator dataOperator=new DataOperator();
        Data data=new Data();

        public CheckTextView(int id) {
            super();
            jFrame = new JFrame("退出时不要点击右上角");
            jFrame.setSize(600, 420);
            Container contentPane = jFrame.getContentPane();
            contentPane.setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLocationRelativeTo(null);
            ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
            jFrame.setIconImage(imageIcon.getImage());

            final JPanel panel = new JPanel();
            jTextArea = new JTextArea();
            JScrollPane jscrollPane=new JScrollPane();

            panel.add(jTextArea);
            getContentPane().add(jTextArea);

            try {
                data=dataOperator.Find(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            jTextArea = new JTextArea();
            if (data!=null){
                jTextArea.setText(data.getText());
                jTextArea.setLineWrap(true);
            }else{
                JOptionPane.showMessageDialog(null, "数据获取失败");
            }

            jscrollPane = new JScrollPane(jTextArea);
            jpanel = new JPanel();
            jpanel.setLayout(new GridLayout());

            copyButton = new JButton("复制文本");
            copyButton.addActionListener(this::actionPerformed);
            jpanel.add(copyButton);
            copyButton.setFocusPainted(false);

            saveButton = new JButton("保存文本");
            saveButton.addActionListener(this::actionPerformed);
            jpanel.add(saveButton);
            saveButton.setFocusPainted(false);

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

            DataOperator dataOperator=new DataOperator();
            try {
                Data data1=dataOperator.Find(id);
                if(data1!=null){
                    jTextArea.setText(dataOperator.Find(id).getText());
                }
                else{
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            data.setId(id);
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == copyButton){
                clipBoardModel.setSysClipboardText(jTextArea.getText());
                jFrame.dispose();
            }
            else if(e.getSource()==exitButton){
                jFrame.dispose();
            }
            else {
                DataOperator dataOperator=new DataOperator();
                try {
                    data.setText(jTextArea.getText());
                    dataOperator.Update(data);
                    jFrame.dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
}
