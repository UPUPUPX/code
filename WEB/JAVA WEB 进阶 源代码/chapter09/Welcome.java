package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class Welcome extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
         //获取pageContext对象
		PageContext pageContext = (PageContext) this.getJspContext();
         //获取session中名称为user的属性
         String name = (String)pageContext .getSession()
				.getAttribute("user");
         //判断name是否为空，不为空则执行标签体内容
		if (name != null) {
			this.getJspBody().invoke(null);
		} 
	}
}
