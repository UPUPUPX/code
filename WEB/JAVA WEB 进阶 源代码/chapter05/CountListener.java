package cn.itcast.chapter05.listener;
import javax.servlet.*;
import javax.servlet.http.*;
public class CountListener implements HttpSessionListener {
	private int count = 0;// ����ͳ����������
	public void sessionCreated(HttpSessionEvent hse) {
		count++;// session���󴴽�ʱcount������1
		ServletContext context = 
         		hse.getSession().getServletContext();
		context.setAttribute("count", new Integer(count));
	}
	public void sessionDestroyed(HttpSessionEvent hse) {
		count--;// session��������ʱcount������1
		ServletContext context = 
         		hse.getSession().getServletContext();
		context.setAttribute("count", new Integer(count));
	}
}
