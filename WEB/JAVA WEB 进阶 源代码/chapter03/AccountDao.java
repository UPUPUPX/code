package cn.itcast.jdbc.example.dao;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.itcast.jdbc.example.domain.Account;
import cn.itcast.jdbc.utils.C3p0Utils;
import cn.itcast.jdbc.utils.JDBCUtils;
public class AccountDao {
	public Account find(String name) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from account where name=?";
		Account account = (Account) runner.query(conn, sql, new BeanHandler(
				Account.class), new Object[] { name });
		return account;
	}
	public void update(Account account) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		Connection conn = JDBCUtils.getConnection();
		String sql = "update account set money=? where name=?";
		runner.update(conn, sql,
				new Object[] { account.getMoney(), account.getName() });
	}
}
