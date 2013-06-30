<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<s:div cssClass="container">
		<h1>Recover Password</h1>
		<hr/>
		<s:actionerror cssClass="alert alert-error" cssStyle="padding-left: 30px;"/>
	   	<s:actionmessage cssClass="alert alert-success" cssStyle="padding-left: 30px;"/>
		<s:form action="sendPassword" method="post">
			<s:textfield name="email" placeholder="Username or Email" required="true" cssClass="input-block-level" size="45"/>
			<table>
	   		<tr><td>
	   		<script type="text/javascript" src="http://api.recaptcha.net/challenge?k=6LfAiuMSAAAAACEE13IZiT8F4JDGfWqij8UyP4ep"></script>
 			<noscript>
 				<iframe src="http://api.recaptcha.net/noscript?k=6LfAiuMSAAAAACEE13IZiT8F4JDGfWqij8UyP4ep" 
 					height="300" width="300" frameborder="0"></iframe><br>
 				<s:textarea name="recaptcha_challenge_field" rows="3" cols="40"/>
 				<s:hidden name="recaptcha_response_field" value="manual_challenge"/>
 			</noscript>
 			</td></tr>
 			</table>
 			<table><tr><td><s:submit value="Get Password!!!" cssClass="btn btn-primary"/></td></tr></table>
		</s:form>
		<table><tr><td><a href='<s:url namespace="/" action="logout"/>'>Back</a></td></tr></table>
	</s:div>
</body>
</html>