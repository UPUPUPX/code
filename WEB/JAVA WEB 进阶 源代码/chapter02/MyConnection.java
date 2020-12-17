package cn.itcast.mydatasource;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.LinkedList;
import java.util.concurrent.Executor;
//自定义一个Connection对象，其他方法都调用原本Connection的方法，重写close方法
public class MyConnection implements Connection{
		private Connection con;
		private LinkedList<Connection> pool; 
		//MyConnection的构造函数的参数包括连接对象和连接池对象
		public MyConnection (Connection con,LinkedList<Connection> pool){
			this.con = con ;
			this.pool = pool;
		}
		//不能真的关闭连接，而是把连接重新放回连接池中
		@Override
		public void close() throws SQLException {
			this.pool.addFirst(this.con); 
		}
	...
	.. //省略Connection的其他重写方法
	.
}
