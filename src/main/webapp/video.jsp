<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Videos Library</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<h1>Videos</h1>
		<a href='<s:url namespace="/" action="index"/>'>Home</a> ||
		<a href="<%=request.getContextPath()%>">Logout</a>
	   	<hr/>
	   	<s:form action="addVideo">
			<s:push value="video">
				<s:hidden name="id"/>
				<s:textfield name="name" cssClass="input-block-level" placeholder="Name of Video"/>
				<s:textfield name="actor" cssClass="input-block-level" placeholder="Actor"/>
				<s:textfield name="director" cssClass="input-block-level" placeholder="Director"/>
				<s:textfield name="writer" cssClass="input-block-level" placeholder="Writer"/>
				<s:textfield name="category" cssClass="input-block-level" placeholder="Category"/>
				<s:submit value="Submit" cssClass="btn btn-primary"/>
			</s:push>
   		</s:form>
   		<s:if test="videoList.size() > 0">
	   	<table>
	   	<tr>
	   		<th>Name</th>
	   		<th>Actor</th>
	   		<th>Director</th>
	   		<th>Writer</th>
	   		<th>Category</th>
	   	</tr>
	   	<s:iterator value="videoList" status="videoStatus">
	   		<tr>
	   			<s:if test="#videoStatus.even == true">
	   				<td style="background: #CCCCCC"><s:property value="name"/></td>   			
	   				<td style="background: #CCCCCC"><s:property value="actor"/></td>
	   				<td style="background: #CCCCCC"><s:property value="director"/></td>
	   				<td style="background: #CCCCCC"><s:property value="writer"/></td>
	   				<td style="background: #CCCCCC"><s:property value="category"/></td>
	   			</s:if>
	   			<s:if test="#videoStatus.odd == true">
	   				<td style="background: #AAAAAA"><s:property value="name"/></td>   			
	   				<td style="background: #AAAAAA"><s:property value="actor"/></td>
	   				<td style="background: #AAAAAA"><s:property value="director"/></td>
	   				<td style="background: #AAAAAA"><s:property value="writer"/></td>
	   				<td style="background: #AAAAAA"><s:property value="category"/></td>
	   			</s:if>
	   			<td>
	   				<s:url id="deleteURL" namespace="/video" action="removeVideo">
	   					<s:param name="id" value="%{id}"></s:param>
	   				</s:url>
	   				<s:a href="%{deleteURL}">Delete</s:a>
	   			</td>
	   		</tr>
	   	</s:iterator>
	   	</table>
	   	</s:if>
   	</div>
</body>
</html>