package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class ChooseTag extends SimpleTagSupport {
	// 用于控制子标签标签体的执行
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
    // 执行标签体
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
}
