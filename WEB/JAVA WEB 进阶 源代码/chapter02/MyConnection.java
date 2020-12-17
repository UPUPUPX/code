package cn.itcast.mydatasource;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.LinkedList;
import java.util.concurrent.Executor;
//�Զ���һ��Connection������������������ԭ��Connection�ķ�������дclose����
public class MyConnection implements Connection{
		private Connection con;
		private LinkedList<Connection> pool; 
		//MyConnection�Ĺ��캯���Ĳ����������Ӷ�������ӳض���
		public MyConnection (Connection con,LinkedList<Connection> pool){
			this.con = con ;
			this.pool = pool;
		}
		//������Ĺر����ӣ����ǰ��������·Ż����ӳ���
		@Override
		public void close() throws SQLException {
			this.pool.addFirst(this.con); 
		}
	...
	.. //ʡ��Connection��������д����
	.
}
