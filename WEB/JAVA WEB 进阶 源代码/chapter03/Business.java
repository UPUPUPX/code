package cn.itcast.example;
import java.sql.SQLException;
import cn.itcast.jdbc.example.dao.AccountDao;
import cn.itcast.jdbc.example.domain.Account;
import cn.itcast.jdbc.utils.JDBCUtils;
public class Business {
	public static void transfer(String sourceAccountName,
                 String toAccountName,  float money) {
		try {
			// 开启事务
			JDBCUtils.startTransaction();
			// 根据用户名查询数据并存入实体类对象中
			AccountDao dao = new AccountDao();
			Account accountfrom = dao.find(sourceAccountName);
			Account accountto = dao.find(toAccountName);
			// 完成转账操作
			if(money<accountfrom.getMoney()){
				accountfrom.setMoney(accountfrom.getMoney()-money);
			}else{
				System.out.println("转出账户余额不足");
			}		
			accountto.setMoney(accountto.getMoney()+money);
			dao.update(accountfrom);
			dao.update(accountto);
			// 提交事务
			JDBCUtils.commit();
			System.out.println("提交成功");
		} catch (SQLException e) {
			System.out.println("提交失败");
			JDBCUtils.rollback();
			e.printStackTrace();
		} finally {
			// 关闭事务
			JDBCUtils.close();
		}
	}
	public static void main(String[] args) throws SQLException {
		// 调用方法，实现a向b转账200元操作
		transfer("a", "b", 200);
	}
}
