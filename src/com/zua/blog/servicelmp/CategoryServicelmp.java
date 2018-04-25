package com.zua.blog.servicelmp;

import java.util.List;

import com.zua.blog.dao.CategoryDao;
import com.zua.blog.entity.Article;
import com.zua.blog.entity.Category;
import com.zua.blog.service.CategoryService;

public class CategoryServicelmp implements CategoryService {
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Article> selectFrontCate() {

		return categoryDao.selectFrontCate();
	}

	@Override
	public List<Category> showCate() {

		return categoryDao.showCate();
	}

	@Override
	public Category selectOneCate(int id) {
		// TODO Auto-generated method stub
		return categoryDao.selectOneCate(id);
	}

	@Override
	public List<Article> selectBackCate() {
		// TODO Auto-generated method stub
		return categoryDao.selectBackCate();
	}

	@Override
	public List<Article> selectBeauCate() {
		// TODO Auto-generated method stub
		return categoryDao.selectBeauCate();
	}

	@Override
	public List<Article> selectLifeCate() {
		// TODO Auto-generated method stub
		return categoryDao.selectLifeCate();
	}

}
