<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>钱隆网后台管理系统</title>
<link href="<c:url value="/resources/management/stylesheets/style.css" />" rel="stylesheet"  type="text/css" />		

</head>
<FRAMESET border=1 frameSpacing=0 id=topmain
	onload="javascript:this.focus()" rows="24,*">

	<FRAME frameBorder=0 marginHeight=0 marginWidth=0 name=menuBar noResize
		scrolling=no src="<c:url value="/management/topmenu" />">
	<FRAMESET border=1 cols=250,* frameSpacing=6 id=bottommain
		onload=javascript:this.focus()>
		<FRAME frameBorder=0 marginHeight=0 marginWidth=0 name=menuFrame
			scrolling=yes src="<c:url value="/management/menu" />">
		<FRAME borderColor=#4065B1 name=mainFrame scrolling=yes
			src="<c:url value="/management/menu" />">
	</FRAMESET>
</FRAMESET>
<noframes>
<p>你的浏览器不支持框架</p>
</noframes>
</html>