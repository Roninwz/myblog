package com.zua.blog.daolmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zua.blog.dao.CategoryDao;
import com.zua.blog.entity.Article;
import com.zua.blog.entity.Category;

public class CategoryDaolmp implements CategoryDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Article> selectFrontCate() {
		List<Article> articles = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chiName", "前端技术");
		Session session = sessionFactory.openSession();
		Category category = (Category) session.createQuery("from Category where chiName = :chiName")
				.setParameter("chiName", map.get("chiName")).uniqueResult();
		System.out.println("entities:" + category);
		for (Article article : category.getArticles()) {
			System.out.println(article.getId());
			articles.add(article);
		}
		// List<Article> articles=(List<Article>) category.getArticles();
		session.close();  
		return articles;
	}

	@Override
	public List<Category> showCate() {
		Session session = sessionFactory.openSession();
		List<Category> entities = session.createQuery("from Category ").list();
		
		session.close();  
		return entities;
	}

	@Override
	public Category selectOneCate(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Session session = sessionFactory.openSession();
		Category category= (Category) session.createQuery("from Category where id = :id").setParameter("id", map.get("id")).uniqueResult();
		session.close();  
		return category;
	}

	@Override
	public List<Article> selectBackCate() {
		List<Article> articles = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chiName", "后端程序");
		Session session = sessionFactory.openSession();
		Category category = (Category) session.createQuery("from Category where chiName = :chiName")
				.setParameter("chiName", map.get("chiName")).uniqueResult();
		
		for (Article article : category.getArticles()) {
			articles.add(article);
		}
		session.close();  
		return articles;
	}

	@Override
	public List<Article> selectBeauCate() {
		List<Article> articles = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chiName", "美文推荐");
		Session session = sessionFactory.openSession();
		Category category = (Category) session.createQuery("from Category where chiName = :chiName")
				.setParameter("chiName", map.get("chiName")).uniqueResult();
		
		for (Article article : category.getArticles()) {
			articles.add(article);
		}
		session.close();  
		return articles;
	}

	@Override
	public List<Article> selectLifeCate() {
		List<Article> articles = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chiName", "我的人生");
		Session session = sessionFactory.openSession();
		Category category = (Category) session.createQuery("from Category where chiName = :chiName")
				.setParameter("chiName", map.get("chiName")).uniqueResult();
		
		for (Article article : category.getArticles()) {
			articles.add(article);
		}
		session.close();  
		return articles;
	}

}
