package cn.itcast.chapter05.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.itcast.chapter05.entity.*;
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
    			HttpServletResponse response) throws ServletException, 
     		IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && !username.trim().equals("")) {
			// 登录成功
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			Map users = OnlineUser.getInstance().getOnlineUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/showuser.jsp").
              forward(request, response);
		} else {
			request.setAttribute("errorMsg", "用户名或密码错");
			request.getRequestDispatcher("/login.jsp").
           	forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request, 
     		HttpServletResponse response) throws ServletException, 
     		IOException {
		doGet(request, response);
	}
}
