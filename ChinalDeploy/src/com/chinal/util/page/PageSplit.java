package com.chinal.util.page;

import javax.servlet.http.*;

import java.net.URLEncoder;
import java.util.*;

public class PageSplit {
	public static final int PAGE_DEFAULT_SIZE = 20;
	
	private static final String firstPage = "首页";
	private static final String nextPage = "下页";
	private static final String prePage = "上页";
	private static final String lastPage = "末页";
	
	private String m_pageTj = "";
	private String m_pageTjField = "";
	private String m_sortBy = "";
	private String m_fixedSortBy = "";
	private boolean m_fixedSortByPos = true;
	private String m_upDown = "";
	private String m_prg = "";
	private int m_pageSize = 0;
	private int m_curPage = 0;
	private int m_pageCount = 0;
	private int m_recordCount = 0;
	
	protected String setInputField(String name, String val) {
		return "<input name='" + name + "' type='hidden' id='" + name
				+ "' value='" + val + "'>";
	}
	
	/*
	public void setAction(String action){
		this.m_prg=action;
	}
	*/
	
	public int getPageSize(){
		return this.m_pageSize;
	}
	
	public int getCurPage(){
		return this.m_curPage;
	}

	public void init(HttpServletRequest request){
		init(PAGE_DEFAULT_SIZE, request);
	}
	
	public void init(int defPageSize, HttpServletRequest request) {

		if (defPageSize <= 0)
			setPageSize(PAGE_DEFAULT_SIZE, request);
		else
			setPageSize(defPageSize, request);

		try {
			m_curPage = Integer.parseInt(request.getParameter("page"), 10);
		} catch (NumberFormatException e) {
			m_curPage = 1;
		}
		if (m_curPage < 1)
			m_curPage = 1;

		m_sortBy = request.getParameter("sortby");
		if (m_sortBy == null)
			m_sortBy = "";

		String upDown = request.getParameter("updown");
		if (upDown != null)
			m_upDown = upDown;// "asc";

		getPageTj(request);

		m_prg = request.getRequestURI();

		m_fixedSortBy = "";

	}

	protected String getPageTj(HttpServletRequest request) {
		m_pageTj = "";
		m_pageTjField = "";
		String key, val;
		Enumeration e = request.getParameterNames();

		while (e.hasMoreElements()) {
			key = ((String) e.nextElement());
			val = request.getParameter(key);
			if (val == null)	val = "";			
			if (!key.equalsIgnoreCase("pagesize")
					&& !key.equalsIgnoreCase("page")) {
				m_pageTjField += setInputField(key, val);
				if (!key.equalsIgnoreCase("sortby")
						&& !key.equalsIgnoreCase("updown"))
					m_pageTj += key + "=" + URLEncoder.encode(val) + "&";
			}
		}
		if (m_pageTj != "")
			m_pageTj = m_pageTj.substring(0, m_pageTj.length() - 1);
		else
			m_pageTj = "tj=1";
		return m_pageTj;
	}

	public void setFixedOrderBy(String sortStr, boolean isHead) {
		m_fixedSortBy = sortStr;
		m_fixedSortByPos = isHead;

	}

	public String setOrderBy(String mysql, String defField) {
		if (m_sortBy == "" || m_sortBy == null) {
			m_sortBy = defField;
			// m_upDown="";
		}
		if (m_upDown == "" || m_upDown == null)
			m_upDown = "asc";
		if (m_fixedSortBy == null || m_fixedSortBy == "") {
			if (m_sortBy != "")
				return mysql + " order by " + m_sortBy + " " + m_upDown;
			else
				return mysql;
		} else {
			if (m_sortBy != "") {
				if (m_fixedSortByPos)
					return mysql + " order by " + m_fixedSortBy + ","
							+ m_sortBy + " " + m_upDown;
				else
					return mysql + " order by " + m_sortBy + " " + m_upDown
							+ "," + m_fixedSortBy;
			} else
				return mysql + m_fixedSortBy;
		}

	}

	public String setOrderBy(String mysql, String defField, String upDown) {
		String upDown1 = "";
		upDown1 = upDown.toLowerCase();
		if (m_sortBy == "" || m_sortBy == null) {
			m_sortBy = defField;
			m_upDown = upDown1;
		} else if ((m_upDown == "" || m_upDown == null)
				&& (upDown1.equals("asc") || upDown1.equals("desc")))
			m_upDown = upDown1;
		if (m_upDown == "" || m_upDown == null)
			m_upDown = "asc";
		if (m_fixedSortBy == null || m_fixedSortBy == "") {
			if (m_sortBy != "")
				return mysql + " order by " + m_sortBy + " " + m_upDown;
			else
				return mysql;
		} else {
			if (m_sortBy != "") {
				if (m_fixedSortByPos)
					return mysql + " order by " + m_fixedSortBy + ","
							+ m_sortBy + " " + m_upDown;
				else
					return mysql + " order by " + m_sortBy + " " + m_upDown
							+ "," + m_fixedSortBy;
			} else
				return mysql + m_fixedSortBy;
		}

	}

