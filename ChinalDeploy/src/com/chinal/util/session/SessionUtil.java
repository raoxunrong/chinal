package com.chinal.util.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.WebRequest;

import com.chinal.util.page.PageSplit;
import com.chinal.vo.AdminVO;

public class SessionUtil {

	public static final String Session_Admin = "sessionAdmin";
	public static final String Session_PageSplit = "sessionPageSplit";
	
	public static PageSplit getPageSplitFromSession(HttpServletRequest request){
		
		PageSplit pageSplit = (PageSplit)request.getSession().getAttribute(Session_PageSplit);
		if(pageSplit == null){
			pageSplit = new PageSplit();
		}
		
		pageSplit.init(request);
		return pageSplit;
	}
	
	public static void updatePageSplitInSession(HttpServletRequest request, PageSplit pageSplit){
		request.getSession().setAttribute(Session_PageSplit, pageSplit);
	}

	public static void putAdminToSession(WebRequest request, AdminVO admin) {
		putAttributeToSession(request, Session_Admin, admin);
	}
	
	public static AdminVO getAdminFromSession(WebRequest request){
		return (AdminVO)request.getAttribute(Session_Admin, WebRequest.SCOPE_SESSION);
	}

	public static void removeAdminFromSession(WebRequest request) {
		removeAttributeFromSession(request, Session_Admin);
	}

	public static void putAttributeToSession(WebRequest request,
			String attributeName, Object value) {
		request.setAttribute(attributeName, value, WebRequest.SCOPE_SESSION);
	}

	public static void removeAttributeFromSession(WebRequest request,
			String attributeName) {
		request.removeAttribute(attributeName, WebRequest.SCOPE_SESSION);
	}
}
