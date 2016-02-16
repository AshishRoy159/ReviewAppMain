<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
	<h1 id="mostreview" align="center">Reset Password</h1>
	<div id="blank"></div>
	<form action="">
		<div class="container">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Username:</div>
					<div id="box" class="col-md-8" align="left">
						<input type="text" class="form-control" name="username" value=""
							placeholder="Enter Username" required="required" />
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">E-mail:</div>
					<div id="box" class="col-md-8" align="left">
						<input type="email" class="form-control" name="email"
							value="" placeholder="Enter E-mail ID" required="required" />
					</div>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<div id="logindiv">
						<input class="btn btn-default" type="submit" name="submit"
							value="Reset Password" /> 
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</form>
	<div id="blank"></div>
	<div align="center">
		<a class="btn btn-success" href="login">Go Back</a>
	</div>
</body>
</html>