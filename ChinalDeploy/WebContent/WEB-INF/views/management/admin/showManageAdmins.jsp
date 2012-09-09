<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:useBean id="sessionPageSplit" scope="session"
	class="com.chinal.util.page.PageSplit" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>钱隆网后台管理系统</title>
<link
	href="<c:url value="/resources/management/stylesheets/style.css" />"
	rel="stylesheet" type="text/css">
</head>

<div align="center">
	<table width="600">
		<tr>
			<td colspan="4" align="right" height="30"><a
				href="<c:url value="/management/admin/addAdmin" />">增加新管理员</a></td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0" border="1" width="600">

		<tr>
			<td class="title" colspan="8" height="30">管理员列表(共有管理员${count}个)</td>
		</tr>
		<tr>
			<td class="header" align="center" height="30">管理员名称</td>
			<td class="header" align="center" height="30">登陆名</td>
			<td class="header" align="center" height="30">电话</td>
			<td class="header" align="center" height="30">超级管理员</td>
			<td class="header" colspan="5" align="center" height="30">操作</td>
		</tr>
		<c:forEach items="${adminList}" var="admin">
			<tr>
				<td class="data" align="center" height="30">${admin.name}</td>
				<td class="data" align="center" height="30">${admin.loginName}</td>
				<td class="data" align="center" height="30">${admin.phone}</td>
				<td class="data" align="center" height="30">
					<c:if test="${admin.superAdmin==false}">
							否
					</c:if> 
					<c:if test="${admin.superAdmin==true}">
							是
					</c:if>
				</td>
				<td class="data" align="center" height="30"><a
					href="<c:url value="/management/admin/viewAdmin?id=${admin.id}" />">查看</a></td>
				<td class="data" align="center" height="30"><a
					href="<c:url value="/management/admin/editAdmin?id=${admin.id}" />">编辑</a></td>
				<td class="data" align="center" height="30"><a
					href="<c:url value="/management/admin/delAdmin?id=${admin.id}" />"
					onclick="return confirm('该操作将删除该管理员${admin.name}的信息，确定执行吗？')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<%
		out.print(sessionPageSplit.getPageBar());
	%>
</div>

</html>
