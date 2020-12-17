package com.item.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.dao.StudentDao;
import com.item.model.Page;
import com.item.model.Student;
import com.item.utiles.SnGenerateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 学生信息管理功能实现servlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
//		System.out.println(method);
		if(method.equals("toStudentListView")) {
			studentList(request,response);
		}else if(method.equals("AddStudent")) {
			try {
				addStudent(request,response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("StudentList".equals(method)) {
			try {
				getStudentList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("EditStudent".equals(method)) {
			try {
				editStudent(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DeleteStudent".equals(method)) {
			try {
				deleteStudent(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String[] ids = request.getParameterValues("ids[]");
		String idStr = "";
		for(String id : ids){
			idStr += id + ",";
		}
		idStr = idStr.substring(0, idStr.length()-1);
		StudentDao studentDao = new StudentDao();
		if(studentDao.deleteStudent(idStr)) {
			response.getWriter().write("success");
		}else {
			response.getWriter().write("error");
		}
	}
	private void editStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String qq = request.getParameter("qq");
		int clazzId = Integer.parseInt(request.getParameter("clazzid"));
		Student student = new Student();
		student.setClazzId(clazzId);
		student.setMobile(mobile);
		student.setName(name);
		student.setId(id);
		student.setQq(qq);
		student.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.editStudent(student)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void getStudentList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
		String name = request.getParameter("studentName");
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		Integer clazz = request.getParameter("clazzid") == null ? 0 : Integer.parseInt(request.getParameter("clazzid"));
		Student student = new Student();
		student.setName(name);
		student.setClazzId(clazz);
		//获取当前登录用户类型
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		if(userType == 2){
			//如果是学生，只能查看自己的信息
			Student currentUser = (Student)request.getSession().getAttribute("user");
			student.setId(currentUser.getId());
		}
		StudentDao studentDao = new StudentDao();
		List<Student> clazzList = studentDao.getStudentList(student, new Page(currentPage, pageSize));
		int total = studentDao.getStudentListTotal(student);
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", total);
		ret.put("rows", clazzList);
		String from = request.getParameter("from");
		if("combox".equals(from)){
			response.getWriter().write(JSONArray.fromObject(clazzList).toString());
		}else{
			response.getWriter().write(JSONObject.fromObject(ret).toString());
		}
	}
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		String qq = request.getParameter("qq");
		int clazzId = Integer.parseInt(request.getParameter("clazzid"));
		Student stu=new Student();
		stu.setClazzId(clazzId);
		stu.setMobile(mobile);
		stu.setPassword(password);
		stu.setName(name);
		stu.setQq(qq);
		stu.setSex(sex);
		stu.setSn(SnGenerateUtil.generateSn(clazzId));
		StudentDao studao=new StudentDao();
		if(studao.addStuden(stu)) {
			response.getWriter().print("success");
		}
	}
	/**
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void studentList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//response.getWriter().print("hello");
		request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);
	}

}
