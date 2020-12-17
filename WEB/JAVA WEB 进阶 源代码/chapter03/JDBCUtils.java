package cn.itcast.jdbc.utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCUtils {
	// ����һ��ThreadLocal �����Ե�ǰ�߳���Ϊkey
	private static ThreadLocal<Connection> threadLocal = 
             new ThreadLocal<Connection>();
	// ��c3p0-config.xml�����ļ��ж�ȡĬ�ϵ����ݿ����ã�����c3p0����Դ
	private static DataSource ds = new ComboPooledDataSource();
	// ��������Դ����
	public static DataSource getDataSource() {
		return ds;
	}
	// ��ȡc3p0���ݿ����ӳ��е����Ӷ���
	public static Connection getConnection() throws SQLException {
		Connection conn = threadLocal.get();
		if (conn == null) {
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	// ��������
	public static void startTransaction() {
		try {
			// �������
			Connection conn = getConnection();
			// ��������
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �ύ����
	public static void commit() {
		try {
			// �������
			Connection conn = threadLocal.get();
			// �ύ����
			if (conn != null)
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �ع�����
	public static void rollback() {
		try {
			// �������
			Connection conn = threadLocal.get();
			// �ع�����
			if (conn != null)
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �ر����ݿ����ӣ��ͷ���Դ
	public static void close() {
		// �������
		Connection conn = threadLocal.get();
		// �ر�����
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// �Ӽ������Ƴ���ǰ�󶨵�����
				threadLocal.remove();
				conn = null;
			}
		}
	}
}
