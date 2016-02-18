<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
<script type="text/javascript" src="resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="resources/js/myScript.js"></script>
</head>
<body>
	<div id="mainhead">
		<%@ include file="/WEB-INF/views/header.jsp"%>
	</div>
	<div class="container-fluid">
		<div class="col-md-9" id="content">
			<c:forEach var="i" items="${apps}">
				<section>
					<div class="container-fluid">
						<div id="panelhead">
						<a href="detailnreview/<c:out value="${i.appId}" />">
							<c:out value="${i.name}" /></a>
						</div>
						<div class="col-md-3">
							<figure>
								<img class="img-thumbnail" id="top2" alt="Top iPhone App"
									src="resources/images/topiosapp.png">
							</figure>
						</div>
						<div class="col-md-9" align="left">
							<div>
								<p id="topandroidtext">
									<c:out value="${i.details}" />
								</p>
							</div>
							<div class="col-md-6" align="left">
								<figure>
									<img id="rating" alt="Rating" src="resources/images/rating.png">
								</figure>
							</div>
							<div class="col-md-6" align="right">
								<a class="btn btn-info" href="detailnreview/<c:out value="${i.appId}" />">Review</a>
							</div>

						</div>
					</div>
				</section>

				<hr>

			</c:forEach>
		</div>
		<div class="col-md-3" id="review">
			<section>
				<header id="popular" class="panel panel-header">Frequently
					Searched Apps</header>
				<div>
					<div>
						<section>
							<h1 id="pop">Sample Game</h1>
							<div>
								<div class="col-md-6">
									<img class="img-thumbnail" alt="Top iPhone App"
										src="resources/images/topiosapp.png" height="110px"
										width="110px">
								</div>
								<div class="col-md-6">
									<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
										justo.</p>
								</div>
							</div>
						</section>
					</div>
					<div>
						<section>
							<h1 id="pop">Sample App</h1>
							<div>
								<div class="col-md-6">
									<img class="img-thumbnail" alt="Top iPhone App"
										src="resources/images/topiosapp.png" height="110px"
										width="110px">
								</div>
								<div class="col-md-6">
									<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
										justo.</p>
								</div>
							</div>
						</section>
					</div>
					<div>
						<section>
							<h1 id="pop">Sample Editor</h1>
							<div class="col-md-6">
								<img class="img-thumbnail" alt="Top iPhone App"
									src="resources/images/topiosapp.png" height="110px"
									width="110px">
							</div>
							<div class="col-md-6">
								<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
									justo.</p>
							</div>
						</section>
					</div>
					<div>
						<section>
							<h1 id="pop">Sample Theme</h1>
							<div class="col-md-6">
								<img class="img-thumbnail" alt="Top iPhone App"
									src="resources/images/topiosapp.png" height="110px"
									width="110px">
							</div>
							<div class="col-md-6">
								<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
									justo.</p>
							</div>
						</section>
					</div>
					<div>
						<section>
							<h1 id="pop">Sample Utility</h1>
							<div class="col-md-6">
								<img class="img-thumbnail" alt="Top iPhone App"
									src="resources/images/topiosapp.png" height="110px"
									width="110px">
							</div>
							<div class="col-md-6">
								<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
									justo.</p>
							</div>
						</section>
					</div>
				</div>
			</section>
		</div>
	</div>
	<hr>
	<div class="container" align="center">
		<ul class="pagination pagination-lg">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
	<div id="blank"></div>
	<footer id="footer">
		<%@ include file="/WEB-INF/views/footer.jsp"%>
	</footer>
</body>
</html>