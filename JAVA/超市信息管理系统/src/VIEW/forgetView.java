package VIEW;

import DAO.User;
import Model.listModel;
import Service.UserOperator;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName forgetView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/23 22:08
 */
public class forgetView extends JFrame implements ActionListener {
    JLabel name;
    JLabel question;
    JLabel answer;
    JLabel pass;
    JTextField inname;
    JComboBox jComboBox;
    JTextField inanswer;
    JPasswordField inpass;
    JButton commit;
    JButton exit;
    public Color bluegreen =new Color(0,127,127);
    public forgetView(){
        getContentPane().setLayout(null);
        setBounds(10,10,720,600);
        setTitle("忘记密码");
        setVisible(true);
        name=new JLabel("用户名");
        name.setBounds(50,50,120,50);
        name.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(name);
        inname=new JTextField();
        inname.setBounds(190,50,375,50);
        inname.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(inname);
        question=new JLabel("问题");
        question.setBounds(50,150,120,50);
        question.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(question);
        jComboBox =new JComboBox(new listModel());
        jComboBox.setBounds(190,150, 375, 50);
        jComboBox.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(jComboBox);
        answer=new JLabel("答案");
        answer.setBounds(50,250,120,50);
        answer.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(answer);
        inanswer=new JTextField();
        inanswer.setBounds(190,250,375,50);
        inanswer.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(inanswer);
        pass=new JLabel("新密码");
        pass.setBounds(50,350,120,50);
        pass.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(pass);
        inpass=new JPasswordField();
        inpass.setBounds(190,350,375,50);
        inpass.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(inpass);
        commit=new JButton("提交");
        commit.setBounds(50,450,150,50);
        commit.setBackground(bluegreen);
        commit.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(commit);
        exit=new JButton("取消");
        exit.setBounds(410,450,150,50);
        exit.setBackground(bluegreen);
        exit.setFont(new Font("宋体",Font.BOLD,36));
        getContentPane().add(exit);
        commit.addActionListener(this);
        exit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==commit){
            UserOperator userOperator=new UserOperator();
            User user=new User();
            user.setName(inname.getText());
            user.setPass(String.valueOf(inpass.getPassword()));
            user.setQuestion(String.valueOf(jComboBox.getSelectedItem()));
            user.setAnswer(inanswer.getText());
            try {
                User u=userOperator.FindUser(inname.getText());
                if (u!=null){
                    if (user.getQuestion().equals(u.getQuestion())&&user.getAnswer().equals(u.getAnswer())){
                        u.setPass(user.getPass());
                        userOperator.Update(u);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            dispose();
            new mainView();
        }
    }
}
