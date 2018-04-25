package com.zua.blog.servicelmp;

import com.zua.blog.dao.ContentDao;
import com.zua.blog.entity.Content;
import com.zua.blog.service.ContentService;

public class ContentServicelmp implements ContentService{
	private ContentDao contentDao;
	
	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	@Override
	public boolean addContent(Content content) {
		// TODO Auto-generated method stub
		return contentDao.addContent(content);
	}

	@Override
	public boolean deleteContent(int id) {
		// TODO Auto-generated method stub
		return contentDao.deleteContent(id);
	}

	@Override
	public boolean updateContent(Content content) {
		// TODO Auto-generated method stub
		return contentDao.updateContent(content);
	}

}
