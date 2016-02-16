<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
</head>
<body>
	
	<div class="container-fluid">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<figure>
				<img alt="Logo" src="resources/images/logo.png" height="150px" width="150px">
			</figure>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div align="center">
		<h1 id="title">Mobile App Review</h1>
	</div>
	<% if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
	<h1 id="mostreview" align="center">Login</h1>
	<div id="blank"></div>
	${status}
	<form:form method="post" name="loginForm" modelAttribute="login" action="doLogin">
		<div class="container">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Username:</div>
					<div id="box" class="col-md-8" align="left">
						<form:input path="username" cssClass="form-control" placeholder = "Enter Username"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Password:</div>
					<div id="box" class="col-md-8" align="left">
						<form:password path="password" cssClass="form-control" placeholder = "Enter Password"/>
					</div>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<div id="logindiv">
						<input class="btn btn-default" type="submit" name="submit"
							value="Login" /> <input class="btn btn-default" type="reset"
							name="reset" value="Reset" />
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</form:form>
	<div class="container-fluid" align="center" id="developer"><a href="forgotPW">Forgot Password?</a></div>
	<div align="center">
		<h4 id="new">
			New User? <a href="register">Register Here.</a>
		</h4>
	</div>
	<%} else { %>
	<div align="center"><h1 id="title">You are Already Logged In!!</h1></div>
	<%} %>
	<div align="center">
		<a class="btn btn-success" href="index">Go Back</a>
	</div>
</body>
</html>