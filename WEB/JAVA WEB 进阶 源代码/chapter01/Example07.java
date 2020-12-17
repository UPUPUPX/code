package cn.itcast.jdbc.example;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class Example07 {
	public static void main(String[] args) {
	UsersDao ud = new UsersDao();
	User user = ud.find(1);
	System.out.println("id为1的User对象的name值为："+user.getUsername());
   }
}
