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
		// ��request��response��ǿת��http��
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 1. ��ȡMap
		// ��ȡServletContext
		ServletContext sc = config.getServletContext();
		Map<String, String> staticMap = (Map<String, String>) sc
				.getAttribute("static_map");
		if (staticMap == null) {
			staticMap = new HashMap<String, String>();
			sc.setAttribute("static_map", staticMap);
		}
		// 2. ͨ������·����ȡ��Ӧ�ľ�̬ҳ��
		// ����key��book_ǰ׺����׺Ϊcategory��ֵ
		String category = request.getParameter("category");
         // �����У�book_null��book_1��book_2��book_3
		String key = "book_" + category;
		// �鿴���·����Ӧ�ľ�̬ҳ���Ƿ����
		if (staticMap.containsKey(key)) {// �����̬ҳ���Ѿ�����
			String staticPath = staticMap.get(key);// ��ȡ��̬ҳ��·��
			// �ض��򵽾�̬ҳ��
		res.sendRedirect(req.getContextPath() + "/html/" + staticPath);
			return;
		}
		// �����̬ҳ�治����
		// 3. ���ɾ�̬ҳ��
		// ������̬ҳ���·��
		String staticPath = key + ".html";
		// ��ȡ��ʵ·��
		String realPath = sc.getRealPath("/html/" + staticPath);
		// �����Զ���Response
		StaticResponse sr = new StaticResponse(res, realPath);
		// ���С�
		chain.doFilter(request, sr);
		// ���澲̬ҳ�浽map��
		staticMap.put(key, staticPath);
		// 4. �ض��򵽾�̬ҳ��
		res.sendRedirect(req.getContextPath() + "/html/" + staticPath);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
