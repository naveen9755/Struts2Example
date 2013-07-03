<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AJAX Page::Struts 2 Show Case with Twitter Bootstrap</title>
	<sj:head jquerytheme="blitzer"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<s:include value="../template/header.jsp"/>
		<s:form id="form" action="resultPage">
			 <s:textfield name="name"/>
			 <sj:submit id="formSubmit" targets="formResult" value="AJAX Submit" 
	            	indicator="indicator" button="true" effect="highlight"/>
		</s:form>
		<h3>AJAX Result using jQuery</h3>
		<div id="formResult"></div>
	</s:div>
</body>
</html>