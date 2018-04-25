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

	
	/*public boolean login(User user) {
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
*/
	@Override
	public boolean register(User user) {
		// boolean flag=false;
		// Configuration configuration=new Configuration().configure();
		// SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean loginUsername(String username, String password) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password",password);
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
	}

	@Override
	public boolean loginEmail(String email, String password) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password",password);
		// User user=null;
		Session session = sessionFactory.openSession();

		User user2 = (User) session.createQuery("from User where email = :email and password = :password")
				.setParameter("email", map.get("email")).setParameter("password", map.get("password"))
				.uniqueResult();
		System.out.println(user2);
		if (user2 != null) {
			System.out.println("找到该用户");
			flag = true;
		}
		session.close();
		return flag;
	}

}
