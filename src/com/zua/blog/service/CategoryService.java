package com.zua.blog.service;

import java.util.List;

import com.zua.blog.entity.Article;
import com.zua.blog.entity.Category;

public interface CategoryService {
	public List<Article> selectFrontCate();

	public List<Article> selectBackCate();
	
	public List<Article> selectBeauCate();
	
	public List<Article> selectLifeCate();
	
	public List<Category> showCate();
	
	public Category selectOneCate(int id);
}
