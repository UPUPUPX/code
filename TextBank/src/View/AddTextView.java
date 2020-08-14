package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    private JTextArea jTextArea;

    public AddTextView() {
        super();
        jFrame = new JFrame("请输入要保存的文本");
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

        saveButton = new JButton("保存文本");
        saveButton.addActionListener(this::actionPerformed);

        jpanel.add(saveButton);

        contentPane.add(jscrollPane, BorderLayout.CENTER);
        contentPane.add(jpanel, BorderLayout.SOUTH);

        jFrame.setVisible(true);

        jFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {

        } else {
        }
    }

    public static void main(String[] args) {
        new AddTextView();
    }

}
