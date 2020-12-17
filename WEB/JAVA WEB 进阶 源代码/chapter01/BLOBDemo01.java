package cn.itcast.jdbc.example;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class BLOBDemo01 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  prestmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into testblob values(?,?)";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, 1);
			File file = new File("D:\\itcast.jpg");
			InputStream in = new FileInputStream(file);
			prestmt.setBinaryStream(2, in, (int) file.length());		
			prestmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ÊÍ·Å×ÊÔ´
			JDBCUtils.release(null, prestmt, conn);
		}
	}
}
