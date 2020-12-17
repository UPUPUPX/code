package cn.itcast.chapter04.filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.itcast.chapter04.entity.User;
public class AutoLoginFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		// ���һ����Ϊ autologin ��cookie
		Cookie[] cookies = request.getCookies();
		String autologin = null;
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("autologin".equals(cookies[i].getName())) {
				// �ҵ���ָ����cookie
				autologin = cookies[i].getValue();
				break;
			}
		}
		if (autologin != null) {
			// ���Զ���¼
			String[] parts = autologin.split("-");
			String username = parts[0];
			String password = parts[1];
			// ����û���������
		    if ("itcast".equals(username)&& ("123456").equals(password)) {
				// ��¼�ɹ�,���û�״̬ user ������� session��
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				request.getSession().setAttribute("user", user);
			}
		}
		// ����
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
