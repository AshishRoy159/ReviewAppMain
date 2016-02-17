<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../resources/css/mystyle.css">
<script src="../resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="../resources/js/myScript.js"></script>
</head>
<body>
<div class="container-fluid">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<figure>
				<img alt="Logo" src="../resources/images/logo.png" height="150px" width="150px">
			</figure>
		</div>
		<div class="col-md-5"></div>
	</div>
	<div align="center">
		<h1 id="title">Mobile App Review</h1>
	</div>
	
	<form:form method="post" name="chngPW" modelAttribute="password" action="changePassword">
		<div class="container">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			${status}
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Current Password:</div>
					<div id="box" class="col-md-8" align="left">
						<form:password path="password" cssClass="form-control" placeholder = "Enter Current Password"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">New Password:</div>
					<div id="box" class="col-md-8" align="left">
						<form:password path="newpassword" id="pass1" cssClass="form-control" placeholder = "Enter New Password"/>
					</div>
				</div>
				<div id="logindiv">
					<div id="logintxt" class="col-md-4" align="right">Confirm New Password:</div>
					<div id="box" class="col-md-8" align="left">
						<input type="password" id="pass2" class="form-control" placeholder="Confirm New Password" required="required"/>
					</div>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<div id="logindiv">
						<input class="btn btn-default" type="submit" name="submit"
							value="Change Password" /> <input class="btn btn-default" type="reset"
							name="reset" value="Reset" />
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form:form>
</body>
</html>