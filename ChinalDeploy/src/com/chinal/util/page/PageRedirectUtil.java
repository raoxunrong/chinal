package com.chinal.util.page;

import java.util.Map;

public class PageRedirectUtil {

	private static final String SUCCESS_PAGE = "/management/notice/successPage";
	
	public static String buildSuccessPage(String nextPageRequestUrl, Map<String, Object> model){
		model.put("nextpage", nextPageRequestUrl);
		return SUCCESS_PAGE;
	}
}
