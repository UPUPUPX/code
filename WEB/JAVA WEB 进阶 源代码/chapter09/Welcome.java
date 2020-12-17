package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class Welcome extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
         //��ȡpageContext����
		PageContext pageContext = (PageContext) this.getJspContext();
         //��ȡsession������Ϊuser������
         String name = (String)pageContext .getSession()
				.getAttribute("user");
         //�ж�name�Ƿ�Ϊ�գ���Ϊ����ִ�б�ǩ������
		if (name != null) {
			this.getJspBody().invoke(null);
		} 
	}
}
