package cn.itcast.chapter07.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse 
    			response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String message = request.getParameter("message");
	    request.setAttribute("name", name);
	    request.setAttribute("message", message);
	    request.getRequestDispatcher("/result.jsp")
				.forward(request, response);
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse 
    			response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
