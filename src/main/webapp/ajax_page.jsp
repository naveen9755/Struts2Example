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
		<s:include value="header.jsp"/>
		<s:form action="index" method="post">
			 <s:textfield name="name"/>
			 <sj:submit 
                	targets="result" 
                	effect="slide" 
                	effectMode="blind"
                	onEffectCompleteTopics="hideTarget"
                	value="AJAX Submit" 
                	indicator="indicator" 
                	button="true"
                />
		</s:form>
		<h3>AJAX Result</h3>
		<s:div id="result">
			<s:property value="name"/>
		</s:div>
	</s:div>
</body>
</html>