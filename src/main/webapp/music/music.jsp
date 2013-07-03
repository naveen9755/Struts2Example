<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Music Page::Struts 2 Show Case</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:if test="#session.loggedInUser == null">
		<% response.sendRedirect(request.getContextPath()); %>
	</s:if>
	<s:div cssClass="container">
		<s:include value="../template/header.jsp"/>
		<s:form action="addMusic" method="post">
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
	   	<p><br/><br/>
	   	<d:table name="musicList" pagesize="5" requestURI="listMusic.html" export="true">
	   		<d:column property="name" title="Name of Song" sortable="true"/>
	   		<d:column property="singer" title="Singer" sortable="true"/>
	   		<d:column property="album" title="Album" sortable="true"/>
	   		<d:column property="composer" title="Composer" sortable="true"/>
	   		<d:column property="lyricist" title="Lyricist" sortable="true"/>
	   		<d:setProperty name="export.excel.filename" value="MusicList.xls"/>
            <d:setProperty name="export.pdf.filename" value="MusicList.pdf"/>
            <d:setProperty name="export.rtf.filename" value="MusicList.rtf"/>
            <d:setProperty name="export.csv.filename" value="MusicList.csv"/>
            <d:setProperty name="export.xml.filename" value="MusicList.xml"/>
	   	</d:table>
	   	</s:if>
   </s:div>
</body>
</html>