<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>Struts 2 Show Case with Twitter Bootstrap and jQuery</h2>
<ul class="nav nav-pills">
	<li><a href="<%=request.getContextPath()%>/music/listMusic.php">Music</a></li>
	<li><a href="<%=request.getContextPath()%>/video/listVideo.php">Videos</a></li>
	<li><a href="<%=request.getContextPath()%>/fileMgmt/listFile.php">File Management</a></li>
	<li><a href="<%=request.getContextPath()%>/users/listUser.php">User Management</a></li>
	<li><a href="<%=request.getContextPath()%>/ajax/index.php">AJAX</a></li>
	<li><a href="<%=request.getContextPath()%>/logout.php">Logout</a></li>
</ul>
<hr/>