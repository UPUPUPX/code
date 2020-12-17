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
			// �������񣬹ر�������Զ��ύ
			conn.setAutoCommit(false);
			// �˺�ת��200
			String sql = "UPDATE account SET money = money-? WHERE "
					+ "name=? AND money>=200";
			pstmt1 = conn.prepareStatement(sql);
			// ���ò���
			pstmt1.setDouble(1, amount);
			pstmt1.setString(2, outAccount);
			pstmt1.executeUpdate();
			// �˺�ת��200
			String sql2 = "update account set money=money+? where name=?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setDouble(1, amount);
			pstmt2.setString(2, inAccount);
			pstmt2.executeUpdate();
			// �ύ����
			conn.commit();
			System.out.println("ת�˳ɹ�");
		} catch (Exception e) {
			// �ع�����
			try {
				conn.rollback();
				System.out.println("ת��ʧ��");
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
