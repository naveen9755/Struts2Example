<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Videos Library</title>
</head>
<body>
	<h1>Music and Videos Library</h1>
	<a href="<s:url namespace="music" action="listMusic"/>">Music</a>||
	<a href="<s:url namespace="video" action="allVideo"/>">Videos</a>
</body>
</html>