package cn.itcast.chapter05.listener;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyAttributeListener implements 
ServletContextAttributeListener,HttpSessionAttributeListener,       
ServletRequestAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent sae) {
		String name = sae.getName();
		System.out.println("ServletContext������ԣ�" + name + "="
				+ sae.getServletContext().getAttribute(name));
	}
	public void attributeRemoved(ServletContextAttributeEvent sae) 
     {
		String name = sae.getName();
		System.out.println("ServletContext�Ƴ�����: " + name);
	}
	public void attributeReplaced(ServletContextAttributeEvent sae) 
     {
		String name = sae.getName();
		System.out.println("ServletContext�滻���ԣ�" + name + "="
				+ sae.getServletContext().getAttribute(name));
	}
	public void attributeAdded(HttpSessionBindingEvent hbe) {
		String name = hbe.getName();
		System.out.println("HttpSession������ԣ�" + name + "="
				+ hbe.getSession().getAttribute(name));
	}
	public void attributeRemoved(HttpSessionBindingEvent hbe) {
		String name = hbe.getName();
		System.out.println("HttpSession�Ƴ�����: " + name);
	}
	public void attributeReplaced(HttpSessionBindingEvent hbe) {
		String name = hbe.getName();
		System.out.println("HttpSession�滻���ԣ�" + name + "="
				+ hbe.getSession().getAttribute(name));
	}
	public void attributeAdded(ServletRequestAttributeEvent sra) {
		String name = sra.getName();
		System.out.println("ServletRequest������ԣ�" + name + "="
				+ sra.getServletRequest().getAttribute(name));
	}
	public void attributeRemoved(ServletRequestAttributeEvent sra) 
    {
		String name = sra.getName();
		System.out.println("ServletRequest�Ƴ�����: " + name);
	}
	public void attributeReplaced(ServletRequestAttributeEvent sra) 
    {
		String name = sra.getName();
		System.out.println("ServletRequest�滻���ԣ�" + name + "="
				+ sra.getServletRequest().getAttribute(name));
	}
}
