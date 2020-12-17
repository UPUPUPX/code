package cn.itcast.jdbc.example;
import java.util.ArrayList;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class Example06 {
	public static void main(String[] args) {
		UsersDao ud = new UsersDao();
		ArrayList<User> list = ud.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + (i + 1) + "条数据的username值为:"
					+ list.get(i).getUsername());
		}
	}
}
