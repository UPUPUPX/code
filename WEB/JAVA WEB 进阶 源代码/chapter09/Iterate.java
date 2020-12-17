package cn.itcast.chapter09.classisctag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
public class Iterate extends TagSupport {
	//定义变量
     private int num;
	//提供num属性的setter方法
	public void setNum(int num) {
		this.num = num;
	}
	//执行一次标签体
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	//根据属性值对标签体进行执行
	public int doAfterBody() throws JspException {
		num--;
		if (num > 0) {
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;	//跳过标签体
		}
	}
}
