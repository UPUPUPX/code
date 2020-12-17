package com.item.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.dao.AdminDao;
import com.item.dao.StudentDao;
import com.item.dao.TeacherDao;
import com.item.model.Admin;
import com.item.model.Student;
import com.item.model.Teacher;

/**
 * Servlet implementation class SystemServlet
 */
@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if ("toPersonalView".equals(method)) {
			personalView(request, response);
			return;
		} else if ("EditPasswod".equals(method)) {
			try {
				editPassword(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		request.getRequestDispatcher("view/system.jsp").forward(request, response);
	}

	private void editPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newpassword");
		response.setCharacterEncoding("UTF-8");
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		if (userType == 1) {
			// 管理员
			Admin admin = (Admin) request.getSession().getAttribute("user");
			if (!admin.getPassword().equals(password)) {
				response.getWriter().write("原密码错误！");
				return ;
			}
			AdminDao adminDao = new AdminDao();
			if (adminDao.editPassword(admin, newPassword)) {
				response.getWriter().write("success");
			} else {
				response.getWriter().write("数据库修改错误");
			}
		}
		if(userType == 2){
			//学生
			Student student = (Student)request.getSession().getAttribute("user");
			if(!student.getPassword().equals(password)){
					response.getWriter().write("原密码错误！");
					return;
			}
			StudentDao studentDao = new StudentDao();
			if(studentDao.editPassword(student, newPassword)){
					response.getWriter().write("success");
			}else{
					response.getWriter().write("数据库修改错误");
			}
		}
		if(userType == 3){
			//教师
			Teacher teacher = (Teacher)request.getSession().getAttribute("user");
			if(!teacher.getPassword().equals(password)){
					response.getWriter().write("原密码错误！");
					return;
			}
			TeacherDao teacherDao = new TeacherDao();
			if(teacherDao.editPassword(teacher, newPassword)){
					response.getWriter().write("success");
			}else{
					response.getWriter().write("数据库修改错误");
			}
		}
	}

	private void personalView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/personalView.jsp").forward(request, response);
	}

	/**
	 * @see
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
