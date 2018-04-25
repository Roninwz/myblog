package com.zua.blog.daolmp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zua.blog.dao.ArticleDao;
import com.zua.blog.entity.Article;
import com.zua.blog.entity.Category;
import com.zua.blog.entity.Content;

public class ArticleDaolmp implements ArticleDao {
	private SessionFactory sessionFactory;
	// private static final ThreadLocal<Session> threadLocal = new
	// ThreadLocal<Session>(); //定义ThreadLocal对象

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addArticle(Article article) {
		//Content co=new Content();
		//Category ca=new Category();
		
		Session session = sessionFactory.openSession();
		//开启事务           
		session.beginTransaction();
		//co.setContent(article.getContent().getContent());
		
		//session.save(co);
		//article.setContent(co);
		System.out.println(article.getTitle());
		System.out.println(article.getAbstr());
		System.out.println(article.getImgurl());
		System.out.println(article.getKeywords());
		System.out.println(article.getCategory());
		System.out.println(article.getCategory().getChiName());
		System.out.println(article.getCategory().getId());
		System.out.println(article.getContent());
		System.out.println(article.getContent().getId());
		System.out.println(article.getContent().getContent());
		System.out.println(article.getCreateDate());
		System.out.println(article.getTop());
		//System.out.println(article.getTitle());
		
		//Content co=session.load(Content.class, 8);
		//Category ca=session.load(Category.class, 1);
		//article.setContent(co);
		//article.se
		session.save(article);
		session.getTransaction().commit();           
		//使用openSession，当最后一个业务逻辑完成后必须关闭session           
		session.close();  
		return true;
	}

	@Override
	public boolean deleteArticle(int id) {
		Session session = sessionFactory.openSession();
		Article article = new Article();
		article.setId(id);
		session.delete(article);
		session.close();
		return true;
	}

	@Override
	public boolean updateArticle(Article article) {
		Session session = sessionFactory.openSession();
		session.update(article);
		session.close();
		return true;
	}

	@Override
	public List<Article> showZuiXinArticle() {
		// TODO Auto-generated method stub
		/*
		 * Configuration cf=new Configuration().configure();
		 * 
		 * sessionFactory=cf.buildSessionFactory();
		 */

		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		// Query query = session.createQuery("from Article");;
		// System.out.println("query:"+query);
		// List<Article> entities =query.getResultList() ;
		List<Article> entities = session.createQuery("from Article").list();
		// System.out.println("entities:"+entities);
		/*
		 * for (Article article:entities) { System.out.println(article.getId());
		 * }
		 */

		 session.close();
		// sessionFactory.close();
		return entities;

	}

	@Override
	public List<Article> showReMenArticle() {
		Session session = sessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("top", "1");
		List<Article> entities = session.createQuery("from Article where top = :top").setParameter("top", map.get("top")).list();
		session.close();
		return entities;
	}

	@Override
	public Article selectArticle(int id) {
		// Article article=new Article();
		Session session = sessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Article article = (Article) session.createQuery("from Article where id = :id").setParameter("id", map.get("id")).uniqueResult();
		//System.out.println("article:" + article);
		Content co=new Content();
		co.setContent(article.getContent().getContent());
		//System.out.println();
		session.close();
		return article;
	}

	@Override
	public List<Article> showAllArticle() {
		Session session = sessionFactory.openSession();
		List<Article> articles = session.createQuery("from Article").list();
		session.close();
		return articles;
	}
}
