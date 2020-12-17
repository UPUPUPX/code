package cn.itcast.chapter06.example02;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
		response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 通知浏览器以下载的方式打开
		response.addHeader("Content-Type", "application/octet-stream");
		response.addHeader("Content-Disposition", 
         		"attachment;filename=1.jpg");
		// 通过文件流读取文件
		InputStream in = getServletContext().getResourceAsStream(
			"/download/1.jpg");
		// 获取response对象的输出流
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
	}
  	public void doPost(HttpServletRequest request, HttpServletResponse 
  		response) throws ServletException, IOException {
		doGet(request, response);
	}
}
