package VIEW;

import GetContent.GetContentFromClipboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName SetJScrollPane
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/13 15:52
 */
public class SetJScrollPane extends JFrame{

        private JPanel contentPane;
        private JScrollPane scrollPane;
        private JTextArea textArea;
        /*JButton copy = new JButton("复制");
        JButton delete = new JButton("删除");*/

        public void SetJScrollPane(){
            contentPane=new JPanel();
            contentPane.setBorder(new EmptyBorder(5,5,5,5));
            contentPane.setLayout(new BorderLayout(0,0));
            this.setContentPane(contentPane);
            scrollPane=new JScrollPane();
            contentPane.add(scrollPane, BorderLayout.CENTER);
            textArea=new JTextArea();
            //scrollPane.add(textArea);
            scrollPane.setViewportView(textArea);
            this.setTitle("剪切板");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setBounds(200, 200, 540, 420);
            this.setVisible(true);

            /*copy= new JButton("复制");
            copy.setText("复制");
            copy.setSize(40, 46);
            contentPane.add(copy,BorderLayout.BEFORE_LINE_BEGINS);

            delete= new JButton("删除");
            delete.setText("删除");
            delete.setSize(40, 46);
            contentPane.add(delete,BorderLayout.AFTER_LINE_ENDS);*/

            /*copy.addActionListener(this);
            delete.addActionListener(this);*/

            /*scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);*/
        }
        public static void main(String []args){
           SetJScrollPane setJScrollPane=new SetJScrollPane();
           setJScrollPane.SetJScrollPane();
        }

   /* @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copy) {
            String str=" ";
            GetContentFromClipboard getContentFromClipboard=new GetContentFromClipboard();
            getContentFromClipboard.setSysClipboardText(str);
        }
        else {*/
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
  /*      }
    }*/
}

