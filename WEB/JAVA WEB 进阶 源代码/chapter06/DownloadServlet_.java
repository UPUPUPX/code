package cn.itcast.chapter06.example02;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
          // 获得绝对路径创建文件对象
         String path=getServletContext()
         		.getRealPath("/download/风景.jpg");
         File file=new File(path);
          // 通知浏览器以下载的方式打开文件
		response.addHeader("Content-Type", "application/octet-stream");
         response.addHeader("Content-Disposition","attachment;filename="
         +URLEncoder.encode(file.getName(),"utf-8"));
         // 通过文件对象获取文件相关的输入流
		InputStream in=new FileInputStream(file);
         // 获取response对象的输出流
		OutputStream out = response.getOutputStream();		
         byte [] buffer=new byte[1024];
		int len;
		while((len=in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse  resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
