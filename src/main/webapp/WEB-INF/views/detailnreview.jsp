<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Details</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myScript.js"></script>
</head>
<body>
	<div id="mainhead">
		<%@ include file="/WEB-INF/views/header.jsp"%>
	</div>
	<div class="container-fluid">
		<c:forEach var="i" items="${apps}">
			<div id="content" class="col-md-8">
				<figure>
					<img alt="App Banner" src="${pageContext.request.contextPath}/resources/images/facebook.png"
						height="300px" width="750px">
				</figure>
				<div class="container-fluid">
					<div class="col-md-9">
						<h1 id="title">
							<c:out value="${i.name}" />
						</h1>
						<h4 id="developer">
							<b>Developed By: </b>
						</h4>
					</div>
					<div class="col-md-3" align="right">
						<figure>
							<img id="ratingdt" alt="Rating"
								src="${pageContext.request.contextPath}/resources/images/rating.png" height="40px" width="180px">
						</figure>
					</div>

				</div>
				<div class="container-fluid">
					<div class="col-md-9">
						<h4 id="developer">
							<b>Platform : </b> ${i.platform }
						</h4>
					</div>
				</div>
				<section>
					<h2 id="details">Details:</h2>
					<div id="detail">${i.details }</div>
				</section>
				<div id="blank"></div>
				<div class="container-fluid">
					<section>
					<h2 id="details">Screenshots:</h2>
						<div class="col-md-4">
							<img alt="Screenshot 1" src="${pageContext.request.contextPath}/resources/images/fb1.png"
								height="300px" width="200px">
						</div>
						<div class="col-md-4">
							<img alt="Scerrenshot 2" src="${pageContext.request.contextPath}/resources/images/fb2.png"
								height="300px" width="200px">
						</div>
						<div class="col-md-4">
							<img alt="Screenshot 3" src="${pageContext.request.contextPath}/resources/images/fb3.png"
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
					<div class="container-fluid">
						<div id="ratingtxt" class="col-md-6" align="left">Your
							Rating</div>
						<div class="col-md-6" align="right" id="jRate"></div>
					</div>
					<div id="blank"></div>

					<div id="usercomment">
						<div id="user">
							<h2 id="details"><%out.println(session.getAttribute("username")); %></h2>
						</div>
						<div id="comment">
							<form action="">
								<div>
									<textarea class="form-control" rows="6" cols="50"></textarea>
								</div>
								<div id="blank"></div>
								<input class="btn btn-default" type="submit" name="submit"
									value="Post"> <input class="btn btn-default"
									type="reset" name="reset" value="Clear">

							</form>
						</div>
					</div>
					<%
						}
					%>
					<hr>
					<div id="comments">
						<section>
							<blockquote class="quote-box">
								<p class="quotation-mark"></p>
								<p class="quote-text">Don't believe anything that you read
									on the internet, it may be fake.</p>
								<hr>
								<div class="blog-post-actions">
									<p class="blog-post-bottom pull-left">Abraham Lincoln</p>
									<p class="blog-post-bottom pull-right">
										<span class="badge quote-badge">896</span>
									</p>
								</div>
							</blockquote>
							<hr>
						</section>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="col-md-4">
			<div class="panel panel-header">
				<h1 id="regtitle">App of the Week</h1>
			</div>
			<section>
				<div class="panel">
					<h2 id="details">Whatsapp</h2>
					<figure>
						<img alt="App of the Week"
							src="${pageContext.request.contextPath}/resources/images/topwindows.png" height="350px"
							width="350px">
					</figure>
					<div id="blank"></div>
					<p>Vivamus elementum semper nisi. Aenean vulputate eleifend
						tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
						ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,
						tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque
						rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue.
						Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus.
						Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper
						libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc,
						blandit vel, luctus pulvinar, hendrerit id, lorem.</p>
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
						<img alt="App of the Week" src="${pageContext.request.contextPath}/resources/images/topiosapp.png"
							height="350px" width="350px">
					</figure>
					<div id="blank"></div>
					<p>Vivamus elementum semper nisi. Aenean vulputate eleifend
						tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
						ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,
						tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque
						rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue.
						Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus.
						Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper
						libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc,
						blandit vel, luctus pulvinar, hendrerit id, lorem.</p>
				</div>
			</section>
		</div>
		<div id="blank"></div>

	</div>
	<footer id="footer">
		<%@ include file="/WEB-INF/views/footer.jsp"%>
	</footer>
</body>
</html>