package cn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet07
 */
@WebServlet("/TestServlet07")
public class TestServlet07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet07() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter outPrintWriter=response.getWriter();
		ServletContext context=this.getServletContext();
		//String pathString=context.getResourceAsStream("WEB-INF/classes/itcast.properties");
		FileInputStream inputStream=(FileInputStream) context.getResourceAsStream("WEB-INF/classes/itcast.properties");
		Properties prosProperties=new Properties();
		prosProperties.load(inputStream);
		outPrintWriter.println("Company="+prosProperties.getProperty("Company")+"<br>");
		outPrintWriter.println("Address="+prosProperties.getProperty("Address")+"<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
