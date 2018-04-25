package com.zua.blog.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zua.blog.entity.Category;
import com.zua.blog.service.CategoryService;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
	private CategoryService categoryService;
	// private Article article=new Article();
	// private Category category=new Category();
	private Category category = new Category();

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private ValueStack valueStack = ActionContext.getContext().getValueStack();

	public ValueStack getValueStack() {
		return valueStack;
	}

	public void setValueStack(ValueStack valueStack) {
		this.valueStack = valueStack;
	}

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String showCate() {

		// List<Category> categories=categoryService.showCate();
		// ActionContext atx = ActionContext.getContext();
		// Map<String, Object> session = atx.getSession();
		// session.put("categories", categories);
		return "show_success";
	}

}
