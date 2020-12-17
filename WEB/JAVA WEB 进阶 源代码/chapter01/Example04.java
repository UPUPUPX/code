package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Example04 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://localhost:3306/chapter01";
		   String username = "root";
		   String password = "itcast";
		   conn = DriverManager.getConnection(url, username, password);
		   String sql = "select * from users";
            Statement st =conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			System.out.print("��2�����ݵ�nameֵΪ:");
			rs.absolute(2);        //��ָ�붨λ��������е�2������
			System.out.println(rs.getString("name"));
			System.out.print("��1�����ݵ�nameֵΪ:");
			rs.beforeFirst();      //��ָ�붨λ��������е�1������֮ǰ
			rs.next();              //��ָ��������
			System.out.println(rs.getString("name"));
			System.out.print("��4�����ݵ�nameֵΪ:");
			rs.afterLast();        //��ָ�붨λ������������һ������֮��
			rs.previous();         //��ָ����ǰ����
			System.out.println(rs.getString("name"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // �ͷ���Դ
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}
