package com.zua.blog.action;

import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zua.blog.entity.Article;
import com.zua.blog.entity.Category;
import com.zua.blog.entity.Content;
import com.zua.blog.service.ArticleService;
import com.zua.blog.service.CategoryService;
import com.zua.blog.service.ContentService;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private ArticleService articleService;
	private CategoryService categoryService;
	private ContentService contentService;
   private Article article=new Article();
	
	private ValueStack valueStack = ActionContext.getContext().getValueStack();


private String contents;
private int categorys;


	public ValueStack getValueStack() {
		return valueStack;
	}

	public void setValueStack(ValueStack valueStack) {
		this.valueStack = valueStack;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	public ContentService getContentService() {
		return contentService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}


	

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCategorys() {
		return categorys;
	}

	public void setCategorys(int categorys) {
		this.categorys = categorys;
	}

	
	public String index() {
		List<Article> articles = articleService.showZuiXinArticle();
		// System.out.println("ggg");
		// System.out.println(articles);
		// System.out.println(articles.size());
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		return "index_success";
	}

	
	public String showR() {
		return "showR_success";
	}

	public String showZ() {

		return "showZ_success";
	}

	public String selectArticle() {
		// String aid= ActionContext.getContext().getParameters().get("id");

		Article articles = articleService.selectArticle(article.getId());
		//Content con=articleService.
		// System.out.println("ggg");
		// System.out.println(articles);
		// System.out.println(articles.size());
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		return "selectArticle_success";
	}
	public String selectFront() {
		// System.out.println("wwww");
		List<Article> articles = categoryService.selectFrontCate();
		// System.out.println("wwww1");
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		// System.out.println("wwww2");
		//System.out.println(articles);
		return "selectFront_success";
	}
	public String selectBack() {
		List<Article> articles = categoryService.selectBackCate();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		return "selectBack_success";
	}
	public String selectBeau() {
		List<Article> articles = categoryService.selectBeauCate();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		return "selectBeau_success";
	}
	public String selectLife() {
		List<Article> articles = categoryService.selectLifeCate();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		List<Article> remenArticles=articleService.showReMenArticle();
		actionContext.put("remenArticles", remenArticles);
		return "selectLife_success";
	}
	
	public String addA(){
	List<Category> categories=categoryService.showCate();
	ActionContext actionContext = ActionContext.getContext();
	actionContext.put("categories", categories);
	
			return "addA_success";
	
	}
	public String addArticle(){
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date=new Date();
		Content c=new Content();
		Category ca=new Category();
		/*String decodeContent =  new String(Base64.decode(contents),"UTF-8");  */
		c.setContent(contents);
		boolean f2=contentService.addContent(c);
		article.setContent(c);
		article.setCreateDate(date);
		//article.setImgurl("img/");
		//article.setTop("1");
		ca=categoryService.selectOneCate(categorys);
		
		article.setCategory(ca);
		//System.out.println(article.getId());
		/*System.out.println(article.getCategory());
		System.out.println(article.getContent());
		System.out.println(article.getImgurl());
		System.out.println(article.getCreateDate());*/
		boolean f=articleService.addArticle(article);
		
		if(f){
			System.out.println("success");
			return "addArticle_success";
		
		}else {
			System.out.println("error");
			return "addArticle_error";
		}
		
	}
	public String deleteArticle(){
		boolean f=articleService.deleteArticle(article.getId());
		
		if(f){
			return "deleteArticle_success";
		}else {
			return "deleteArticle_error";
		}
		
	}
	public String updateA(){
		List<Category> categories=categoryService.showCate();
		//ActionContext actionContext = ActionContext.getContext();
		
		Article art = articleService.selectArticle(article.getId());
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("art", art);
		System.out.println(art.getAbstr());
		System.out.println(art.getKeywords());
		actionContext.put("categories", categories);
		return "updateA_success";
	}
	public String updateArticle(){
		boolean f=articleService.updateArticle(article);
		
		if(f){
			return "updateArticle_success";
		}else {
			return "updateArticle_error";
		}
		
	}
	
	public String showAllArticle(){
		List<Article> articles=articleService.showAllArticle();
		
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("articles", articles);
		
		return "show_success";
		
	}
}
