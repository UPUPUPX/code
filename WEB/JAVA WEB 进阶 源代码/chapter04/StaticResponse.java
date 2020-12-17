package cn.itcast.chapter04.filter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
public class StaticResponse extends HttpServletResponseWrapper {
	private HttpServletResponse response;
	private PrintWriter pw;
	// ����staticPathΪ��̬ҳ���·��
	public StaticResponse(HttpServletResponse response, String staticPath)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response = response;
		// pw��ָ���ļ�����һ�𣬵�ʹ��pw���ʱ��������ָ�����ļ����
		pw = new PrintWriter(staticPath, "utf-8");
	}
	// ��show.jsp���ҳ���е�����ʱ��ʹ�õľ���getWriter()��ȡ��������
	public PrintWriter getWriter() throws IOException {
		return pw;
	}
	// �رշ����ڹ������е��ã�����ˢ�»�������
	public void close() {
		pw.close();
	}
}
