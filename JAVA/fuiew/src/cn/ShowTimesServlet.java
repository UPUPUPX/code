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

//���ñ���,��Ȼ���Ļ�������

resp.setContentType("text/html;charset=GB2312");

//�õ����������

PrintWriter out=resp.getWriter();


out.println("<html><head><title>");

out.println("ҳ�����ͳ��");

out.println("</title></head><body>");

out.println("��ǰҳ�汻������");

out.println("<font color=red size=20>"+times+"</font>��");

//��������,��times���浽��ǰ����������

context.setAttribute("times",times);

}

protected void doPost(HttpServletRequest req, HttpServletResponse resp)

throws ServletException, IOException {

this.doGet(req, resp);

}

}