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
<style>
form {
	margin: 0;
}

textarea {
	display: block;
}
</style>
<script type="text/javascript"
	src="<c:url value="/resources/management/scripts/richTextEditor/kindeditor-min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/management/scripts/richTextEditor/zh_CN.js" />"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|',
					'emoticons', 'image', 'link' ]
		});
	});
</script>


</head>
<body>
	<div align="center">
		<form:form commandName="newsVO" action="publishNews" method="post">
			<font color="red"><form:errors path="*" /></font>
			<table cellspacing="0" cellpadding="0" border="1" width="600">
				<tr>
					<td class="title" height="30" colspan="2" align="center">发布新闻</td>
				</tr>
				<tr>
					<td class="title" height="30">标题：</td>
					<td class="data" height="30"><form:input path="title" size="60"/><font
						color="red"><form:errors path="title" /></font></td>
				</tr>
				<tr>
					<td class="title" height="30">来源：</td>
					<td class="data" height="30"><form:input path="originSource" size="60"/></td>
				</tr>
				<tr>
					<td class="title" height="30">所属分类：</td>
					<td class="data" height="30"><form:select path="categoryId">
							<c:forEach items="${allCategory}" var="category">
								<option value="${category.id}">${category.name}</option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td class="title" height="30">热门：</td>
					<td class="data" height="30">
						是<form:radiobutton path="hot" value="true"/>
						否<form:radiobutton path="hot" value="false"/>
					</td>
				</tr>
				<tr>
					<td class="data" height="30" colspan="2"><form:textarea
							path="content"
							style="width: 600px; height: 300px; visibility: hidden;" /> <form:errors
							path="content" /></td>
				</tr>
				<tr>
					<td class="title" height="30">操作：</td>
					<td class="data" height="30">&nbsp;&nbsp; <input type="submit"
						value="发布">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
						onclick="history.back()" value="返回"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>