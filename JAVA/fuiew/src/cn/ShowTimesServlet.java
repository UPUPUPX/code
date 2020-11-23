package cn;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ShowTimesServlet")
public class ShowTimesServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
ServletContext context = getServletContext();

Integer times = (Integer) context.getAttribute("times");

if (times == null) {

times = new Integer(1);

} else {

times = new Integer(times.intValue() + 1);

}

//设置编码,不然中文会变成乱码

resp.setContentType("text/html;charset=GB2312");

//得到输出流对象

PrintWriter out=resp.getWriter();


out.println("<html><head><title>");

out.println("页面访问统计");

out.println("</title></head><body>");

out.println("当前页面被访问了");

out.println("<font color=red size=20>"+times+"</font>次");

//设置属性,将times保存到当前的上下文中

context.setAttribute("times",times);

}

protected void doPost(HttpServletRequest req, HttpServletResponse resp)

throws ServletException, IOException {

this.doGet(req, resp);

}

}