package com.zua.blog.daolmp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zua.blog.dao.UserDao;
import com.zua.blog.entity.Article;
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


	@Override
	public List<User> allUser() {

		Session session = sessionFactory.openSession();
		
		List<User> entities = session.createQuery("from User").list();
		

		 session.close();
		 
		 return entities;
	}


	@Override
	public List<User> selectUser(String username) {
       Session session = sessionFactory.openSession();
       Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		List<User> entities = session.createQuery("from User where username = :username").list();
		

		 session.close();
		 
		 return entities;
	}


	@Override
	public boolean isExistUsername(String username) {
		Session session = sessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		boolean flag=false;
		User user = (User) session.createQuery("from User where username = :username").setParameter("username", map.get("username")).uniqueResult();;
		System.out.println("找到"+user.getUsername());
		if(user!=null){
			flag=true;
		}
		 session.close();
		 return flag;
	}


	@Override
	public boolean isExistEmail(String email) {
		Session session = sessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		System.out.println(email);
		boolean flag=false;
		User user = (User) session.createQuery("from User where email = :email").setParameter("email", map.get("email")).uniqueResult();;
		System.out.println(user);
		if(user!=null){
			flag=true;
		}
		 session.close();
		 return flag;
	}

}
