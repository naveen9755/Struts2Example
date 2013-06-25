<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Music Page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<h1>Music</h1>
		<a href='<s:url namespace="/" action="index"/>'>Home</a> ||
		<a href='<s:url namespace="/" action="logout"/>'>Logout</a>
	   	<hr/>
		<s:form action="addMusic">
			<s:push value="music">
				<s:hidden name="id"/>
				<s:textfield name="name" cssClass="input-block-level" placeholder="Name of Song" required="true"/>
				<s:textfield name="singer" cssClass="input-block-level" placeholder="Singer" required="true"/>
				<s:textfield name="album" cssClass="input-block-level" placeholder="Album" required="true"/>
				<s:textfield name="composer" cssClass="input-block-level" placeholder="Composer" required="true"/>
				<s:textfield name="lyricist" cssClass="input-block-level" placeholder="Lyricist" required="true"/>
				<s:submit value="Submit" cssClass="btn btn-primary"/>
			</s:push>
	   </s:form>
	   	<s:if test="musicList.size() > 0">
	   	<table>
	   	<tr>
	   		<th>Name</th>
	   		<th>Singer</th>
	   		<th>Album</th>
	   		<th>Composer</th>
	   		<th>Lyricist</th>
	   	</tr>
	   	<s:iterator value="musicList" status="musicStatus">
	   		<tr>
	   			<s:if test="#musicStatus.even == true">
	   				<td style="background: #CCCCCC"><s:property value="name"/></td>   			
	   				<td style="background: #CCCCCC"><s:property value="singer"/></td>
	   				<td style="background: #CCCCCC"><s:property value="album"/></td>
	   				<td style="background: #CCCCCC"><s:property value="composer"/></td>
	   				<td style="background: #CCCCCC"><s:property value="lyricist"/></td>
	   			</s:if>
	   			<s:if test="#musicStatus.odd == true">
	   				<td style="background: #AAAAAA"><s:property value="name"/></td>   			
	   				<td style="background: #AAAAAA"><s:property value="singer"/></td>
	   				<td style="background: #AAAAAA"><s:property value="album"/></td>
	   				<td style="background: #AAAAAA"><s:property value="composer"/></td>
	   				<td style="background: #AAAAAA"><s:property value="lyricist"/></td>
	   			</s:if>
	   			<td>
		   			<s:url id="editURL" namespace="/music" action="editMusic">
		   				<s:param name="id" value="%{id}"></s:param>
		   			</s:url>
		   			<s:a href="%{editURL}">Edit</s:a>
	   			</td>
	   			<td>
	   				<s:url id="deleteURL" namespace="/music" action="removeMusic">
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