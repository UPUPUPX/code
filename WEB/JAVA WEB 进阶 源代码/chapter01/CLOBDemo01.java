package cn.itcast.jdbc.example;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class CLOBDemo01 {
public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  preStmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into testclob values(?,?)";
			preStmt = conn.prepareStatement(sql);
			File file = new File("D:\\itcast.txt");
			Reader reader = new InputStreamReader(
					 new FileInputStream(file),"utf-8");
			preStmt.setInt(1, 1);
			preStmt.setCharacterStream(2, reader, (int) file.length());
			preStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ÊÍ·Å×ÊÔ´
			JDBCUtils.release(null, preStmt, conn);
		}
	}
}
