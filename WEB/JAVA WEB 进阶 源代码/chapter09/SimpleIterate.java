package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class SimpleIterate extends SimpleTagSupport {
    //定义变量
	private int num;
    //提供num属性的setter方法
	public void setNum(int num) {
		this.num = num;
	}
    //对标签进行逻辑处理
	public void doTag() throws JspException, IOException {
         //获取标签体
         JspFragment jf = this.getJspBody();
        //对标签体进行循环执行
		for (int i = 0; i < num; i++) {
			jf.invoke(null);
		}
	}
}
