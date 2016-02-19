<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
<script src="resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="resources/js/myScript.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-5"></div>
		<div class="col-md-2" align="center">
			<figure>
				<img alt="Logo" src="resources/images/logo.png" height="100px" width="100px">
			</figure>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div align="center">
		<h1 id="regtitle">Mobile App Review</h1>
	</div>
	<% if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
	<h1 id="pop" align="center">Registration</h1>
	<div id="blank"></div>
	<form:form action="doRegister" modelAttribute="register" method="post" onsubmit="return validate();">
		<div class="container" align="left">
			<div class="col-md-3"></div>
			<div class="col-md-6" align="center">
			<div id="error">${userExists }</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">First Name:</div>
					<div id="box" class="col-md-8" align="left">
						<form:input path="fname" cssClass="form-control" placeholder="Enter First Name" required = "required"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Last Name:</div>
					<div id="box" class="col-md-8" align="left">
						<form:input path="lname" cssClass="form-control" placeholder="Enter Last Name" required="required"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">E-mail:</div>
					<div id="box" class="col-md-8" align="left">
						<form:input path="email" cssClass="form-control" placeholder="Enter E-mail Address" required="required" />
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Username:</div>
					<div id="box" class="col-md-8" align="left">
						<form:input path="username" cssClass="form-control" placeholder="Enter Username" required="required" />
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Password:</div>
					<div id="box" class="col-md-8" align="left">
						<form:password id="pass1" path="password" cssClass="form-control" value="" placeholder="Enter Password" required="required"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Repeat
						Password:</div>
					<div id="box" class="col-md-8" align="left">
						<input type="password" id="pass2" class="form-control" placeholder="Enter Password Again" required="required"/>
					</div>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<div id="logindiv" align="left">
						<input class="btn btn-default" type="submit" name="submit"
							value="Register" /> <input class="btn btn-default" type="reset"
							name="reset" value="Reset" />
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form:form>
	<%} else { %>
	<div align="center"><h1 id="title">You are Already Registered!! </h1></div>
	
	<div align="center">
		<h4 id="new">
			Want to Log Out? <a href="logout">Logout Here</a>
		</h4>
	</div>
	<div id="blank"></div>
	<%} %>
	
	<div align="center">
		<a class="btn btn-success" href="index">Go Home</a>
	</div>
</body>
</html>