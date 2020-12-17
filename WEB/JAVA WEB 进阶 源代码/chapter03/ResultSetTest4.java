package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.itcast.jdbc.example.domain.User;
public class ResultSetTest4 {	
    public static void testBeanListHandler() throws SQLException {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user ";
		ArrayList<User> list = (ArrayList<User>) basedao.query(sql,
				new BeanListHandler(User.class));
		for (int i = 0; i < list.size(); i++) {
			System.out.println("��" + (i + 1) + "�����ݵ�usernameֵΪ:"
					+ list.get(i).getName());
		}
	}
    public static void main(String[] args) throws SQLException {
		testBeanListHandler ();
	}
}
