package cn.itcast.mydatasource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;
import javax.sql.DataSource;
import cn.itcast.utils.JDBCUtils;
//自定义数据库连接池类需要实现DataSource接口，重写DataSource的方法
public class JdbcPool implements DataSource {	
     // 自定义连接池
     private static LinkedList<Connection> pool = 
               new LinkedList<Connection>();
	// 初始化连接池
	static {
		try {
			for (int i = 0; i < 10; i++) {
				pool.add(getNewCon());// 初始化在连接池中添加10个连接对象
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);// 抛出初始化错误对象
		}
	}
	//封装获取连接方法
	public static Connection getNewCon() throws SQLException{
          //传统创建数据库连接对象的方法
		return JDBCUtils.getConnection();
	}
    //从连接池中获取一个连接对象    
	@Override
	public Connection getConnection() throws SQLException {
		// 返回删除的LinkedList集合中的第一个连接对象
		Connection connection = pool.removeFirst();
         // 包装设计模式，包装Connection对象，重写close()方法
		MyConnection con = new MyConnection(connection, pool); 
		return con;
	}
     //获取数据库连接池
	public static LinkedList<Connection> getPool() {
		return pool;
	}
	...
	..  //省略DataSource的其他重写方法
	.
}
