package com.zua.blog.entity;

import java.util.Date;

public class Comment {
	private int id;
	private String content;
	private Article articleId;
	private Date date;
	private String ip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticleId() {
		return articleId;
	}

	public void setArticleId(Article articleId) {
		this.articleId = articleId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Comment(int id, String content, Article articleId, Date date, String ip) {
		super();
		this.id = id;
		this.content = content;
		this.articleId = articleId;
		this.date = date;
		this.ip = ip;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
