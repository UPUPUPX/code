package cn.itcast.mydatasource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;
import javax.sql.DataSource;
import cn.itcast.utils.JDBCUtils;
//�Զ������ݿ����ӳ�����Ҫʵ��DataSource�ӿڣ���дDataSource�ķ���
public class JdbcPool implements DataSource {	
     // �Զ������ӳ�
     private static LinkedList<Connection> pool = 
               new LinkedList<Connection>();
	// ��ʼ�����ӳ�
	static {
		try {
			for (int i = 0; i < 10; i++) {
				pool.add(getNewCon());// ��ʼ�������ӳ������10�����Ӷ���
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);// �׳���ʼ���������
		}
	}
	//��װ��ȡ���ӷ���
	public static Connection getNewCon() throws SQLException{
          //��ͳ�������ݿ����Ӷ���ķ���
		return JDBCUtils.getConnection();
	}
    //�����ӳ��л�ȡһ�����Ӷ���    
	@Override
	public Connection getConnection() throws SQLException {
		// ����ɾ����LinkedList�����еĵ�һ�����Ӷ���
		Connection connection = pool.removeFirst();
         // ��װ���ģʽ����װConnection������дclose()����
		MyConnection con = new MyConnection(connection, pool); 
		return con;
	}
     //��ȡ���ݿ����ӳ�
	public static LinkedList<Connection> getPool() {
		return pool;
	}
	...
	..  //ʡ��DataSource��������д����
	.
}
