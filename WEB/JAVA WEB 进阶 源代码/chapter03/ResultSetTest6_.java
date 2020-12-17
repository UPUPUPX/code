package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
public class ResultSetTest6  {
	public static void testMapHandler() throws SQLException {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user where id=?";
		Map map = (Map) basedao.query(sql, new MapHandler(), 1);
		System.out.println(map);
	}

	  public static void testMapListHandler() throws SQLException {
			BaseDao basedao = new BaseDao();
			String sql = "select * from user ";
			List list = (List) basedao.query(sql,new MapListHandler());
				System.out.println(list);
		}

	public static void main(String[] args) throws SQLException {
		//testMapHandler();
		testMapListHandler();//调用新添加的方法
	}
}
