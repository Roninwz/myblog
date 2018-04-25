package com.zua.blog.entity;

import java.util.Date;

public class Article {


	private int id;// 
	private Content content;
	private String title;//
	private String abstr;// 
	private Category category;
	private String imgurl;
	private Date createDate;//
	private String top;// 
	private String keywords;//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstr() {
		return abstr;
	}

	public void setAbstr(String abstr) {
		this.abstr = abstr;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	

	

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Article(int id, Content content, String title, String abstr, Category category, String imgurl,
			Date createDate, String top, String keywords) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.abstr = abstr;
		this.category = category;
		this.imgurl = imgurl;
		this.createDate = createDate;
		this.top = top;
		this.keywords = keywords;
	}

	public Article() {

		super();
		// TODO Auto-generated constructor stub
	}

}
