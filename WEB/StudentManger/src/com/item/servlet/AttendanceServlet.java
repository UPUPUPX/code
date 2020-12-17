package com.item.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.dao.AttendanceDao;
import com.item.dao.CourseDao;
import com.item.dao.LeaveDao;
import com.item.dao.SelectedCourseDao;
import com.item.model.Attendance;
import com.item.model.Course;
import com.item.model.Page;
import com.item.model.SelectedCourse;
import com.item.model.Student;
import com.item.utiles.DateFormatUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("toAttendanceServletListView".equals(method)){
				request.getRequestDispatcher("view/attendanceList.jsp").forward(request, response);
		}else if("AddAttendance".equals(method)){
			try {
				AddAttendance(request,response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("AttendanceList".equals(method)){
			try {
				attendanceList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DeleteAttendance".equals(method)){
			try {
				deleteAttendance(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getStudentSelectedCourseList".equals(method)){
			try {
				getStudentSelectedCourseList(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getStudentSelectedCourseList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		int studentId = request.getParameter("student_id") == null ? 0 : Integer.parseInt(request.getParameter("student_id").toString());
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setStudentId(studentId);
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		List<SelectedCourse> selectedCourseList = selectedCourseDao.getSelectedCourseList(selectedCourse, new Page(1, 999));
		String courseId = "";
		for(SelectedCourse sc : selectedCourseList){
			courseId += sc.getCourseId()+ ",";
		}
		if(courseId.length()>0) {//有学生没有选修课程，因此length=0，需要特殊处理
			courseId = courseId.substring(0,courseId.length()-1);
		}
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourse(courseId);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(JSONArray.fromObject(courseList).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteAttendance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		AttendanceDao attendanceDao = new AttendanceDao();
		String msg = "success";
		if(!attendanceDao.deleteAttendance(id)){
			msg = "error";
		}
		response.getWriter().write(msg);
	}

	private void attendanceList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int studentId = request.getParameter("studentid") == null ? 0 : Integer.parseInt(request.getParameter("studentid").toString());
		int courseId = request.getParameter("courseid") == null ? 0 : Integer.parseInt(request.getParameter("courseid").toString());
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		Attendance attendance = new Attendance();
		//获取当前登录用户类型
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		if(userType == 2){
			//如果是学生，只能查看自己的信息
			Student currentUser = (Student)request.getSession().getAttribute("user");
			studentId = currentUser.getId();
		}
		attendance.setCourseId(courseId);
		attendance.setStudentId(studentId);
		attendance.setDate(date);
		attendance.setType(type);
		AttendanceDao attendanceDao = new AttendanceDao();
		List<Attendance> attendanceList = attendanceDao.getSelectedCourseList(attendance, new Page(currentPage, pageSize));
		int total = attendanceDao.getAttendanceListTotal(attendance);
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", total);
		ret.put("rows", attendanceList);
			String from = request.getParameter("from");
			if("combox".equals(from)){
				response.getWriter().write(JSONArray.fromObject(attendanceList).toString());
			}else{
				response.getWriter().write(JSONObject.fromObject(ret).toString());
			}
	}

	private void AddAttendance(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		int studentId = request.getParameter("studentid") == null ? 0 : Integer.parseInt(request.getParameter("studentid").toString());
		int courseId = request.getParameter("courseid") == null ? 0 : Integer.parseInt(request.getParameter("courseid").toString());
		String type = request.getParameter("type").toString();
		AttendanceDao attendanceDao = new AttendanceDao();
		Attendance attendance = new Attendance();
		attendance.setCourseId(courseId);
		attendance.setStudentId(studentId);
		attendance.setType(type);
		attendance.setDate(DateFormatUtil.getFormatDate(new Date(), "yyyy-MM-dd"));
		String msg = "success";
		response.setCharacterEncoding("UTF-8");
		if(attendanceDao.isAttendanced(studentId, courseId, type,DateFormatUtil.getFormatDate(new Date(), "yyyy-MM-dd"))){
			msg = "已签到，请勿重复签到！";
		}else if(!attendanceDao.addAttendance(attendance)){
			msg = "系统内部出错。请联系管理员！";
		}
		response.getWriter().write(msg);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
