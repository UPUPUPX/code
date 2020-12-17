package cn.itcast.chapter09.classisctag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
public class ToUpperCase extends BodyTagSupport {
    //����doEndTag()����
    public int doEndTag() throws JspException {
       //��ȡ������������
       String content = getBodyContent().getString();
       //������תΪ��д
       content= content.toUpperCase();
       try {
          //����������ݣ����ַ�ʽ���ɣ�
          //pageContext.getOut().write(content);
          bodyContent.getEnclosingWriter().write(content);
	   } catch (IOException e) {
          e.printStackTrace();
	   }
        return super.doEndTag();
    }
}
