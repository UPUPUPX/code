package cn.itcast.chapter04.filter;
import java.io.*;
import javax.servlet.*;
public class FilterTest implements Filter {
	public void destroy() {
		// ����������������ʱ�Զ����ã��ͷ���Դ
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ���������û�����������͵�ǰ������������·��ƥ�䣬�÷����ᱻ����
		PrintWriter out=response.getWriter();
		out.write("Hello FilterTest");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// �����������ڳ�ʼ��ʱ���ã���������һЩ��ʼ������
     }
}
