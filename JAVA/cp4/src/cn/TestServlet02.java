package cn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet02 extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletConfig config = this.getServletConfig();
        String param = config.getInitParameter("encoding");
        out.println("encoding=" + param);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}