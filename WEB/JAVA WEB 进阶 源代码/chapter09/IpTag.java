package cn.itcast.chapter09.tag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
public class IpTag extends TagSupport{
	public int doStartTag() throws JspException {
         //��ȡ�û���IP��ַ
		String IP=pageContext.getRequest().getRemoteAddr();
		try{
              //����û���IP��ַ
			pageContext.getOut().write("�����û���IP��ַΪ��"+IP);
		}catch(IOException e){
			e.printStackTrace();
		}
		return super.doStartTag();
    }
}
