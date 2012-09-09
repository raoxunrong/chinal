<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META content=text/html;charset=utf-8 http-equiv=Content-Type>
<LINK rel=stylesheet href="<c:url value="/resources/management/mainFrame/menu.css" />" type=text/css>
<SCRIPT type="text/javascript" src="<c:url value="/resources/management/mainFrame/show_hide.js" />"></SCRIPT>
<SCRIPT>
window.onload = Window_Load;
</SCRIPT>
</HEAD>
<BODY>
<TABLE border=0 cellPadding=2 cellSpacing=0 class="back_color_1"
	height=24 width="100%">
	<TBODY>
		<TR>
			<TD align=left>
			<TABLE border=0 cellPadding=7 cellSpacing=0>
				<TBODY>
					<TR>
						<TD class=cl2BtnOff id=menu_op noWrap title=显示/隐藏左边的菜单 width=100
							action="HIDE"><NOBR>&nbsp;<IMG alt=显示/隐藏左边的菜单
							border=0 height=16 src="<c:url value="/resources/management/mainFrame/img/menuImage/hide_menu.gif" />"
							width=16>&nbsp;<FONT class=p1>隐藏菜单</FONT></NOBR></TD>


						<td width="80%"></td>

						<td width=100 id=personal_op class=cl2BtnOff noWrap title="退出系统"
							action="PERSONAL" align=center onclick="javascript:logout();"><nobr>&nbsp;<img
							alt="退出系统" border=0 height=16
							src="<c:url value="/resources/management/mainFrame/img/menuImage/exit.gif" />" width=16>&nbsp;<font
							class=p1>退出系统</font></nobr></td>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
