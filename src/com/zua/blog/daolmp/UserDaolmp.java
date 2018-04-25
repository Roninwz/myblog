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

	// �û���¼
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
		// ����hibernate�����ļ���������Ϣ������һ��configurationʵ��
		// Configuration configuration=new Configuration().configure();
		// ����SessionFactoryʵ��
		// SessionFactory sessionFactory=configuration.buildSessionFactory();
		// ��ȡһ��ȫ�µ�session����
		Session session = sessionFactory.openSession();
		// ����һ������
		Transaction transaction = null;
		try {
			// ��session��������������ݲ���
			transaction = session.beginTransaction();
			session.save(user);
			// �ύ����
			transaction.commit();
		} catch (Exception e) {
			// ������ݲ���ʧ����ع�����ʼ��״̬
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			// �ǵ����ر�session
			session.close();
		}
		return true;
	}

}
