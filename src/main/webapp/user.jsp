<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<h1>Users</h1>
		<a href='<s:url namespace="/" action="index"/>'>Home</a> ||
		<a href='<s:url namespace="/" action="logout"/>'>Logout</a>
	   	<hr/>
		<s:form action="addUser">
			<s:push value="user">
				<s:hidden name="id"/>
				<s:textfield name="username" cssClass="input-block-level" placeholder="Username" required="true"/>
				<s:password name="password" cssClass="input-block-level" placeholder="Password" required="true"/>
				<s:submit value="Submit" cssClass="btn btn-primary"/>
			</s:push>
	   </s:form>
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
	   				<td style="background: #CCCCCC"><s:property value="createdOn"/></td>
	   			</s:if>
	   			<s:if test="#userStatus.odd == true">
	   				<td style="background: #AAAAAA"><s:property value="username"/></td>   			
	   				<td style="background: #AAAAAA"><s:property value="createdOn"/></td>
	   			</s:if>
	   			<td>
		   			<s:url id="editURL" namespace="/user" action="editUser">
		   				<s:param name="id" value="%{id}"></s:param>
		   			</s:url>
		   			<s:a href="%{editURL}">Edit</s:a>
	   			</td>
	   			<td>
	   				<s:url id="deleteURL" namespace="/user" action="removeUser">
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