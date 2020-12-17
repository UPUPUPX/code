package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class WhenTag extends SimpleTagSupport {
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	public void doTag() throws JspException, IOException {
		// 获得父标签对象
        JspTag tag = this.getParent(); 
        // 判断父标签是否是ChooseTag
        if(!(tag instanceof ChooseTag)){
        	throw new JspTagException("OUT_OF_CHOOSE");
        }
        // 将父标签对象强转成ChooseTag类型
        ChooseTag chooseTag=(ChooseTag)tag;
        // 判断test为true且父标签中的 flag为false时，执行标签体
		if(test&&!chooseTag.isFlag()){
			this.getJspBody().invoke(null);
			// 执行完标签体后，将父标签中的flag置为 true
			chooseTag.setFlag(true);
		}
	}
}
