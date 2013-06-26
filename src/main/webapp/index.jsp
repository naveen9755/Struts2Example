<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Music and Videos Library</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<h1>Music and Videos Library</h1>
		<a href='<s:url namespace="music" action="listMusic"/>'>Music</a> ||
		<a href='<s:url namespace="video" action="listVideo"/>'>Videos</a> ||
		<a href='<s:url namespace="fileMgmt" action="listFile"/>'>File Mgmt</a> ||
		<a href='<s:url namespace="/" action="logout"/>'>Logout</a>
		<hr/>
	</s:div>
</body>
</html>