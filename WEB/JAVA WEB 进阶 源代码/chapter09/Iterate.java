package cn.itcast.chapter09.classisctag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
public class Iterate extends TagSupport {
	//�������
     private int num;
	//�ṩnum���Ե�setter����
	public void setNum(int num) {
		this.num = num;
	}
	//ִ��һ�α�ǩ��
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	//��������ֵ�Ա�ǩ�����ִ��
	public int doAfterBody() throws JspException {
		num--;
		if (num > 0) {
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;	//������ǩ��
		}
	}
}
