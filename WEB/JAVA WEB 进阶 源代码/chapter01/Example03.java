package cn.itcast.jdbc.example;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
public class Example03 {
	public static void main(String[] args) throws Exception {
		CallableStatement cstmt = null;
		Connection conn = null;
		try {
			// ע�����ݿ������
			Class.forName("com.mysql.jdbc.Driver");
			// ͨ��DriverManager��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "itcast";
			conn = DriverManager.getConnection(url, username, password);
			// ʹ��Connection������һ��CallableStatement����
			cstmt = conn.prepareCall("call add_pro(?,?,?)");
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			// ע��CallableStatement�ĵ���������Ϊint����
			cstmt.registerOutParameter(3, Types.INTEGER);
			// ִ�д洢����
			cstmt.execute();
			System.out.println("ִ�н���ǣ�" + cstmt.getInt(3));
         // �������ݿ���Դ
		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
