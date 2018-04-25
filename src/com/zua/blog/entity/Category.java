package com.zua.blog.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private int id;
	private String chiName;
	private Set<Article> articles = new HashSet<>();

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiName() {
		return chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

	public Category(int id, String chiName, Set<Article> articles) {
		super();
		this.id = id;
		this.chiName = chiName;
		this.articles = articles;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
