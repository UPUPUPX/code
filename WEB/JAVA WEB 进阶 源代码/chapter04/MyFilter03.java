package cn.itcast.chapter04.filter;
import java.io.*;
import javax.servlet.*;
public class MyFilter03 implements Filter {
	private String characterEncoding;
	FilterConfig fc;
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ���������Ϣ
		characterEncoding=fc.getInitParameter("encoding");
		System.out.println("encoding��ʼ��������ֵΪ��"+characterEncoding);
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// ��ȡFilterConfig����
		this.fc = fConfig;
	}
}
