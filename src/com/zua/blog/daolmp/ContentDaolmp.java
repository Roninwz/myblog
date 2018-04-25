package com.zua.blog.daolmp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zua.blog.dao.ContentDao;
import com.zua.blog.entity.Content;

public class ContentDaolmp implements ContentDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean addContent(Content content) {
		
		Session session = sessionFactory.openSession();
		//开启事务           
		session.beginTransaction();
		session.save(content);
		session.getTransaction().commit();           
		//使用openSession，当最后一个业务逻辑完成后必须关闭session           
		session.close();  
		return true;
	}

	@Override
	public boolean deleteContent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContent(com.zua.blog.entity.Content content) {
		// TODO Auto-generated method stub
		return false;
	}

}
