package com.zua.blog.daolmp;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zua.blog.dao.UserDao;
import com.zua.blog.entity.User;

public class UserDaolmp implements UserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 用户登录
	@Override
	public boolean login(User user) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		// User user=null;
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		User user2 = (User) session.createQuery("from User where username = :username and password = :password")
				.setParameter("username", map.get("username")).setParameter("password", map.get("password"))
				.uniqueResult();
		// System.out.println(user2);
		if (user2 != null) {
			// System.out.println(user2);
			flag = true;
		}
		return flag;
		// return user;
	}

	@Override
	public boolean register(User user) {
		// boolean flag=false;
		// 根据hibernate配置文件的配置信息，创建一个configuration实例
		// Configuration configuration=new Configuration().configure();
		// 创建SessionFactory实例
		// SessionFactory sessionFactory=configuration.buildSessionFactory();
		// 获取一个全新的session对象
		Session session = sessionFactory.openSession();
		// 创建一个事务
		Transaction transaction = null;
		try {
			// 用session开启事务进行数据插入
			transaction = session.beginTransaction();
			session.save(user);
			// 提交事务
			transaction.commit();
		} catch (Exception e) {
			// 如果数据插入失败这回滚到初始化状态
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			// 记得最后关闭session
			session.close();
		}
		return true;
	}

}
