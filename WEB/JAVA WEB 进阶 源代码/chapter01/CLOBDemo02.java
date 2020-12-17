package cn.itcast.jdbc.example;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class CLOBDemo02 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  preStmt  = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from testclob";
			preStmt  = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				Reader reader = rs.getCharacterStream("resume");
				Writer out = new FileWriter("resume.txt");
				int temp;
				while ((temp = reader.read()) != -1) {
					out.write(temp);
				}
				out.close();
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ÊÍ·Å×ÊÔ´
			JDBCUtils.release(rs, preStmt , conn);
		}
	}
}
