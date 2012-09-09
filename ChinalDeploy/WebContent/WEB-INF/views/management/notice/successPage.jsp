<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh"
	content="1;URL=<%=request.getContextPath()%>/${nextpage}">
<META http-equiv="Pragma" content="no-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META http-equiv="Expires" content="-1">
<title>操作成功</title>
<style>
.input {
	background: #CECFCE;
	border-top: 1px solid #FFFFFF;
	border-left: 1px solid #FFFFFF;
	border-right: 1px solid #FFFFFF;
	border-bottom: 1px solid #000000;
}

TD.mode4 {
	BACKGROUND-COLOR: #eeeee0;
	BORDER-BOTTOM: #cccc99 1px solid;
	BORDER-LEFT: #ffffff 1px solid;
	BORDER-RIGHT: #cccc99 1px solid;
	BORDER-TOP: #ffffff 1px solid;
	HEIGHT: 23px
}

.inputbox1 {
	BORDER-RIGHT: #808080 1px solid;
	BORDER-TOP: #808080 1px solid;
	BORDER-LEFT: #808080 1px solid;
	BORDER-BOTTOM: #808080 1px solid
}

TD.Bartitle2 {
	BACKGROUND-COLOR: #4065B1;
	BORDER-BOTTOM: #000033 1px solid;
	BORDER-LEFT: #669999 1px solid;
	BORDER-RIGHT: #000033 1px solid;
	BORDER-TOP: #669999 1px solid;
	COLOR: #ffffff;
	PADDING-BOTTOM: 0px;
	PADDING-LEFT: 10px;
	PADDING-RIGHT: 10px;
	PADDING-TOP: 0px
}

TD.mode5 {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #cccccc 1px solid;
	BORDER-LEFT: #ffffff 1px solid;
	BORDER-RIGHT: #cccccc 1px solid;
	BORDER-TOP: #ffffff 1px solid;
	HEIGHT: 23px
}

TD {
	FONT-FAMILY: 宋体, Verdana, Helvetica, sans-serif;
	FONT-SIZE: 12px
}

body {
	background-color: #eeeeee;
}

A:link {
	COLOR: red;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: red;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: red;
	TEXT-DECORATION: underline
}

A.link1 {
	COLOR: red;
	TEXT-DECORATION: none
}

A.link1:visited {
	COLOR: red;
	TEXT-DECORATION: none
}

A.link1:hover {
	COLOR: red;
	TEXT-DECORATION: underline
}
</style>
</head>

<body onload="alert('操作成功!')">
<div align="center">
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table>
	<tr>
		<td>
		<p align="center">
		<p align="center">如果你的浏览器没有跳转请点<a
			href="<%=request.getContextPath()%>/${nextpage}">这里</a></p>
		</td>
	</tr>
</table>
</div>
</body>
</html>