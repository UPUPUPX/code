package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement ;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class Example11 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  preStmt = null;
		try {
			// ���ز�ע�����ݿ�����
              conn=JDBCUtils.getConnection();
			String sql = "INSERT INTO users(name,password,email,birthday)"
					+ "VALUES(?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < 5; i++) {
				preStmt.setString(1, "name" + i);
				preStmt.setString(2, "password" + i);
				preStmt.setString(3, "email" + i + "@itcast.cn");
				preStmt.setDate(4, Date.valueOf("1989-02-19"));
				preStmt.addBatch();
			}
			preStmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // �ͷ���Դ
			JDBCUtils.release(null, preStmt, conn);
		}
	}
}
