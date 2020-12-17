package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.Statement;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class Example10 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 加载数据库驱动
			conn=JDBCUtils.getConnection();
			stmt = conn.createStatement();
			// SQL语句
       String sql1 = "DROP TABLE IF EXISTS school";
	  String  sql2 = "CREATE TABLE school(id int,name varchar(20))";
       String sql3 = "INSERT INTO school VALUES(2,'传智播客')";
       String sql4 = "UPDATE school SET id = 1";
			// Statement批处理sql语句
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
              stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 释放资源
			JDBCUtils.release(null, stmt, conn);
		}
	}
}
