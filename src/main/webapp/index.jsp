<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Struts 2 Show Case with Twitter Bootstrap</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<h1>Struts 2 Show Case with Twitter Bootstrap</h1>
		<ul class="nav nav-pills">
			<li><a href='<s:url namespace="music" action="listMusic"/>'>Music</a></li>
			<li><a href='<s:url namespace="video" action="listVideo"/>'>Videos</a></li>
			<li><a href='<s:url namespace="fileMgmt" action="listFile"/>'>File Management</a></li>
			<li><a href='<s:url namespace="users" action="listUser"/>'>User Management</a></li>
			<li><a href='<s:url namespace="/" action="logout"/>'>Logout</a></li>
		</ul>
		<hr/>
	</s:div>
</body>
</html>