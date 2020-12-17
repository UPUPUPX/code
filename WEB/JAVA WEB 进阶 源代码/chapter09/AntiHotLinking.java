package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;
public class AntiHotLinking extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
         //获取pageContext对象
		PageContext pageContext = (PageContext) this.getJspContext();
         //获取request对象
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
         //获得请求网页的URL
		String referer = request.getHeader("referer");
         //拼写本机的请求消息头
		String serverName = "http://" + request.getServerName();
         //输出访问页面的URL
		System.out.println(referer);
         //判断请求消息头的值不为空且请求头与本机头字段值相同
		if (referer != null && referer.startsWith(serverName)) {
         //执行JSP页面内容
		} else {
			try {
                  //获取响应对象
				HttpServletResponse resp = 
						 (HttpServletResponse) pageContext.getResponse();
                  //将请求重定向到本地资源index.html页面
				resp.sendRedirect("/chapter09/index.html");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
