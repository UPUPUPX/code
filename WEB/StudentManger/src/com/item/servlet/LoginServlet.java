package com.item.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.item.dao.AdminDao;
import com.item.dao.StudentDao;
import com.item.dao.TeacherDao;
import com.item.model.Admin;
import com.item.model.Student;
import com.item.model.Teacher;
import com.item.utiles.StringUtiles;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if(method.equals("LoginOut")) {
			LoginOut(request,response);
			return ;
		}
		String vcode = request.getParameter("vcode");
		String name=request.getParameter("account");
		String password = request.getParameter("password");
		String logincode=request.getSession().getAttribute("checkcode").toString();
		//判断验证码是否为空或者""，还有一种必须和图片上的验证码一致
		if(StringUtiles.isEmpty(vcode)||!logincode.equalsIgnoreCase(vcode)) {
			response.getWriter().write("vcodeError");
			return ;
		}
		//验证码验证通过，对比用户名和密码是否正确
		int type=Integer.parseInt(request.getParameter("type"));
		String loginStatus = "loginFaild";
		switch (type) {
			case 1:{
				AdminDao admindao=new AdminDao();
				Admin admin=new Admin();
				admin.setName(name);
				admin.setPassword(password);
				try {
					Admin admin_res=admindao.login(admin);
					if(admin_res==null) {
						response.getWriter().write("loginError");
						return ;
					}
					HttpSession session=request.getSession();
					session.setAttribute("user", admin);
					session.setAttribute("userType", type);
					loginStatus = "loginSuccess";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 2:{
				StudentDao studentDao = new StudentDao();
				Student student=null;
				try {
					student = studentDao.login(name, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(student == null){
					response.getWriter().write("loginError");
					return;
				}
				HttpSession session = request.getSession();
				session.setAttribute("user", student);
				session.setAttribute("userType", type);
				loginStatus = "loginSuccess";
				break;
			}
			case 3:{
				TeacherDao teahcerDao = new TeacherDao();
				Teacher teacher=null;
				try {
					teacher = teahcerDao.login(name, password);
					if(teacher == null){
						response.getWriter().write("loginError");
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				session.setAttribute("user", teacher);
				session.setAttribute("userType", type);
				loginStatus = "loginSuccess";
				break;
			}
		default:
			break;
		}
		response.getWriter().write(loginStatus);
	}

	private void LoginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("userType");
		response.sendRedirect("index.jsp");
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
