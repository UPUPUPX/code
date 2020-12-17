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

import com.item.dao.CourseDao;
import com.item.model.Course;
import com.item.model.Page;
import com.item.model.Student;
import com.item.model.Teacher;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException 
	 * @throws Throwable 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		if("toCourseListView".equals(method)){
			try {
				request.getRequestDispatcher("view/courseList.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("AddCourse".equals(method)){
				try {
					addCourse(request,response);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if("CourseList".equals(method)){
			try {
				getCourseList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("EditCourse".equals(method)){
			try {
				editCourse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DeleteCourse".equals(method)){
			try {
				deleteCourse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String[] ids = request.getParameterValues("ids[]");
		String idStr = "";
		for(String id : ids){
			idStr += id + ",";
		}
		idStr = idStr.substring(0, idStr.length()-1);
		CourseDao courseDao = new CourseDao();
		if(courseDao.deleteCourse(idStr)){
			response.getWriter().write("success");	
		}
		
	}

	private void editCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int teacherId = Integer.parseInt(request.getParameter("teacherid").toString());
		int maxNum = Integer.parseInt(request.getParameter("maxnum").toString());
		int id = Integer.parseInt(request.getParameter("id").toString());
		String courseDate = request.getParameter("courseDate");
		String info = request.getParameter("info");
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setTeacherId(teacherId);
		course.setInfo(info);
		course.setCourseDate(courseDate);
		course.setMaxNum(maxNum);
		CourseDao courseDao = new CourseDao();
		String msg = "error";
		if(courseDao.editCourse(course)){
			msg = "success";
		}
		response.getWriter().write(msg);
	}

	private void getCourseList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int teacherId = request.getParameter("teacherid") == null ? 0 : Integer.parseInt(request.getParameter("teacherid").toString());
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		Course course = new Course();
		course.setName(name);
		course.setTeacherId(teacherId);
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(course, new Page(currentPage, pageSize));
		int total = courseDao.getCourseListTotal(course);
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", total);
		ret.put("rows", courseList);
		try {
			String from = request.getParameter("from");
			if("combox".equals(from)){
				response.getWriter().write(JSONArray.fromObject(courseList).toString());
			}else{
				response.getWriter().write(JSONObject.fromObject(ret).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int teacherId = Integer.parseInt(request.getParameter("teacherid").toString());
		int maxNum = Integer.parseInt(request.getParameter("maxnum").toString());
		String courseDate = request.getParameter("course_date");
		String info = request.getParameter("info");
		Course course = new Course();
		course.setName(name);
		course.setTeacherId(teacherId);
		course.setInfo(info);
		course.setMaxNum(maxNum);
		course.setCourseDate(courseDate);
		CourseDao courseDao = new CourseDao();
		String msg = "error";
		if(courseDao.addCourse(course)){
			msg = "success";
		}
		response.getWriter().print(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
