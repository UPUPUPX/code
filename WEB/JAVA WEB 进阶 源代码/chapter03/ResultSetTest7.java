package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import cn.itcast.jdbc.example.domain.User;
public class ResultSetTest7 {
   public static void testColumnListHandler() throws SQLException {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user "; 
		List list = (ArrayList<User>) basedao.query(sql,
				new ColumnListHandler("name"));
			     System.out.println(list);
	}
   public static void main(String[] args) throws SQLException {
		testColumnListHandler ();
	}
}
