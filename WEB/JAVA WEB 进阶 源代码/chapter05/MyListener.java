package cn.itcast.chapter05.listener;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyListener implements ServletContextListener,
 HttpSessionListener, ServletRequestListener {
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext���󱻴�����");
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext����������");
	}
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("ServletRequest���󱻴�����");
	}
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("ServletRequest����������");
	}
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("HttpSession���󱻴�����");
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("HttpSession����������");
	}
}
