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
		<td class="title" height="30" colspan="2">查看用户信息</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">姓名:</td>
		<td class="data" height="30">${user.name }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">登录名:</td>
		<td class="data" height="30">${user.loginName }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">电话:</td>
		<td class="data" height="30">${user.phone }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">身份证号码:</td>
		<td class="data" height="30">${user.idCard }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">邮箱:</td>
		<td class="data" height="30">${user.email }</td>
	</tr>
	<tr>
		<td class="title" height="30" width="100">所属城市:</td>
		<td class="data" height="30">${city.name }</td>
	</tr>
</table>

<input type="button" onclick="history.back()" value="返回">
</div>
</body>
</html>
