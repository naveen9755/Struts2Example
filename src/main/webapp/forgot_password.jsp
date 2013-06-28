<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<h1>Forgot Password</h1>
		<s:form action="sendPassword" method="post">
			<s:textfield name="email" placeholder="Email" required="true" cssClass="input-block-level"/>
			<s:submit value="Get Password!!!" cssClass="btn btn-primary"/>
		</s:form>
	</s:div>
</body>
</html>