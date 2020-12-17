package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import cn.itcast.chapter09.domain.User;
public class Showtime extends SimpleTagSupport {
    //定义user属性
	private User user;
    //提供setter方法
	public void setUser(User user) {
		this.user = user;
	}
	public void doTag() throws JspException {
         //获取pageContext对象
		PageContext pageContext = (PageContext) this.getJspContext();
         //获取out对象
		JspWriter out = pageContext.getOut();
		try {//输出用户名
			out.write("当前用户的名字:" + user.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
