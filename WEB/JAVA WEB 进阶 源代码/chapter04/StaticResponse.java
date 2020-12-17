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
	// 其中staticPath为静态页面的路径
	public StaticResponse(HttpServletResponse response, String staticPath)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response = response;
		// pw与指定文件绑定在一起，当使用pw输出时，就是向指定的文件输出
		pw = new PrintWriter(staticPath, "utf-8");
	}
	// 当show.jsp输出页面中的内容时，使用的就是getWriter()获取的流对象。
	public PrintWriter getWriter() throws IOException {
		return pw;
	}
	// 关闭方法在过滤器中调用，可以刷新缓冲区。
	public void close() {
		pw.close();
	}
}
