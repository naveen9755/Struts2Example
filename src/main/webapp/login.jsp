<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login::::::Struts 2 Example</title>
</head>
<body>
	<h1>Login Page</h1>
	<s:form action="login">
		<s:textfield label="User Id" key="username"/>
		<s:password label="Password" key="password"/>
		<s:submit label="Login"/>
	</s:form>
</body>
</html>