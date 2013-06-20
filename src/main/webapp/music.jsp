<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music Page</title>
</head>
<body>
	<h1>This is Music Page.</h1>
	<s:form action="addMusic">
		<s:textfield name="name" label="Name"/>
		<s:textfield name="singer" label="Singer"/>
		<s:textfield name="album" label="Album"/>
		<s:textfield name="composer" label="Composer"/>
		<s:textfield name="lyricist" label="Lyricist"/>
		<s:submit/>
   </s:form>
</body>
</html>