package com.test;
import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import cn.user;
@WebServlet("/hibernateTest")
public class hibernateTest {
	//@Test
	public void testAdd() {
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
	Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		 user us = new user();
	        us.setTno("12");
	        us.setTeachername("ÐÂ°×");
	        us.setAge(18);
	        us.setSex("ÄÐ");
	        us.setTitle("½ÌÊÚ");
	        session.save(us);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}

