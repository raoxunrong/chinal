<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/location/location.js" />"></script>
<title>钱隆网后台管理系统</title>
<link
	href="<c:url value="/resources/management/stylesheets/style.css" />"
	rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
<form:form commandName="userVO" action="addUser" method="post" >
	<font color="red"><form:errors path="*" /></font>
	<table cellspacing="0" cellpadding="0" border="1" width="600">
		<tr>
			<td class="title" height="30" colspan="2" align="center">添加用户信息</td>
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
			<td class="title" height="30">身份证号码：</td>
			<td class="data" height="30"><form:input path="idCard" /><form:errors
				path="email" /></td>
		</tr>
		<tr>
			<td class="title" height="30">邮箱：</td>
			<td class="data" height="30"><form:input path="email" /><form:errors
				path="email" /></td>
		</tr>
		<tr>
			<td class="title" height="30">所属城市：</td>
			<td class="data" height="30"><select id="provinceId" onchange="getCities(this.options[this.selectedIndex].value)">
				<option value="">请选择</option>
				<c:forEach items="${allProvince}" var="province">
					<option value="${province.id}">${province.name}</option>
				</c:forEach>
			</select>
			<form:select path="cityId"><option value="">请选择省份</option></form:select></td>
		</tr>
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
