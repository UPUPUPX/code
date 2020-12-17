package cn.itcast.chapter06.example01;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class UploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try { 
			// 创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f=new File("e:\\Target");
			if(!f.exists()){
				f.mkdirs();
			}
			//设置文件的缓存路径
			factory.setRepository(f); 
			// 创建 fileupload 组件
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("gbk");
			// 解析 request
			List<FileItem> fileitems = fileupload.parseRequest(request);
			PrintWriter writer=response.getWriter();
			// 遍历集合
			for (FileItem fileitem : fileitems) {
				// 判断是否为普通字段
				if (fileitem.isFormField()) {
					// 获得字段名和字段值
					String name = fileitem.getFieldName();
					String value = fileitem.getString("gbk");
					writer.print("上传者："+value+"<br>");
				} else {
					// 上传的文件路径
					String filename = fileitem.getName();
					writer.print("文件来源："+filename+"<br>");
					// 截取出文件名
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					writer.print("成功上传的文件："+filename+"<br>");
					// 文件名需要唯一
					filename = UUID.randomUUID().toString() + "_" + 
                        		filename;
					// 在服务器创建同名文件
					String webPath = "/upload/";
					String filepath =
                       getServletContext().getRealPath(webPath+filename); 
					// 创建文件
					File file = new File(filepath);
					file.getParentFile().mkdirs();
					file.createNewFile();
					// 获得上传文件流
					InputStream in = fileitem.getInputStream();
					// 获得写入文件流
					OutputStream out = new FileOutputStream(file);
					// 流的对拷
					byte[] buffer = new byte[1024];
					int len;
					while ((len = in.read(buffer)) > 0)
						out.write(buffer, 0, len);
					// 关流
					in.close();
					out.close();
					// 删除临时文件
					fileitem.delete();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		doGet(request, response);
	}
}
