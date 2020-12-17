package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.dbutils.handlers.MapHandler;
public class ResultSetTest6 {
	public static void testMapHandler() throws SQLException {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user where id=?";
		Map map = (Map) basedao.query(sql, new MapHandler(), 1);
		System.out.println(map);
	}
	public static void main(String[] args) throws SQLException {
		testMapHandler();
	}
}
