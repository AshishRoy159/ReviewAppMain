<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Details</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/mystyle.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/star-rating.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/myScript.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/star-rating.js"></script>
</head>
<body>
	<div id="mainhead">
		<%@ include file="/WEB-INF/views/header.jsp"%>
	</div>
	<div class="container-fluid">
		<div id="content" class="col-md-8">
			<figure>
				<img alt="App Banner"
					src="${pageContext.request.contextPath}/resources/images/facebook.png"
					height="300px" width="750px">
			</figure>
			<div class="container-fluid">
				<div class="col-md-9">
					<h1 id="title">
						<c:out value="${apps.name}" />
					</h1>
					<h4 id="developer">
						<b>Developed By: </b> ${apps.developer.name}
					</h4>
				</div>
				<div class="col-md-3" align="right">
					<figure>
						<img id="ratingdt" alt="Rating"
							src="${pageContext.request.contextPath}/resources/images/rating.png"
							height="40px" width="180px">
					</figure>
				</div>

			</div>
			<div class="container-fluid">
				<div class="col-md-9">
					<h4 id="developer">
						<b>Platform : </b> ${apps.platform }
					</h4>
				</div>
			</div>
			<section>
				<h2 id="details">Details:</h2>
				<div id="detail">${apps.details }</div>
			</section>
			<div id="blank"></div>
			<div class="container-fluid">
				<section>
					<h2 id="details">Screenshots:</h2>
					<div class="col-md-4">
						<img alt="Screenshot 1"
							src="${pageContext.request.contextPath}/resources/images/fb1.png"
							height="300px" width="200px">
					</div>
					<div class="col-md-4">
						<img alt="Scerrenshot 2"
							src="${pageContext.request.contextPath}/resources/images/fb2.png"
							height="300px" width="200px">
					</div>
					<div class="col-md-4">
						<img alt="Screenshot 3"
							src="${pageContext.request.contextPath}/resources/images/fb3.png"
							height="300px" width="200px">
					</div>
				</section>
			</div>
			<hr>
			<div class="container-fluid">
				<%
					if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
				%>
				<div id="blank"></div>
				<%
					} else {
				%>
				<form:form action="${appId}" modelAttribute="review"
					method="post">
					<div class="container-fluid">
						<form:hidden path="userName"
							value='<%=session.getAttribute("username")%>' />
							<form:hidden path="appid"
							value="${apps.appId }" />
								
						<div id="ratingtxt" class="col-md-4" align="left">Your
							Rating</div>
						<div class="col-md-8" align="right">
							<input id="rating-system" type="number" class="rating" min="1"
								name="rating" max="5" step="1" value="" required="required">
						</div>
					</div>

					<div class="container-fluid">
						<div class="row-fluid">
							<div id="ratingtxt">
								<%
									out.print(session.getAttribute("username"));
								%>
								:
							</div>
							<form:textarea id="nomargin" path="comment"
								cssClass="form-control" />
						</div>
						<div></div>
						<input class="btn btn-default" type="submit" value="Post" /> <input
							class="btn btn-default" type="reset" value="Reset" />
					</div>


				</form:form>
				<%
					}
				%>
			</div>
			<hr>
<c:forEach var="i" items="${apps.comments}">
			<div class="row">
				<div class="col-sm-2">
					<div class="thumbnail">
						<img class="img-responsive user-photo"
							src="${pageContext.request.contextPath}/resources/images/avatar.png">
					</div>
					<!-- /thumbnail -->
				</div>
				<!-- /col-sm-1 -->

				<div class="col-sm-10">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${i.userinfo.fname}</strong> <span class="text-muted">${i.added }</span>
						</div>
						<div class="panel-body">${i.comment}</div>
						<!-- /panel-body -->
					</div>
					<!-- /panel panel-default -->
				</div>
				</div>
				</c:forEach>
				
					<section>
						<div class="container-fluid">
						<div class="col-md-3"><h2 id="logintxt"></h2></div>
						
						
						<div class="col-md-9" align="right"><h2 id="detail"></h2></div>
						</div>
					</section>
				
			
			</div>


			<div class="col-md-4">
				<div class="panel panel-header">
					<h1 id="regtitle">App of the Week</h1>
				</div>
				<section>
					<div class="panel">
						<h2 id="details">Whatsapp</h2>
						<figure>
							<img alt="App of the Week"
								src="${pageContext.request.contextPath}/resources/images/topwindows.png"
								height="350px" width="350px">
						</figure>
						<div id="blank"></div>
						<p>Vivamus elementum semper nisi. Aenean vulputate eleifend
							tellus. Aenean leo ligula, porttitor eu, consequat vitae,
							eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis,
							feugiat a, tellus. Phasellus viverra nulla ut metus varius
							laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi
							vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.
							Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,
							sem quam semper libero, sit amet adipiscing sem neque sed ipsum.
							Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem.</p>
					</div>
				</section>
				<hr>
				<div class="panel panel-header">
					<h1 id="regtitle">App of the Month</h1>
				</div>
				<section>
					<div class="panel">
						<h2 id="details">Twitter</h2>
						<figure>
							<img alt="App of the Week"
								src="${pageContext.request.contextPath}/resources/images/topiosapp.png"
								height="350px" width="350px">
						</figure>
						<div id="blank"></div>
						<p>Vivamus elementum semper nisi. Aenean vulputate eleifend
							tellus. Aenean leo ligula, porttitor eu, consequat vitae,
							eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis,
							feugiat a, tellus. Phasellus viverra nulla ut metus varius
							laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi
							vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.
							Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,
							sem quam semper libero, sit amet adipiscing sem neque sed ipsum.
							Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem.</p>
					</div>
				</section>
			</div>
		</div>
		<div id="blank"></div>

		<footer id="footer">
			<%@ include file="/WEB-INF/views/footer.jsp"%>
		</footer>
</body>
</html>