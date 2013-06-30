<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>File Mgmt Page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<s:include value="header.jsp"/>
		<s:form action="addFile" method="post" enctype="multipart/form-data">
			<s:hidden name="id"/>
			<s:file name="userImage" required="true"/>
			<s:submit value="Upload" cssClass="btn btn-primary"/>		
	   	</s:form>
	   	<s:if test="fileList.size() > 0">
	   	<table>
	   	<tr>
	   		<th>File Name</th>
	   		<th>Content Type</th>
	   		<th>Path</th>
	   		<th>Created On</th>
	   	</tr>
	   	<s:iterator value="fileList" status="fileStatus">
	   		<tr>
	   			<s:if test="#fileStatus.even == true">
	   				<td style="background: #CCCCCC"><s:property value="imageFile"/></td>
	   				<td style="background: #CCCCCC"><s:property value="contentImageType"/></td>
	   				<td style="background: #CCCCCC"><s:property value="filePath"/></td>
	   				<td style="background: #CCCCCC"><s:property value="createdOn"/></td>
	   			</s:if>
	   			<s:if test="#fileStatus.odd == true">
	   				<td style="background: #AAAAAA"><s:property value="imageFile"/></td>
	   				<td style="background: #AAAAAA"><s:property value="contentImageType"/></td>
	   				<td style="background: #AAAAAA"><s:property value="filePath"/></td>	
	   				<td style="background: #AAAAAA"><s:property value="createdOn"/></td>
	   			</s:if>
	   			<td>
	   				<s:url id="deleteURL" namespace="/fileMgmt" action="removeFile">
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