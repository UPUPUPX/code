package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import cn.itcast.chapter09.domain.User;
public class Showtime extends SimpleTagSupport {
    //����user����
	private User user;
    //�ṩsetter����
	public void setUser(User user) {
		this.user = user;
	}
	public void doTag() throws JspException {
         //��ȡpageContext����
		PageContext pageContext = (PageContext) this.getJspContext();
         //��ȡout����
		JspWriter out = pageContext.getOut();
		try {//����û���
			out.write("��ǰ�û�������:" + user.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
