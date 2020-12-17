package cn.itcast.chapter04.filter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class StaticFilter implements Filter {
	private FilterConfig config;
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 把request和response都强转成http的
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 1. 获取Map
		// 获取ServletContext
		ServletContext sc = config.getServletContext();
		Map<String, String> staticMap = (Map<String, String>) sc
				.getAttribute("static_map");
		if (staticMap == null) {
			staticMap = new HashMap<String, String>();
			sc.setAttribute("static_map", staticMap);
		}
		// 2. 通过访问路径获取对应的静态页面
		// 生成key：book_前缀，后缀为category的值
		String category = request.getParameter("category");
         // 可能有：book_null、book_1、book_2、book_3
		String key = "book_" + category;
		// 查看这个路径对应的静态页面是否存在
		if (staticMap.containsKey(key)) {// 如果静态页面已经存在
			String staticPath = staticMap.get(key);// 获取静态页面路径
			// 重定向到静态页面
		res.sendRedirect(req.getContextPath() + "/html/" + staticPath);
			return;
		}
		// 如果静态页面不存在
		// 3. 生成静态页面
		// 创建静态页面的路径
		String staticPath = key + ".html";
		// 获取真实路径
		String realPath = sc.getRealPath("/html/" + staticPath);
		// 创建自定义Response
		StaticResponse sr = new StaticResponse(res, realPath);
		// 放行
		chain.doFilter(request, sr);
		// 保存静态页面到map中
		staticMap.put(key, staticPath);
		// 4. 重定向到静态页面
		res.sendRedirect(req.getContextPath() + "/html/" + staticPath);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
