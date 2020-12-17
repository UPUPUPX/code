package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
public class Example01 {
	public static void main(String[] args) throws SQLException {
	// 1. 注册数据库的驱动
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	// 2.通过DriverManager获取数据库连接
	String url = "jdbc:mysql://localhost:3306/chapter01";
	String username = "root";
	String password = "itcast";
	Connection conn = DriverManager.getConnection (url, username, 
     			password);
	// 3.通过Connection对象获取Statement对象
	Statement stmt = conn.createStatement();
	// 4.使用Statement执行SQL语句。
	String sql = "select * from users";
	ResultSet rs = stmt.executeQuery(sql);
	// 5. 操作ResultSet结果集
	System.out.println("id | name   | password | email  | birthday");
	while (rs.next()) {
		int id = rs.getInt("id"); // 通过列名获取指定字段的值
		String name = rs.getString("name");
		String psw = rs.getString("password");
		String email = rs.getString("email");
		Date birthday = rs.getDate("birthday");
		System.out.println(id + " | " + name + " | " + psw + " | " + email
					+ " | " + birthday);
	}
	// 6.回收数据库资源
	rs.close();
	stmt.close();
	conn.close();
	}
}
