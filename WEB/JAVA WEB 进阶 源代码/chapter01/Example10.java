package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.Statement;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class Example10 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// �������ݿ�����
			conn=JDBCUtils.getConnection();
			stmt = conn.createStatement();
			// SQL���
       String sql1 = "DROP TABLE IF EXISTS school";
	  String  sql2 = "CREATE TABLE school(id int,name varchar(20))";
       String sql3 = "INSERT INTO school VALUES(2,'���ǲ���')";
       String sql4 = "UPDATE school SET id = 1";
			// Statement������sql���
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
              stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // �ͷ���Դ
			JDBCUtils.release(null, stmt, conn);
		}
	}
}
