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
			// 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "itcast";
			conn = DriverManager.getConnection(url, username, password);
			// 使用Connection来创建一个CallableStatement对象
			cstmt = conn.prepareCall("call add_pro(?,?,?)");
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			// 注册CallableStatement的第三个参数为int类型
			cstmt.registerOutParameter(3, Types.INTEGER);
			// 执行存储过程
			cstmt.execute();
			System.out.println("执行结果是：" + cstmt.getInt(3));
         // 回收数据库资源
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
