package cn.itcast.example;
import java.sql.SQLException;
import cn.itcast.jdbc.example.dao.AccountDao;
import cn.itcast.jdbc.example.domain.Account;
import cn.itcast.jdbc.utils.JDBCUtils;
public class Business {
	public static void transfer(String sourceAccountName,
                 String toAccountName,  float money) {
		try {
			// ��������
			JDBCUtils.startTransaction();
			// �����û�����ѯ���ݲ�����ʵ���������
			AccountDao dao = new AccountDao();
			Account accountfrom = dao.find(sourceAccountName);
			Account accountto = dao.find(toAccountName);
			// ���ת�˲���
			if(money<accountfrom.getMoney()){
				accountfrom.setMoney(accountfrom.getMoney()-money);
			}else{
				System.out.println("ת���˻�����");
			}		
			accountto.setMoney(accountto.getMoney()+money);
			dao.update(accountfrom);
			dao.update(accountto);
			// �ύ����
			JDBCUtils.commit();
			System.out.println("�ύ�ɹ�");
		} catch (SQLException e) {
			System.out.println("�ύʧ��");
			JDBCUtils.rollback();
			e.printStackTrace();
		} finally {
			// �ر�����
			JDBCUtils.close();
		}
	}
	public static void main(String[] args) throws SQLException {
		// ���÷�����ʵ��a��bת��200Ԫ����
		transfer("a", "b", 200);
	}
}
