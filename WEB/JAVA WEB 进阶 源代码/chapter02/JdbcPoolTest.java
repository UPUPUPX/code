package cn.itcast.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.sql.DataSource;
import cn.itcast.mydatasource.JdbcPool;
public class JdbcPoolTest {
	public static void main(String[] args) throws SQLException {
		// 获取数据源对象
		DataSource ds = new JdbcPool();
		// 获取连接池对象
		LinkedList<Connection> pool = JdbcPool.getPool();
		// 输出连接池中连接的个数
		System.out.println("初始化时连接池中的连接对象个数是：" + pool.size());
		// 获取一个数据库连接对象
		Connection conn = ds.getConnection();
		// 输出连接池中连接的个数
		System.out.println("获取一个连接对象时，连接池中的连接对象个数是：" 
                        + pool.size());
		// 返还数据库连接对象
		conn.close();
		// 输出连接池中连接的个数
		System.out.println("返还数据库连接后，连接池中的连接对象个数是：" 
                        + pool.size());
	}
}
