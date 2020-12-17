package cn.itcast.chapter09.classisctag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
public class ToUpperCase extends BodyTagSupport {
    //定义doEndTag()方法
    public int doEndTag() throws JspException {
       //获取缓冲区中数据
       String content = getBodyContent().getString();
       //将数据转为大写
       content= content.toUpperCase();
       try {
          //输出数据内容（两种方式均可）
          //pageContext.getOut().write(content);
          bodyContent.getEnclosingWriter().write(content);
	   } catch (IOException e) {
          e.printStackTrace();
	   }
        return super.doEndTag();
    }
}
