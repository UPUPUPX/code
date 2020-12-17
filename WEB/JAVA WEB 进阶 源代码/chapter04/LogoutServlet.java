package cn.itcast.chapter04.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
     HttpServletResponse response)throws ServletException, IOException {
		// �û�ע��
		request.getSession().removeAttribute("user");
		// �ӿͻ���ɾ���Զ���¼��cookie
		Cookie cookie = new Cookie("autologin", "msg");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		response.sendRedirect(request.getContextPath()+"/index.jsp"); 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse 
     		response)throws ServletException, IOException {
		doGet(request, response);
	}
}
