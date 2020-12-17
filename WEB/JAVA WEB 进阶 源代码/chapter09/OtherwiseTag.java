package cn.itcast.chapter09.simpletag;
import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class OtherwiseTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
	    // ��ø���ǩ����
		JspTag tag = this.getParent();
        // �жϸ���ǩ�Ƿ���ChooseTag
		if (!(tag instanceof ChooseTag)) {
			throw new JspTagException("OUT_OF_CHOOSE");
		}
       // ������ǩ����ǿת��ChooseTag����
		ChooseTag chooseTag = (ChooseTag) tag;
        // �жϸ���ǩ�е� flagΪfalseʱ��ִ�б�ǩ��
		if (!chooseTag.isFlag()) {
			this.getJspBody().invoke(null);
			// ִ�����ǩ��󣬽�����ǩ�е�flag��Ϊ true
			chooseTag.setFlag(true);
		}
	}
}
