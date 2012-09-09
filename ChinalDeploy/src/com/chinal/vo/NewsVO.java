package com.chinal.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chinal.vo.base.ValueObject;

public class NewsVO extends ValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5272953048936165688L;

	private String title;

	private String content;

	private String abstractContent;

	private Date publishedTime;

	private long categoryId;
	
	private String categoryName;

	private String originSource;

	private boolean hot;

	private long publisherId;
	
	private String publisherName;

	private String picturePath;
	
	private String formatPublishedTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getFormatPublishedTime() {
		return new SimpleDateFormat( "yyyy-MM-dd HH:mm").format(publishedTime);
	}

}
