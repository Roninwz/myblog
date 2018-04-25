package com.zua.blog.entity;

import java.util.Date;

public class Good {
	private int id;
	private String chiContent;
	private Date date;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiContent() {
		return chiContent;
	}

	public void setChiContent(String chiContent) {
		this.chiContent = chiContent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Good(int id, String chiContent, Date date, String author) {
		super();
		this.id = id;
		this.chiContent = chiContent;
		this.date = date;
		this.author = author;
	}

	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}

}
