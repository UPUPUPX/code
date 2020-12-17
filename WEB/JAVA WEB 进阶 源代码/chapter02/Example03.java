package cn.itcast.example;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
public class Example03 {
	public static DataSource ds = null;
	static {
		// �½�һ�������ļ�����
		Properties prop = new Properties();
		try {
			// ͨ����������ҵ��ļ�·�����������ļ�
			InputStream in = new Example03().getClass().getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			// ���ļ�������������ʽ���ص����ö�����
			prop.load(in);
			// ��������Դ����
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
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
