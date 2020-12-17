package cn.itcast.dao;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.itcast.domain.Book;
import cn.itcast.jdbc.utils.JDBCUtils;//这个JDBCUtils与chapter03中的一样
public class BookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
     //查询所有
	public List<Book> findAll() {
		try {
			String sql = "select * from t_book";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 按分类查询
	public List<Book> findByCategory(int category) {
		try {
			String sql = "select * from t_book where category=?";
			return qr.query(sql, new BeanListHandler<Book>
                                        (Book.class), category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