	public String setOrderTitle(String fieldName, String fieldTit, String tips) {
		String tmpPrg, updown;
		String res = "";
		updown = m_upDown;
		if (m_sortBy.equalsIgnoreCase(fieldName)) {
			if (m_upDown.equalsIgnoreCase("asc"))
				res = "↑";
			else
				res = "↓";
			if (updown.equalsIgnoreCase("asc"))
				updown = "desc";
			else
				updown = "asc";
		}
		tmpPrg = m_prg + "?" + m_pageTj + "&updown=" + updown;
		return res + "<a href=" + tmpPrg + "&sortby=" + fieldName + "&page="
				+ m_curPage + " title='" + tips + "'><font color=ffffff><u>"
				+ fieldTit + "</u></font></a> ";
	}

	public String setOrderTitle(String fieldName, String fieldTit, String tips,
			String foreColor) {
		String tmpPrg, updown;
		String res = "";
		updown = m_upDown;
		if (m_sortBy.equalsIgnoreCase(fieldName)) {
			if (m_upDown.equalsIgnoreCase("asc"))
				res = "↑";
			else
				res = "↓";
			if (updown.equalsIgnoreCase("asc"))
				updown = "desc";
			else
				updown = "asc";
		}
		tmpPrg = m_prg + "?" + m_pageTj + "&updown=" + updown;
		return res + "<a href=" + tmpPrg + "&sortby=" + fieldName + "&page="
				+ m_curPage + " title='" + tips + "'><font color=" + foreColor
				+ "><u>" + fieldTit + "</u></font></a> ";
	}

	protected int setPageSize(int defPageSize, HttpServletRequest request) {
		int pageSize;
		try {
			pageSize = Integer.parseInt(request.getParameter("pagesize"), 10);
		} catch (NumberFormatException e) {
			pageSize = m_pageSize;
			if (pageSize == 0)
				pageSize = defPageSize;
		}

		if (pageSize < 1)
			pageSize = 1;
		else if (pageSize > 500)
			pageSize = 500;
		m_pageSize = pageSize;
		return m_pageSize;
	}

	public int splitPage(int recordCount) {
		m_recordCount = recordCount;
		m_pageCount = m_recordCount / m_pageSize;
		if (m_recordCount % m_pageSize != 0)
			m_pageCount++;

		if (m_curPage > m_pageCount)
			m_curPage = m_pageCount;

		return m_curPage;
	}

	public String getPageBar(){
		return getPageBar("");
	}
	
	public String getBar(String width){
		return getPageBar(width, "", false, true);
	}
	
	public String getPageBar(String bgColor) {
		return getPageBar("600", bgColor, false, true);
	}

	public String getPageBar(String bgColor, boolean isSimple) {
		return getPageBar("600", bgColor, isSimple, true);
	}
	
	public String getPageBar(String width, String bgColor, boolean isSimple, boolean isVisible) {
		String pagePrg;
		String res;

		pagePrg = m_prg + "?" + m_pageTj + "&sortby=" + m_sortBy;
		
		if (!isVisible)
			res = "<table style='display:none' id=pageTab ";
		else
			res = "<table  ";
		res += "width=\" " + width + "\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\"center\">";
		if (bgColor != "")
			res += " bgcolor=" + bgColor + ">";

		res += "<form name='pageFm' method=get action=" + m_prg + ">";
		res += "<tr><td  nowrap height=\"25\">";
		if (m_curPage > 1)
			res += "<a href=" + pagePrg + "&page=1> " + firstPage + "</a> ";
		else
			res += "<font color=\"888888\">" + firstPage + "</font> ";

		if (m_curPage > 1)
			res += "<a href=" + pagePrg + "&page=" + (m_curPage - 1)
					+ ">" + prePage + "</a> ";
		else
			res += "<font color=\"888888\">" + prePage + "</font> ";

		if (m_curPage < m_pageCount)
			res += "<a href=" + pagePrg + "&page=" + (m_curPage + 1)
					+ " >" + nextPage + "</a> ";
		else
			res += "<font color=\"888888\">" + nextPage + "</font> ";

		if (m_curPage < m_pageCount)
			res += "<a href=" + pagePrg + "&page=" + m_pageCount + ">" + lastPage + "</a> ";
		else
			res += "<font color=\"888888\">" + lastPage + "</font> ";
		res += "页次<font color=cc3300>" + m_curPage + "/" + m_pageCount
				+ "</font>页 共<font color=cc3300>" + m_recordCount
				+ "</font>条记录</td>";
		if (!isSimple) {
			res += "<td id=printPage  nowrap width=200 align=right >每页:<INPUT name=pagesize style='border: 1px ridge #000000;'  onchange='javascript:page.value=1' value="
					+ m_pageSize + " size=3 maxLength=3>";
			res += "转到:<INPUT name=page style='border: 1px ridge #000000;' value="
					+ m_curPage + " size=3 maxLength=3 >";
			res += " <input  type=submit value=翻页 name=button2 class=PageButton onMouseOver=\"this.className='PageButtonHover'\" onMouseOut=\"this.className='PageButton'\">";
			res += m_pageTjField + "</td>";
		}
		res += "</tr></form></table>";
		return res;
	}

	public String setOrderField() {
		String res;
		res = "<input name='sortby' type='hidden' id='sortby' value='"
				+ m_sortBy + "'>";
		res += "<input name='updown' type='hidden' id='updown' value='"
				+ m_upDown + "'>";
		return res;
	}
	
	public int getRecordCount(){
		return this.m_recordCount;
	}
}