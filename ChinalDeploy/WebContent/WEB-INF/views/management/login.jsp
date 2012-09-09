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
		<form:form commandName="adminVO" method="post" action="login">
			<BR />
			<c:choose>
			<c:when test="${loginError!=null}">
				<font color="red">${loginError}</font>
			</c:when>
			</c:choose>
			<BR />
			<table cellspacing="0" cellpadding="0" border="1" width="400">
				<tr height="30" align="left">
					<td class="title" width="100">用户名：</td>
					<form:errors path="loginName" />
					<td class="data" width="300"><form:input path="loginName"
							size="20" /></td>
				</tr>
				<tr height="30" align="left">
					<td class="title" width="100">密码：</td>
					<form:errors path="password" />
					<td class="data" width="300"><form:password path="password"
							size="20" /></td>
				</tr>
				<tr height="30" align="left">
					<td class="title" width="100">操作：</td>
					<td class="data" width="300">&nbsp;&nbsp;<input type="submit"
						value="登录">&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
						value="重置" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
