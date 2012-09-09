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
<form:form commandName="cityVO" action="addCity" method="post" >
	<font color="red"><form:errors path="*" /></font>
	<table cellspacing="0" cellpadding="0" border="1" width="600">
		<tr>
			<td class="title" height="30" colspan="2" align="center">添加城市信息</td>
		</tr>
		<tr>
			<td class="title" height="30">所属省份：</td>
			<td class="data" height="30">${province.name }</td>
		</tr>
		<tr>
			<td class="title" height="30">城市名：</td>
			<td class="data" height="30"><form:input path="name" /><font
				color="red"><form:errors path="name" /></font></td>
		</tr>
		<tr>
			<td class="title" height="30">描述：</td>
			<td class="data" height="30"><form:textarea path="description" cols="50" rows="6" /><form:errors
				path="name" /></td>
		</tr>
		<form:hidden path="provinceId" />
		<tr>
			<td class="title" height="30">操作：</td>
			<td class="data" height="30">&nbsp;&nbsp; <input type="submit"
				value="增加">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
				onclick="history.back()" value="返回"></td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>
