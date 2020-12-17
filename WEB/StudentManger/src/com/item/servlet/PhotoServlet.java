package com.item.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.item.dao.StudentDao;
import com.item.model.Student;
import com.lizhou.exception.FileFormatException;
import com.lizhou.exception.NullFileException;
import com.lizhou.exception.ProtocolException;
import com.lizhou.exception.SizeException;
import com.lizhou.fileload.FileUpload;

/**
 * Servlet implementation class PhotoServlet
 */
@WebServlet("/PhotoServlet")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if("getPhoto".equals(method)) {
			try {
				try {
					getPhoto(request,response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("SetPhoto".equals(method)){
			try {
				uploadPhoto(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	private void uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//		int sid = request.getParameter("sid") == null ? 0 : Integer.parseInt(request.getParameter("sid"));
//		int tid = request.getParameter("tid") == null ? 0 : Integer.parseInt(request.getParameter("tid"));
//		FileUpload fileUpload = new FileUpload(request);
//		fileUpload.setFileFormat("jpg");
//		fileUpload.setFileFormat("png");
//		fileUpload.setFileFormat("jpeg");
//		fileUpload.setFileFormat("gif");
//		fileUpload.setFileSize(2048);
//		response.setCharacterEncoding("UTF-8");
//		try {
//			InputStream uploadInputStream = fileUpload.getUploadInputStream();
//			if(sid != 0){
//				Student student = new Student();
//				student.setId(sid);
//				student.setPhoto(uploadInputStream);
//				StudentDao studentDao = new StudentDao();
//				if(studentDao.setStudentPhoto(student)){
//					response.getWriter().write("<div id='message'>上传成功！</div>");
//				}else{
//					response.getWriter().write("<div id='message'>上传失败！</div>");
//				}
//			}
//		} catch (ProtocolException e) {
//			// TODO Auto-generated catch block
//			try {
//				response.getWriter().write("<div id='message'>上传协议错误！</div>");
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}catch (NullFileException e1) {
//			// TODO: handle exception
//			try {
//				response.getWriter().write("<div id='message'>上传的文件为空!</div>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			e1.printStackTrace();
//		}
//		catch (SizeException e2) {
//			// TODO: handle exception
//			try {
//				response.getWriter().write("<div id='message'>上传文件大小不能超过"+fileUpload.getFileSize()+"！</div>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			e2.printStackTrace();
//		}
//		catch (IOException e3) {
//			// TODO: handle exception
//			try {
//				response.getWriter().write("<div id='message'>读取文件出错！</div>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			e3.printStackTrace();
//		}
//		catch (FileFormatException e4) {
//			// TODO: handle exception
//			try {
//				response.getWriter().write("<div id='message'>上传文件格式不正确，请上传 "+fileUpload.getFileFormat()+" 格式的文件！</div>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			e4.printStackTrace();
//		}
//		catch (FileUploadException e5) {
//			// TODO: handle exception
//			try {
//				response.getWriter().write("<div id='message'>上传文件失败！</div>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			e5.printStackTrace();
//		}
//	}

	private void getPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
		int sid = request.getParameter("sid") == null ? 0 : Integer.parseInt(request.getParameter("sid"));
		int tid = request.getParameter("tid") == null ? 0 : Integer.parseInt(request.getParameter("tid"));
		if(sid != 0){
			//学生
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.getStudent(sid);
			if(student != null){
				InputStream photo = student.getPhoto();
				if(photo != null){
					try {
						byte[] b = new byte[photo.available()];
						photo.read(b);
						response.getOutputStream().write(b,0,b.length);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
			}
		}
		
		
		String path = request.getSession().getServletContext().getRealPath("");
		File file = new File(path+"\\file\\logo.jpg");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[fis.available()];
		fis.read(b);
		response.getOutputStream().write(b,0,b.length);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
