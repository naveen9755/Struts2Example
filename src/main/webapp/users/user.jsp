<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users Page::Struts 2 Show Case</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<s:include value="../template/header.jsp"/>
	   	<s:if test="userList.size() > 0">
	   	<table>
	   	<tr>
	   		<th>Username</th>
	   		<th>Create On</th>
	   	</tr>
	   	<s:iterator value="userList" status="userStatus">
	   		<tr>
	   			<s:if test="#userStatus.even == true">
	   				<td style="background: #CCCCCC"><s:property value="username"/></td>   			
	   				<td style="background: #CCCCCC"><s:property value="created_on"/></td>
	   			</s:if>
	   			<s:if test="#userStatus.odd == true">
	   				<td style="background: #AAAAAA"><s:property value="username"/></td>   			
	   				<td style="background: #AAAAAA"><s:property value="created_on"/></td>
	   			</s:if>
	   			<td>
	   				<s:url id="deleteURL" namespace="/users" action="removeUser">
	   					<s:param name="id" value="%{id}"></s:param>
	   				</s:url>
	   				<s:a href="%{deleteURL}">Delete</s:a>
	   			</td>
	   		</tr>
	   	</s:iterator>
	   	</table>
	   	</s:if>
   </s:div>
</body>
</html>