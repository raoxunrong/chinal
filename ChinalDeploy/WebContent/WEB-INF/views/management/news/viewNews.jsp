<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>钱隆网后台管理系统</title>
<link
	href="<c:url value="/resources/management/stylesheets/style.css" />"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div align="center">
		<table cellspacing="0" cellpadding="0" border="1" width="600">
			<tr>
				<td class="title" height="30" colspan="2" align="center">查看新闻 <input type="button"
						onclick="history.back()" value="返回"></td>
			</tr>
			<tr>
				<td class="title" height="30">标题：</td>
				<td class="data" height="30">${newsVO.title }</td>
			</tr>
			<tr>
				<td class="title" height="30">发布日期：</td>
				<td class="data" height="30">${newsVO.formatPublishedTime }</td>
			</tr>
			<tr>
				<td class="title" height="30">来源：</td>
				<td class="data" height="30">${newsVO.originSource }</td>
			</tr>
			<tr>
				<td class="title" height="30">所属分类：</td>
				<td class="data" height="30">${newsVO.categoryName }</td>
			</tr>
			<tr>
				<td class="title" height="30">热门：</td>
				<td class="data" height="30">
					<c:if test="${newsVO.hot==false}">
					否
					</c:if>
					<c:if test="${newsVO.hot==true}">
					是
					</c:if>
				</td>
			</tr>
			<tr>
			<td colspan="2">
				${newsVO.content }
			</td>
			</tr>
		</table>
	</div>
</body>
</html>