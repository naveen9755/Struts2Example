<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1>Struts 2 Show Case with Twitter Bootstrap</h1>
<ul class="nav nav-pills">
	<li><a href="<%=request.getContextPath()%>/music/listMusic.php">Music</a></li>
	<li><a href="<%=request.getContextPath()%>/video/listVideo.php">Videos</a></li>
	<li><a href="<%=request.getContextPath()%>/fileMgmt/listFile.php">File Management</a></li>
	<li><a href="<%=request.getContextPath()%>/users/listUser.php">User Management</a></li>
	<li><a href="<%=request.getContextPath()%>/ajax/index.php">AJAX</a></li>
	<li><a href="<%=request.getContextPath()%>/logout.php">Logout</a></li>
</ul>
<hr/>
