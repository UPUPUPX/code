package MainProject;

import VIEW.LoginFrame;
import VIEW.SetJScrollPane;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/13 10:11
 */
public class Main {
    public static void main(String[] args){
        LoginFrame window=new LoginFrame();
        window.setVisible(true);

        SetJScrollPane setJScrollPane=new SetJScrollPane();
        setJScrollPane.setVisible(true);
    }
}
