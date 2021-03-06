<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login::Struts 2 Show Case</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
	<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      form {
        max-width: 195px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      
      form .form-signin-heading {
        margin-bottom: 10px;
      }
      
      input[type="text"], input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>
<body>
	<s:if test="#session.loggedInUser != null">
		<% response.sendRedirect(request.getContextPath() + "/index.html"); %>
	</s:if>
	<s:div cssClass="container">
		<s:form action="login">
			<s:actionerror cssClass="alert alert-error" cssStyle="padding-left: 30px;"/>
			<h2 class="form-signin-heading">Login</h2>
			<s:textfield name="username" cssClass="input-block-level" placeholder="Username" required="true"/>
			<s:password name="password" cssClass="input-block-level" placeholder="Password" required="true"/>
			<s:submit value="Login" cssClass="btn btn-large btn-primary"/>
			<table>
				<tr>
					<td><a href='<s:url namespace="/" action="forgotPassword"/>'>Forgot Password?</a></td>
				</tr>
				<tr>
					<td><a href='<s:url namespace="/" action="signUp"/>'>Sign Up</a></td>
				</tr>
			</table>
		</s:form>
	</s:div>
</body>
</html>