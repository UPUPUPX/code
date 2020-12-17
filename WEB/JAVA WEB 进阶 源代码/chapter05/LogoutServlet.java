package cn.itcast.chapter05.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.itcast.chapter05.entity.*;
public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
             HttpServletResponse response)
	        throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		Map users = OnlineUser.getInstance().getOnlineUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/showuser.jsp").
		forward(request, response);
	}
	public void doPost(HttpServletRequest request, 
     HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
}
