<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>钱隆网后台管理系统</title>

<LINK rel=stylesheet href="<c:url value="/resources/management/stylesheets/menu.css" />" type=text/css>
<style type="">
body {
	background-color: #eeeeee;
	SCROLLBAR-FACE-COLOR: #dce0e2;
	SCROLLBAR-HIGHLIGHT-COLOR: #ffffff;
	SCROLLBAR-SHADOW-COLOR: #687888;
	SCROLLBAR-3DLIGHT-COLOR: #687888;
	SCROLLBAR-ARROW-COLOR: #6e7e88;
	SCROLLBAR-TRACK-COLOR: #bcbfc0;
	SCROLLBAR-DARKSHADOW-COLOR: #dce0e2;
	FONT-SIZE: 12px
}
</style>
<script language="JavaScript"
	src="<c:url value="/resources/management/scripts/dtree.js" />"
	type="text/javascript">
</script>
</head>
<body>
<div class="dtree"><script type="text/javascript">
	welcomeText="欢迎：${sessionAdmin.loginName}";
	d = new dTree('d');
	d.config.target="mainFrame";
	d.config.useCookies=false;
	d.add(0,-1,welcomeText);
	d.add(1,0,"借贷公司管理");		
		d.add(101,1,"管理借贷公司","<c:url value="/management/loanCompany/manageLoanCompany" />");
		d.add(102,1,"修改个人信息","<%=request.getContextPath()%>/student/addOtherInformationPage.htm");
		
	d.add(2,0,"新闻管理");	
	    d.add(201,2,"管理新闻分类","<c:url value="/management/news/manageCategory" />");
	   	 d.add(202,2,"管理新闻","<c:url value="/management/news/manageNews" />");	
	
	d.add(3,0,"用户管理");
		d.add(301,3,"管理用户","<c:url value="/management/user/manageUser" />");
		
	d.add(5,0,"管理员管理");
		d.add(501,5,"管理管理员","<c:url value="/management/admin/showManageAdmin" />");
	
	d.add(4,0,"地理位置管理");
		d.add(401,4,"管理省份信息","<c:url value="/management/location/manageProvince" />");
	    d.add(402,4,"管理城市信息","<c:url value="/management/location/manageCity" />");
	
	d.add(6,0, "系统通知");
		d.add(601,6,"查看通知","<%=request.getContextPath()%>/message/viewMsgs.htm");
	
	d.add(7,0, "用户功能");
		d.add(701,7,"帮助","http://202.202.5.145/doc/help_student.jsp");
		d.add(702,7,"修改密码","<%=request.getContextPath()%>/security/changePwd.htm");
	
	d.add(8,0,"文档下载","<%=request.getContextPath()%>/student/managedoc.htm");
	d.add(9,0,"退出系统","<c:url value="/admin/logout" />","","_top");
document.write(d);


</script></div>
</body>
</html>
