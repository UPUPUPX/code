package cn.itcast.chapter04.filter;
import java.io.*;
import javax.servlet.*;
public class MyFilter01 implements Filter {
	public void destroy() {
		// ����������������ʱ�Զ����ã��ͷ���Դ
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ���������û�����������͵�ǰ������������·��ƥ�䣬�÷����ᱻ����
		PrintWriter out=response.getWriter();
		out.write("Hello MyFilter01</br>");
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// �����������ڳ�ʼ��ʱ���ã���������һЩ��ʼ������
	}
}
