package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
public class Example01 {
	public static void main(String[] args) throws SQLException {
	// 1. ע�����ݿ������
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	// 2.ͨ��DriverManager��ȡ���ݿ�����
	String url = "jdbc:mysql://localhost:3306/chapter01";
	String username = "root";
	String password = "itcast";
	Connection conn = DriverManager.getConnection (url, username, 
     			password);
	// 3.ͨ��Connection�����ȡStatement����
	Statement stmt = conn.createStatement();
	// 4.ʹ��Statementִ��SQL��䡣
	String sql = "select * from users";
	ResultSet rs = stmt.executeQuery(sql);
	// 5. ����ResultSet�����
	System.out.println("id | name   | password | email  | birthday");
	while (rs.next()) {
		int id = rs.getInt("id"); // ͨ��������ȡָ���ֶε�ֵ
		String name = rs.getString("name");
		String psw = rs.getString("password");
		String email = rs.getString("email");
		Date birthday = rs.getDate("birthday");
		System.out.println(id + " | " + name + " | " + psw + " | " + email
					+ " | " + birthday);
	}
	// 6.�������ݿ���Դ
	rs.close();
	stmt.close();
	conn.close();
	}
}
