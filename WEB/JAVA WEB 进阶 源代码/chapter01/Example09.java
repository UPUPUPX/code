package cn.itcast.jdbc.example;
import cn.itcast.jdbc.example.dao.UsersDao;
public class Example09{
	public static void main(String[] args) {
		// É¾³ý²Ù×÷
		UsersDao ud = new UsersDao();
		boolean b = ud.delete(4);
		System.out.println(b);
	}
}
