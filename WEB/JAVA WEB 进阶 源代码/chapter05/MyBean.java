package cn.itcast.chapter05.listener;
import javax.servlet.http.*;
public class MyBean implements HttpSessionBindingListener {
	// �÷���������ʱ����ӡ������Ҫ���󶨵���Ϣ
	public void valueBound(HttpSessionBindingEvent hbe) {
		System.out.println("MyBean������ӵ���Session��..."+
     			this);
	}
	// �÷���������ʱ����ӡ������Ҫ��������Ϣ
	public void valueUnbound(HttpSessionBindingEvent hbe) {
		System.out.println("MyBean�����Session���Ƴ���..."+this);
	}
}
