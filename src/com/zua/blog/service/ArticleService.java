package com.zua.blog.service;

import java.util.List;

import com.zua.blog.entity.Article;

public interface ArticleService {
	public boolean addArticle(Article article);

	public boolean deleteArticle(int id);

	public boolean updateArticle(Article article);

	public List<Article> showZuiXinArticle();

	public List<Article> showReMenArticle();
	
	public List<Article> showAllArticle();
	
	public Article selectArticle(int id);
}
