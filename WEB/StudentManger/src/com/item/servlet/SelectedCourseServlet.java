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
import com.item.dao.SelectedCourseDao;
import com.item.model.Page;
import com.item.model.SelectedCourse;
import com.item.model.Student;
import com.item.model.Teacher;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@WebServlet("/SelectedCourseServlet")
public class SelectedCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("toSelectedCourseListView".equals(method)){
				request.getRequestDispatcher("view/selectedCourseList.jsp").forward(request, response);
		}else if("AddSelectedCourse".equals(method)){
			try {
				addSelectedCourse(request,response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("SelectedCourseList".equals(method)){
			try {
				getSelectedCourseList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DeleteSelectedCourse".equals(method)){
			try {
				deleteSelectedCourse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void deleteSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		SelectedCourse selectedCourse = selectedCourseDao.getSelectedCourse(id);
		String msg = "success";
		if(selectedCourse == null){
			msg = "not found";
			response.getWriter().write(msg);
			return;
		}
		if(selectedCourseDao.deleteSelectedCourse(selectedCourse.getId())){
			CourseDao courseDao = new CourseDao();
			courseDao.updateCourseSelectedNum(selectedCourse.getCourseId(), -1);
		}else{
			msg = "error";
		}
		response.getWriter().write(msg);
	}
	
	private void getSelectedCourseList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int studentId = request.getParameter("studentid") == null ? 0 : Integer.parseInt(request.getParameter("studentid").toString());
		int courseId = request.getParameter("courseid") == null ? 0 : Integer.parseInt(request.getParameter("courseid").toString());
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		SelectedCourse selectedCourse = new SelectedCourse();
		//获取当前登录用户类型
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		if(userType == 2){
			//如果是学生，只能查看自己的信息
			Student currentUser = (Student)request.getSession().getAttribute("user");
			studentId = currentUser.getId();
		}
		selectedCourse.setCourseId(courseId);
		selectedCourse.setStudentId(studentId);
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		List<SelectedCourse> courseList = selectedCourseDao.getSelectedCourseList(selectedCourse, new Page(currentPage, pageSize));
		int total = selectedCourseDao.getSelectedCourseListTotal(selectedCourse);
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", total);
		ret.put("rows", courseList);
			String from = request.getParameter("from");
			if("combox".equals(from)){
				response.getWriter().write(JSONArray.fromObject(courseList).toString());
			}else{
				response.getWriter().write(JSONObject.fromObject(ret).toString());
			}
	}

	private void addSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		int studentId = request.getParameter("studentid") == null ? 0 : Integer.parseInt(request.getParameter("studentid").toString());
		int courseId = request.getParameter("courseid") == null ? 0 : Integer.parseInt(request.getParameter("courseid").toString());
		CourseDao courseDao = new CourseDao();
		String msg = "success";
		if(courseDao.isFull(courseId)){
			msg = "courseFull";
			response.getWriter().write(msg);
			return;
		}
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		if(selectedCourseDao.isSelected(studentId, courseId)){
			msg = "courseSelected";
			response.getWriter().write(msg);
			return;
		}
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setStudentId(studentId);
		selectedCourse.setCourseId(courseId);
		if(selectedCourseDao.addSelectedCourse(selectedCourse)){
			msg = "success";
		}
		courseDao.updateCourseSelectedNum(courseId, 1);
		response.getWriter().write(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
