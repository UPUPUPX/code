package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;
public class AntiHotLinking extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
         //��ȡpageContext����
		PageContext pageContext = (PageContext) this.getJspContext();
         //��ȡrequest����
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
         //���������ҳ��URL
		String referer = request.getHeader("referer");
         //ƴд������������Ϣͷ
		String serverName = "http://" + request.getServerName();
         //�������ҳ���URL
		System.out.println(referer);
         //�ж�������Ϣͷ��ֵ��Ϊ��������ͷ�뱾��ͷ�ֶ�ֵ��ͬ
		if (referer != null && referer.startsWith(serverName)) {
         //ִ��JSPҳ������
		} else {
			try {
                  //��ȡ��Ӧ����
				HttpServletResponse resp = 
						 (HttpServletResponse) pageContext.getResponse();
                  //�������ض��򵽱�����Դindex.htmlҳ��
				resp.sendRedirect("/chapter09/index.html");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
