package cn.itcast.jdbc.example;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class BLOBDemo02 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from testblob where id = 1";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				InputStream in = new BufferedInputStream(
						rs.getBinaryStream("img"));
				OutputStream out = new BufferedOutputStream(
						new FileOutputStream("img.jpg"));
				int temp;
				while ((temp = in.read()) != -1) {
					out.write(temp);
				}
				out.close();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
}
