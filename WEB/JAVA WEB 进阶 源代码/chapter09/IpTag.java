package cn.itcast.chapter09.tag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
public class IpTag extends TagSupport{
	public int doStartTag() throws JspException {
         //获取用户的IP地址
		String IP=pageContext.getRequest().getRemoteAddr();
		try{
              //输出用户的IP地址
			pageContext.getOut().write("访问用户的IP地址为："+IP);
		}catch(IOException e){
			e.printStackTrace();
		}
		return super.doStartTag();
    }
}
