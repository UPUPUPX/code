package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import cn.itcast.jdbc.example.domain.User;
public class ResultSetTest5 {
	public static void testBeanMapHandler() throws SQLException {
		String sql = "select id, name, password from user";
		Map<Integer, User> map = (Map<Integer, User>) BaseDao.query(sql,
				new BeanMapHandler<Integer, User>(User.class, "id"));
		// zhangsan的id值为1
		User u = map.get(1);
		String uName = u.getName();
		String uPassword = u.getPassword();
		System.out.print("id为1的User对象的name值为：" + uName + ",
                                   password值为:"+ uPassword);
	}
	public static void main(String[] args) throws SQLException {
		testBeanMapHandler();
	}
}
