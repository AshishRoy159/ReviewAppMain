<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myScript.js"></script>
</head>
<body>
	<%
		if (session.getAttribute("user") == null || session.getAttribute("user").equals("")
				|| session.getAttribute("user").equals("user")) {
			response.sendRedirect("../index");
		}
	%>
	<div id="mainhead">
		<%@ include file="/WEB-INF/views/admin/header.jsp"%>
	</div>
	<div id="blank"></div>
	<hr>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3">
						<ul class="nav nav-tabs nav-stacked">
							<li><a href="index">Home</a></li>
							<li><a href="developer">Add New Developer</a></li>
							<li><a href="profile">Profile</a></li>
							<li><a href="comments">Comments</a></li>

							<li class="divider"></li>
							<li><a href="chngPassword">Change Password</a></li>
							<li><a href="logout">Logout</a></li>
							<li><a href="../index">Go to Website</a></li>

							<li class="divider"></li>
							<li><a href="#">Add New Admin</a></li>
						</ul>

					</div>
					<div class="col-md-9">
						<div class="container-fluid" align="left">
							<form:form action="addNewDeveloper" modelAttribute="developer"
								method="post" onsubmit="return validate();">
								<div class="container-fluid  col-md-9 " align="left">
									<div align="center">
										<h1 id="title" align="center">Add New Developer</h1>
										<div id="error">${status }</div>
										<div id="logindiv" align="left">
											<div id="logintxt" class="col-md-4" align="right">Developer	Name:</div>
											<div id="box" class="col-md-8" align="left">
												<form:input path="name" cssClass="form-control"
													placeholder="Enter Application Name" required="required" />
											</div>
										</div>
										<div id="logindiv">
											<div id="logintxt" class="col-md-4" align="right">Website:</div>
											<div id="box" class="col-md-8" align="left">
												<form:input path="website" cssClass="form-control"
													placeholder="Enter Developer Website" required="required" />
											</div>
										</div>
										<div id="logindiv">
											<div id="logintxt" class="col-md-4" align="right">Developer Address:</div>
											<div id="box" class="col-md-8" align="left">
												<form:textarea path="address" cssClass="form-control"
													placeholder="Enter Details" required="required" />
											</div>
										</div>
										<div class="col-md-4"></div>
										<div class="col-md-8">
											<div id="logindiv" align="left">
												<input class="btn btn-default" type="submit" name="submit"
													value="Register" /> <input class="btn btn-default"
													type="reset" name="reset" value="Reset" />
											</div>
										</div>
									</div>
								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="largeblank"></div>
	<footer><%@ include file="/WEB-INF/views/admin/footer.jsp"%></footer>
	<div id="blank"></div>
</body>
</html>