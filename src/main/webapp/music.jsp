<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Music Page</title>
</head>
<body>
	<h1>Music Page.</h1>
	<s:form action="addMusic">
		<s:push value="music">
			<s:hidden name="id"/>
			<s:textfield name="name" label="Name" requiredLabel="*"/>
			<s:textfield name="singer" label="Singer" requiredLabel="*"/>
			<s:textfield name="album" label="Album" requiredLabel="*"/>
			<s:textfield name="composer" label="Composer" requiredLabel="*"/>
			<s:textfield name="lyricist" label="Lyricist" requiredLabel="*"/>
			<s:submit/>
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
   				<s:url id="deleteURL" namespace="/music" action="removeMusic">
   					<s:param name="id" value="%{id}"></s:param>
   				</s:url>
   				<s:a href="%{deleteURL}">Delete</s:a>
   			</td>
   			<td>
	   			<s:url id="editURL" namespace="/music" action="editMusic">
	   				<s:param name="id" value="%{id}"></s:param>
	   			</s:url>
	   			<s:a href="%{editURL}">Edit</s:a>
   			</td>
   		</tr>
   	</s:iterator>
   	</table>
   	</s:if>
   <p>
   <a href='<s:url namespace="/" action="index"/>'>Back</a>
</body>
</html>