package cn.itcast.jdbc.example.dao;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
public class ResultSetTest2 {
	public static void testArrayListHandler() throws SQLException {
		BaseDao basedao=new BaseDao();
		String sql="select * from user";
		List list = (List) basedao.query(sql,new ArrayListHandler());
		Object[] arr = (Object[]) list.get(0);
		Object[] arr1 = (Object[]) list.get(1);
		Object[] arr2 = (Object[]) list.get(2);
		for(int i = 0; i < arr.length; i++){ 
			System.out.print(arr[i] + ", ");  }
		for(int i = 0; i < arr1.length; i++){ 
			System.out.print(arr1[i] + ", ");  }
		for(int i = 0; i < arr2.length; i++){ 
			System.out.print(arr2[i] + ", ");  
         }
	}
	public static void main(String[] args) throws SQLException {
		testArrayListHandler();
	}
}
