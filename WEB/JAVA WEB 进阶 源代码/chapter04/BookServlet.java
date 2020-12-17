package cn.itcast.chapter04.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
public class BookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse 
    				response) throws ServletException, IOException {
		String param = request.getParameter("category");
		BookDao dao = new BookDao();
		List<Book> bookList = null;
		// 如果category参数不存在，表示查询所有
		if(param == null || param.trim().isEmpty()) {
			bookList = dao.findAll();
		} else {
			int category = Integer.parseInt(param);   //把参数转换成int类型
			// 按分类查询图书
			bookList = dao.findByCategory(category);
		}
		// 把图书保存到request中
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/show.jsp").forward(request, 
         				response);
	}
}
