package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class SimpleIterate extends SimpleTagSupport {
    //�������
	private int num;
    //�ṩnum���Ե�setter����
	public void setNum(int num) {
		this.num = num;
	}
    //�Ա�ǩ�����߼�����
	public void doTag() throws JspException, IOException {
         //��ȡ��ǩ��
         JspFragment jf = this.getJspBody();
        //�Ա�ǩ�����ѭ��ִ��
		for (int i = 0; i < num; i++) {
			jf.invoke(null);
		}
	}
}
