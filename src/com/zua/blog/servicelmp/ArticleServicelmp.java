package com.zua.blog.servicelmp;

import java.util.List;

import com.zua.blog.dao.ArticleDao;
import com.zua.blog.entity.Article;
import com.zua.blog.service.ArticleService;

public class ArticleServicelmp implements ArticleService {
	private ArticleDao articleDAO;

	public ArticleDao getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDao articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean addArticle(Article article) {
		// TODO Auto-generated method stub
   
		return   articleDAO.addArticle(article);
	}

	@Override
	public boolean deleteArticle(int id) {
		// TODO Auto-generated method stub
		return articleDAO.deleteArticle(id);
	}

	@Override
	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDAO.updateArticle(article);
	}

	@Override
	public List<Article> showZuiXinArticle() {
		// TODO Auto-generated method stub
		return articleDAO.showZuiXinArticle();
	}

	@Override
	public List<Article> showReMenArticle() {
		// TODO Auto-generated method stub
		//System.out.println("Adl:" + articleDAO.showZuiXinArticle());
		return articleDAO.showReMenArticle();
	}

	@Override
	public Article selectArticle(int id) {

		return articleDAO.selectArticle(id);
	}

	@Override
	public List<Article> showAllArticle() {
		
		return articleDAO.showAllArticle();
	}

}
