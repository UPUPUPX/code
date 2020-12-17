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
			// ��������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f=new File("e:\\Target");
			if(!f.exists()){
				f.mkdirs();
			}
			//�����ļ��Ļ���·��
			factory.setRepository(f); 
			// ���� fileupload ���
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("gbk");
			// ���� request
			List<FileItem> fileitems = fileupload.parseRequest(request);
			PrintWriter writer=response.getWriter();
			// ��������
			for (FileItem fileitem : fileitems) {
				// �ж��Ƿ�Ϊ��ͨ�ֶ�
				if (fileitem.isFormField()) {
					// ����ֶ������ֶ�ֵ
					String name = fileitem.getFieldName();
					String value = fileitem.getString("gbk");
					writer.print("�ϴ��ߣ�"+value+"<br>");
				} else {
					// �ϴ����ļ�·��
					String filename = fileitem.getName();
					writer.print("�ļ���Դ��"+filename+"<br>");
					// ��ȡ���ļ���
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					writer.print("�ɹ��ϴ����ļ���"+filename+"<br>");
					// �ļ�����ҪΨһ
					filename = UUID.randomUUID().toString() + "_" + 
                        		filename;
					// �ڷ���������ͬ���ļ�
					String webPath = "/upload/";
					String filepath =
                       getServletContext().getRealPath(webPath+filename); 
					// �����ļ�
					File file = new File(filepath);
					file.getParentFile().mkdirs();
					file.createNewFile();
					// ����ϴ��ļ���
					InputStream in = fileitem.getInputStream();
					// ���д���ļ���
					OutputStream out = new FileOutputStream(file);
					// ���ĶԿ�
					byte[] buffer = new byte[1024];
					int len;
					while ((len = in.read(buffer)) > 0)
						out.write(buffer, 0, len);
					// ����
					in.close();
					out.close();
					// ɾ����ʱ�ļ�
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
