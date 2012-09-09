package com.chinal.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinal.dao.NewsCategoryDao;
import com.chinal.dao.NewsDao;
import com.chinal.domain.Admin;
import com.chinal.domain.News;
import com.chinal.domain.NewsCategory;
import com.chinal.service.base.PageSplitService;
import com.chinal.util.DBFormatConvertUtil;
import com.chinal.util.param.Parameters;
import com.chinal.vo.NewsCategoryVO;
import com.chinal.vo.NewsVO;

@Service
public class NewsService implements PageSplitService<NewsVO>{

	@Autowired
	private NewsCategoryDao newsCategoryDao;
	
	@Autowired
	private NewsDao newsDao;
	
	public List<NewsCategoryVO> getAllNewsCategory(){
		List<NewsCategory> categories = newsCategoryDao.find(new Parameters());
		List<NewsCategoryVO> categoryVOList = new ArrayList<NewsCategoryVO>();
		for(NewsCategory category : categories){
			categoryVOList.add(convertToNewsCategoryVO(category));
		}
		
		return categoryVOList;
	}
	
	public void addNewsCategory(NewsCategoryVO newsCategoryVO) {
		newsCategoryDao.save(convertToNewsCategory(newsCategoryVO));
	}
	
	public void deleteNewsCategory(long id) {
		newsCategoryDao.delete(new NewsCategory(id));
		
	}
	
	public NewsCategoryVO getNewsCategory(long id) {
		NewsCategory newsCategory = newsCategoryDao.getByID(id);
		return convertToNewsCategoryVO(newsCategory);
	}
	
	public void update(NewsCategoryVO newsCategory) {
		newsCategoryDao.update(convertToNewsCategory(newsCategory));
	}
	
	@Override
	public long getTotalCount() {
		return newsDao.getCount(new Parameters());
	}

	@Override
	public List<NewsVO> getByPageSplit(int curPage, int pageSize) {
		Parameters parameters = new Parameters();
		List<News> newsList = newsDao.find(parameters, curPage, pageSize);
		
		List<NewsVO> newsVOList = new ArrayList<NewsVO>();
		
		for(News news : newsList){
			try {
				newsVOList.add(convertToNewsVO(news));
			} catch (IOException e) {
				// TODO Need modify
			}
		}
		
		return newsVOList;
	}
	
	@Override
	public void add(NewsVO newsVO) {
		newsVO.setPublishedTime(Calendar.getInstance().getTime());
		try {
			newsDao.save(convertToNews(newsVO));
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public NewsVO getByID(long id) {
		List<News> news = newsDao.find("from News news left outer join fetch news.category left outer join fetch news.publisher where news.id=" + id);
		NewsVO convertToNewsVO = null;
		try {
			 convertToNewsVO = convertToNewsVO(news.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToNewsVO;
	}
	
	@Override
	public void update(NewsVO newsVO) {
		newsVO.setPublishedTime(Calendar.getInstance().getTime());
		try {
			newsDao.update(convertToNews(newsVO));
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteByID(long id) {
		newsDao.delete(new News(id));
	}
	
	private News convertToNews(NewsVO newsVO) throws SerialException, SQLException {
		News news = new News();
		news.setId(newsVO.getId());
		news.setTitle(newsVO.getTitle());
		news.setContent(DBFormatConvertUtil.convertStringToClob(newsVO.getContent()));
		news.setAbstractContent(newsVO.getAbstractContent());
		news.setPublishedTime(newsVO.getPublishedTime());
		news.setCategory(new NewsCategory(newsVO.getCategoryId()));
		news.setOriginSource(newsVO.getOriginSource());
		news.setHot(newsVO.isHot());
		news.setPublisher(new Admin(newsVO.getPublisherId()));
		news.setPicturePath(newsVO.getPicturePath());
		return news;
	}

	private NewsVO convertToNewsVO(News news) throws IOException {
		NewsVO newsVO = new NewsVO();
		newsVO.setId(news.getId());
		newsVO.setTitle(news.getTitle());
		newsVO.setContent(DBFormatConvertUtil.convertClobToString(news.getContent()));
		newsVO.setAbstractContent(news.getAbstractContent());
		newsVO.setPublishedTime(news.getPublishedTime());
		newsVO.setCategoryId(news.getCategory().getId());
		newsVO.setCategoryName(news.getCategory().getName());
		newsVO.setOriginSource(news.getOriginSource());
		newsVO.setHot(news.isHot());
		newsVO.setPublisherId(news.getPublisher().getId());
		newsVO.setPublisherName(news.getPublisher().getName());
		newsVO.setPicturePath(news.getPicturePath());
		return newsVO;
	}

	private NewsCategoryVO convertToNewsCategoryVO(NewsCategory newsCategory){
		NewsCategoryVO newsCategoryVO = new NewsCategoryVO();
		newsCategoryVO.setId(newsCategory.getId());
		newsCategoryVO.setName(newsCategory.getName());
		newsCategoryVO.setDescription(newsCategory.getDescription());
		return newsCategoryVO;
	}

	private NewsCategory convertToNewsCategory(NewsCategoryVO newsCategoryVO){
		NewsCategory newsCategory = new NewsCategory();
		newsCategory.setId(newsCategoryVO.getId());
		newsCategory.setName(newsCategoryVO.getName());
		newsCategory.setDescription(newsCategoryVO.getDescription());
		return newsCategory;
	}

}
