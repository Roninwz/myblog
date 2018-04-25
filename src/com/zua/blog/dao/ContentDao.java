package com.zua.blog.dao;

import com.zua.blog.entity.Content;

public interface ContentDao {
	
	
  public boolean addContent(Content content);
  public boolean deleteContent(int id);
  public boolean updateContent(Content content);
}
