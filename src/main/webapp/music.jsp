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
	<h1>Music Page.</h1>
	<s:form action="addMusic">
		<s:textfield name="name" label="Name"/>
		<s:textfield name="singer" label="Singer"/>
		<s:textfield name="album" label="Album"/>
		<s:textfield name="composer" label="Composer"/>
		<s:textfield name="lyricist" label="Lyricist"/>
		<s:submit/>
   </s:form>
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
   		</tr>
   	</s:iterator>
   </table>
   <p>
   <a href='<s:url namespace="/" action="index"/>'>Back</a>
</body>
</html>