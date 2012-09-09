<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

<div align="center">
	<table width="600">
		<tr>
			<td colspan="4" align="right" height="30"><a
				href="<c:url value="/management/location/addCity?provinceId=${province.id }" />">增加城市</a></td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0" border="1" width="600">

		<tr>
			<td class="title" colspan="8" height="30">${province.name }城市列表(共有城市${count}个)</td>
		</tr>
		<tr>
			<td class="header" align="center" height="30">名称</td>
			<td class="header" align="center" height="30">简介</td>
			<td class="header" colspan="2" align="center" height="30">操作</td>
		</tr>
		<c:forEach items="${cities}" var="city">
			<tr>
				<td class="data" align="center" height="30">${city.name}</td>
				<td class="data" align="center" height="30">${city.description}</td>
				<td class="data" align="center" height="30"><a
					href="<c:url value="/management/location/editCity?id=${city.id}" />">编辑</a></td>
				<td class="data" align="center" height="30"><a
					href="<c:url value="/management/location/delCity?id=${city.id}&&provinceId=${province.id }" />"
					onclick="return confirm('该操作将删除${city.name}的信息，确定执行吗？')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

</html>
