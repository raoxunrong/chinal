package com.chinal.controller.management.news;

import static com.chinal.util.session.SessionUtil.getPageSplitFromSession;
import static com.chinal.util.session.SessionUtil.updatePageSplitInSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.chinal.service.NewsService;
import com.chinal.util.page.PageRedirectUtil;
import com.chinal.util.page.PageSplit;
import com.chinal.util.session.SessionUtil;
import com.chinal.vo.AdminVO;
import com.chinal.vo.NewsCategoryVO;
import com.chinal.vo.NewsVO;

@Controller
@RequestMapping("/management/news/*")
public class NewsController {
	
	private static final String SHOW_MANAGE_CATEGORY = "management/news/manageCategory";
	private static final String SHOW_ADD_CATEGORY = "management/news/addCategory";
	private static final String SHOW_EDIT_CATEGORY = "management/news/editCategory";
	
	private static final String SHOW_MANAGE_NEWS = "management/news/manageNews";
	private static final String SHOW_PUBLISH_NEWS = "management/news/publishNews";
	private static final String SHOW_VIEW_NEWS = "management/news/viewNews";
	private static final String SHOW_EDIT_NEWS = "management/news/editNews";
	
	@Autowired
	private NewsService newsService; 

	@RequestMapping(value = "/manageCategory")
	public String showManageCategoryPage(Map<String, Object> model){
		List<NewsCategoryVO> allNewsCategory = newsService.getAllNewsCategory();
		model.put("allNewsCategory", allNewsCategory);
		model.put("count", allNewsCategory.size());
		return SHOW_MANAGE_CATEGORY;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String showAddCategoryPage(Map<String, Object> model){
		model.put("newsCategoryVO", new NewsCategoryVO());
		return SHOW_ADD_CATEGORY;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(@Valid NewsCategoryVO newsCategoryVO, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_ADD_CATEGORY;
		}
		
		newsService.addNewsCategory(newsCategoryVO);
		
		return PageRedirectUtil.buildSuccessPage("/management/news/manageCategory", model);
	}
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.GET, params="id")
	public String showEditCategoryPage(Map<String, Object> model, @RequestParam String id){
		
		NewsCategoryVO category = newsService.getNewsCategory(Long.parseLong(id));
		model.put("newsCategoryVO", category);
		return SHOW_EDIT_CATEGORY;
	}
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.POST)
	public String editCategory(@Valid NewsCategoryVO newsCategory, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_EDIT_CATEGORY;
		}
		
		newsService.update(newsCategory);
		return PageRedirectUtil.buildSuccessPage("/management/news/manageCategory", model);
	}
	
	@RequestMapping(value = "/delCategory", params="id")
	public String deleteCategory(Map<String, Object> model, @RequestParam String id){
		newsService.deleteNewsCategory(Long.parseLong(id));
		
		return PageRedirectUtil.buildSuccessPage("/management/news/manageCategory", model);
	}
	
	@RequestMapping(value = "/manageNews")
	public String showManageNewsPage(HttpServletRequest request,Map<String, Object> model) throws IOException{
		initShowNewsPageWithParamaters(request, model);
		return SHOW_MANAGE_NEWS;
	}
	
	@RequestMapping(value = "/publishNews", method = RequestMethod.GET)
	public String showPublishNewsPage(Map<String, Object> model){
		model.put("newsVO", new NewsVO());
		initNewsCategory(model);
		return SHOW_PUBLISH_NEWS;
	}

	@RequestMapping(value = "/publishNews", method = RequestMethod.POST)
	public String publishNews(@Valid NewsVO newsVO, BindingResult result, Map<String, Object> model, WebRequest request){
		
		if (result.hasErrors()) {
			return SHOW_PUBLISH_NEWS;
		}
		
		AdminVO adminFromSession = SessionUtil.getAdminFromSession(request);
		newsVO.setPublisherId(adminFromSession.getId());
		newsService.add(newsVO);
		
		return PageRedirectUtil.buildSuccessPage("/management/news/manageNews", model);
	}
	
	@RequestMapping(value = "/viewNews", params="id")
	public String viewNews(@RequestParam String id, Map<String, Object> model){
		try {
			NewsVO news = newsService.getByID(Long.parseLong(id));
			model.put("newsVO", news);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		} 
		return SHOW_VIEW_NEWS;
	}
	
	@RequestMapping(value = "/editNews", params="id", method = RequestMethod.GET)
	public String editNews(@RequestParam String id, Map<String, Object> model){
		try {
			NewsVO news = newsService.getByID(Long.parseLong(id));
			initNewsCategory(model);
			model.put("newsVO", news);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		} 
		return SHOW_EDIT_NEWS;
	}
	
	@RequestMapping(value = "/editNews", method = RequestMethod.POST)
	public String editNews(@Valid NewsVO news, WebRequest request, BindingResult result, Map<String, Object> model){
		
		if (result.hasErrors()) {
			return SHOW_EDIT_NEWS;
		}
		
		AdminVO adminFromSession = SessionUtil.getAdminFromSession(request);
		news.setPublisherId(adminFromSession.getId());
		newsService.update(news);
		return PageRedirectUtil.buildSuccessPage("/management/news/manageNews", model);
	}
	
	@RequestMapping(value = "/delNews", params="id")
	public String deleteNews(Map<String, Object> model, @RequestParam String id){
		newsService.deleteByID(Long.parseLong(id));
		return PageRedirectUtil.buildSuccessPage("/management/news/manageNews", model);
	}

	private void initShowNewsPageWithParamaters(HttpServletRequest request,
			Map<String, Object> model) throws IOException {
		PageSplit pageSplitFromSession = getPageSplitFromSession(request);

		long count = newsService.getTotalCount();
		List<NewsVO> newsList = newsService.getByPageSplit(
				pageSplitFromSession.getCurPage(),
				pageSplitFromSession.getPageSize());

		model.put("newsList", newsList);

		pageSplitFromSession.splitPage((int) count);
		updatePageSplitInSession(request, pageSplitFromSession);
	}
	
	private void initNewsCategory(Map<String, Object> model) {
		List<NewsCategoryVO> allNewsCategory = newsService.getAllNewsCategory();
		model.put("allCategory", allNewsCategory);
	}
}
