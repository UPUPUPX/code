package cn.itcast.example;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
public class Example02 {
	public static DataSource ds = null;
	static {
		// ��ȡDBCP����Դʵ�������
		BasicDataSource bds = new BasicDataSource();
		// �����������ݿ���Ҫ��������Ϣ
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/chapter02");
		bds.setUsername("root");
		bds.setPassword("itcast");
		// �������ӳصĲ���
		bds.setInitialSize(5);
		bds.setMaxActive(5);
		ds = bds;
	}
	public static void main(String[] args) throws SQLException {
		// ��ȡ���ݿ����Ӷ���
		Connection conn = ds.getConnection();
		//��ȡ���ݿ�������Ϣ
		DatabaseMetaData metaData = conn.getMetaData();
		//��ӡ���ݿ�������Ϣ
		System.out.println(metaData.getURL()
             +",UserName="+metaData.getUserName()
             +","+metaData.getDriverName());
	}
}
