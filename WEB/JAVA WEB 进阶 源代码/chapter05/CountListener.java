package cn.itcast.chapter05.listener;
import javax.servlet.*;
import javax.servlet.http.*;
public class CountListener implements HttpSessionListener {
	private int count = 0;// 用于统计在线人数
	public void sessionCreated(HttpSessionEvent hse) {
		count++;// session对象创建时count变量加1
		ServletContext context = 
         		hse.getSession().getServletContext();
		context.setAttribute("count", new Integer(count));
	}
	public void sessionDestroyed(HttpSessionEvent hse) {
		count--;// session对象销毁时count变量减1
		ServletContext context = 
         		hse.getSession().getServletContext();
		context.setAttribute("count", new Integer(count));
	}
}
