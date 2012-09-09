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
	rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
<form:form commandName="adminVO" action="editAdmin" method="post" >
	<font color="red"><form:errors path="*" /></font>
	<table cellspacing="0" cellpadding="0" border="1" width="600">
		<tr>
			<td class="title" height="30" colspan="2" align="center">编辑管理员信息</td>
		</tr>
		<tr>
			<td class="title" height="30">登录名：</td>
			<td class="data" height="30"><form:input path="loginName" /><font
				color="red"><form:errors path="loginName" /></font></td>
		</tr>
		<tr>
			<td class="title" height="30">姓名：</td>
			<td class="data" height="30"><form:input path="name" /><form:errors
				path="name" /></td>
		</tr>
		<tr>
			<td class="title" height="30">电话：</td>
			<td class="data" height="30"><form:input path="phone" /><form:errors
				path="email" /></td>
		</tr>
		<tr>
			<td class="title" height="30">邮箱：</td>
			<td class="data" height="30"><form:input path="email" /><form:errors
				path="email" /></td>
		</tr>
		<tr>
			<td class="title" height="30">是否超级管理员：</td>
			<td class="data" height="30"><form:select path="superAdmin">
				<form:option value="true">是</form:option>
				<form:option value="false">否</form:option>
			</form:select></td>
		</tr>
		<form:hidden path="password" />
		<form:hidden path="id" />
		<tr>
			<td class="title" height="30">操作：</td>
			<td class="data" height="30">&nbsp;&nbsp; <input type="submit"
				value="确定">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
				onclick="history.back()" value="返回"></td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>
