<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link
	href="<c:url value="/resources/management/stylesheets/style.css" />"
	rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>钱隆网后台管理系统</title>
</head>
<body>
<div align="center">
<table cellspacing="0" cellpadding="0" border="1" width="600">
	<tr>
		<td class="title" height="30" colspan="2">查看管理员信息</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">姓名:</td>
		<td class="data" height="30">${admin.name }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">登录名:</td>
		<td class="data" height="30">${admin.loginName }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">电话:</td>
		<td class="data" height="30">${admin.phone }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">邮箱:</td>
		<td class="data" height="30">${admin.email }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">超级管理员:</td>
		<td class="data" height="30">
			<c:if test="${admin.superAdmin==false}">
					否
			</c:if> 
			<c:if test="${admin.superAdmin==true}">
					是
			</c:if>
		</td>
	</tr>
</table>

<input type="button" onclick="history.back()" value="返回">
</div>
</body>
</html>
