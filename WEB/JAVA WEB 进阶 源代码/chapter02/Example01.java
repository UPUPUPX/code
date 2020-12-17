package cn.itcast.jdbc.example;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.SQLException;
import cn.itcast.utils.JDBCUtils;
public class Example01{
	public static void main(String[] args) {
		String outAccount = "aaa";
		String inAccount = "bbb";
		double amount = 200;
		Connection conn = null;
		PreparedStatement  pstmt1 = null;
		PreparedStatement  pstmt2 = null;
		try {
			conn = JDBCUtils.getConnection();
			// 控制事务，关闭事务的自动提交
			conn.setAutoCommit(false);
			// 账号转出200
			String sql = "UPDATE account SET money = money-? WHERE "
					+ "name=? AND money>=200";
			pstmt1 = conn.prepareStatement(sql);
			// 设置参数
			pstmt1.setDouble(1, amount);
			pstmt1.setString(2, outAccount);
			pstmt1.executeUpdate();
			// 账号转入200
			String sql2 = "update account set money=money+? where name=?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setDouble(1, amount);
			pstmt2.setString(2, inAccount);
			pstmt2.executeUpdate();
			// 提交事务
			conn.commit();
			System.out.println("转账成功");
		} catch (Exception e) {
			// 回滚事务
			try {
				conn.rollback();
				System.out.println("转账失败");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pstmt1 = null;
			}
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pstmt2 = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}
