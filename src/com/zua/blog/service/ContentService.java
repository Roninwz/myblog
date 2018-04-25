package com.zua.blog.service;

import com.zua.blog.entity.Content;

public interface ContentService {
	
	  public boolean addContent(Content content);
	  public boolean deleteContent(int id);
	  public boolean updateContent(Content content);
}
