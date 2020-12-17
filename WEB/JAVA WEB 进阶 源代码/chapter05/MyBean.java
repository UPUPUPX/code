package cn.itcast.chapter05.listener;
import javax.servlet.http.*;
public class MyBean implements HttpSessionBindingListener {
	// 该方法被调用时，打印出对象将要被绑定的信息
	public void valueBound(HttpSessionBindingEvent hbe) {
		System.out.println("MyBean对象被添加到了Session域..."+
     			this);
	}
	// 该方法被调用时，打印出对象将要被解绑的信息
	public void valueUnbound(HttpSessionBindingEvent hbe) {
		System.out.println("MyBean对象从Session中移除了..."+this);
	}
}
