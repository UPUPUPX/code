package cn.itcast.chapter05.listener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;
public class MyBean2 implements HttpSessionActivationListener,
Serializable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("MyBean2的对象活化了...");
	}
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("MyBean2的对象钝化了...");
	}
}
