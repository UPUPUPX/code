package cn.itcast.chapter04.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.itcast.chapter04.entity.User;
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
    				response)throws ServletException, IOException {
		// ����û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ����û���������
		if ("itcast".equals(username) && "123456".equals(password)) {
			// ��¼�ɹ�
			// ���û�״̬ user ������� session��
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			// �����Զ���¼��cookie
			String autoLogin = request.getParameter("autologin");
			if (autoLogin != null) {
				// ע�� cookie �е�����Ҫ����
				Cookie cookie = new Cookie("autologin", username + "-"
						+ password);
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			// ��ת����ҳ
         		response.sendRedirect(request.getContextPath()+
					"/index.jsp");
		} else {
			request.setAttribute("errerMsg", "�û����������");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}
	public void doPost(HttpServletRequest request, 
    HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
