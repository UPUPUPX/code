package cn.itcast.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.sql.DataSource;
import cn.itcast.mydatasource.JdbcPool;
public class JdbcPoolTest {
	public static void main(String[] args) throws SQLException {
		// ��ȡ����Դ����
		DataSource ds = new JdbcPool();
		// ��ȡ���ӳض���
		LinkedList<Connection> pool = JdbcPool.getPool();
		// ������ӳ������ӵĸ���
		System.out.println("��ʼ��ʱ���ӳ��е����Ӷ�������ǣ�" + pool.size());
		// ��ȡһ�����ݿ����Ӷ���
		Connection conn = ds.getConnection();
		// ������ӳ������ӵĸ���
		System.out.println("��ȡһ�����Ӷ���ʱ�����ӳ��е����Ӷ�������ǣ�" 
                        + pool.size());
		// �������ݿ����Ӷ���
		conn.close();
		// ������ӳ������ӵĸ���
		System.out.println("�������ݿ����Ӻ����ӳ��е����Ӷ�������ǣ�" 
                        + pool.size());
	}
}
