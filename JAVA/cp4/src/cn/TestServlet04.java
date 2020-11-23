package cn;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet04 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	ServletContext context = this.getServletContext();
    	context.setAttribute("data","this servlet save data!");
//      PrintWriter out = response.getWriter();
//        response.setContentType("text/html;charset=utf-8");
//        ServletContext context = this.getServletContext();
//        PrintWriter out = response.getWriter();
//        // 获取相对路径中的输入流对象
//        InputStream in = context.getResourceAsStream("/WEB-INF/classes/itcast.properties");
//        Properties pros = new Properties();
//        pros.load(in);
//        out.println("username=" + pros.getProperty("username") + "<br>");
//        out.println("password=" + pros.getProperty("password") + "<br/>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        this.doGet(request, response);
    }
}