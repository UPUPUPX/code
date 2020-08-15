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
        JButton deleteButton;
        JButton copyButton;
        JButton saveButton;
        JTextArea jTextArea;
        ClipBoardModel clipBoardModel=new ClipBoardModel();
        Data data=new Data();

        public CheckTextView(int id) {
            super();
            jFrame = new JFrame("查看文本");
            jFrame.setSize(600, 420);
            Container contentPane = jFrame.getContentPane();
            contentPane.setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final JPanel panel = new JPanel();
            jTextArea = new JTextArea();
            JScrollPane jscrollPane=new JScrollPane();

            panel.add(jTextArea);
            getContentPane().add(jTextArea);

            jTextArea = new JTextArea();
            jTextArea.setLineWrap(true);

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

            deleteButton = new JButton("删除文本");
            deleteButton.addActionListener(this::actionPerformed);
            jpanel.add(deleteButton);
            deleteButton.setFocusPainted(false);

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
                jTextArea.setText(dataOperator.Find(id));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            data.setId(id);
            data.setText(jTextArea.getText());
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == deleteButton) {
                DataOperator dataOperator=new DataOperator();
                try {
                    dataOperator.delete(data);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            else if(e.getSource() == copyButton){
                clipBoardModel.setSysClipboardText(jTextArea.getText());
            }
            else{
                DataOperator dataOperator=new DataOperator();
                try {
                    dataOperator.Update(data);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
}
