package com.chinal.domain;

import java.sql.Clob;
import java.util.Date;

import com.chinal.domain.base.DomainObj;

public class News extends DomainObj {

	private String title;
	
	private Clob content;
	
	private String abstractContent;
	
	private Date publishedTime;
	
	private NewsCategory category;
	
	private String originSource;
	
	private boolean hot;
	
	private Admin publisher;
	
	private String picturePath;

	public News() {
		super();
	}

	public News(long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Clob getContent() {
		return content;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	public String getAbstractContent() {
		return abstractContent;
	}

	public void setAbstractContent(String abstractContent) {
		this.abstractContent = abstractContent;
	}

	public Date getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	public NewsCategory getCategory() {
		return category;
	}

	public void setCategory(NewsCategory category) {
		this.category = category;
	}

	public Admin getPublisher() {
		return publisher;
	}

	public void setPublisher(Admin publisher) {
		this.publisher = publisher;
	}

	public String getOriginSource() {
		return originSource;
	}

	public void setOriginSource(String originSource) {
		this.originSource = originSource;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
