package cn.itcast.chapter04.filter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CharacterFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// �������е����� ���ȫվ��������
		// ָ�� request �� response �ı���
		request.setCharacterEncoding("utf-8"); // ֻ����Ϣ����Ч
		response.setContentType("text/html;charset=utf-8");
		// �ڷ���ʱ Ӧ�ø�Ŀ����Դһ��request���� ��Ŀ����Դ���� 
         // getParameterʱ��������д��getParameter
		// ��request���а�װ
		CharacterRequest characterRequest = new CharacterRequest(request);
		chain.doFilter(characterRequest, response);
	}
	public void destroy() {
	}
}
// ��� request ������а�װ
// �̳� Ĭ�ϰ�װ��HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper {
	public CharacterRequest(HttpServletRequest request) {
		super(request);
	}
	// ����̳и���һ���ḲдһЩ�������˴�������дgetParamter()����
	public String getParameter(String name) {
		// ���� ����װ�����getParameter()���� ����������
		String value = super.getParameter(name);
		if (value == null)
			return null;
		// �ж�����ʽ
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
			     value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		// �������󷵻ؽ��
		return value;
	}
}
