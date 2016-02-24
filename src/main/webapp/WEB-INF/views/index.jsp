<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile App Review</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myScript.js"></script>

</head>
<body id="home">
	<div id="mainhead">	
	<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<div class="container">
		<div class="col-md-9" id="content">
			<figure>
				<img id="banner" alt="Main Banner" src="${pageContext.request.contextPath}/resources/images/header.jpg">
			</figure>
			<div>
				<hr>
				<div id="maincontent">
					<h1 id="mostreview">Most Reviewed Apps</h1>
					<hr>
					<div class="col-md-4">
						<section>
							<div id="panelhead" class="panel panel-header">Top Android
								App</div>
							<div class="panel">
								<h1 id="pop">
									<a href="detailnreview">Facebook</a>
								</h1>
								<figure>
									<img class="img-thumbnail" id="top" alt="Top Android App"
										src="${pageContext.request.contextPath}/resources/images/androidtopreview.jpg">
								</figure>
								<br>
								<p id="topandroidtext">Vivamus elementum semper nisi. Aenean
									vulputate eleifend tellus. Aenean leo ligula, porttitor eu,
									consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus
									in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut
									metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam
									ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.
									Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget
									condimentum rhoncus, sem quam semper libero, sit amet
									adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel,
									luctus pulvinar, hendrerit id, lorem.</p>
							</div>
							<div>
								<div class="col-md-6">
									<figure>
										<img id="rating" alt="Rating" src="${pageContext.request.contextPath}/resources/images/rating.png">
									</figure>
								</div>
								<div class="col-md-6" align="right"></div>
								<a class="btn btn-info" href="#">Review</a>
							</div>
						</section>
					</div>
					<div class="col-md-4">
						<section>
							<div id="panelhead" class="panel panel-header">Top iPhone
								App</div>
							<div class="panel">
								<h1 id="pop">Twitter</h1>
								<figure>
									<img class="img-thumbnail" id="top" alt="Top iPhone App"
										src="${pageContext.request.contextPath}/resources/images/topiosapp.png">
								</figure>
								<br>
								<p id="topandroidtext">Vivamus elementum semper nisi. Aenean
									vulputate eleifend tellus. Aenean leo ligula, porttitor eu,
									consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus
									in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut
									metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam
									ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.
									Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget
									condimentum rhoncus, sem quam semper libero, sit amet
									adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel,
									luctus pulvinar, hendrerit id, lorem.</p>
							</div>
							<div>
								<div class="col-md-6">
									<figure>
										<img id="rating" alt="Rating" src="${pageContext.request.contextPath}/resources/images/rating.png">
									</figure>
								</div>
								<div class="col-md-6" align="right"></div>
								<a class="btn btn-info" href="#">Review</a>
							</div>
						</section>
					</div>

				</div>
				<div class="col-md-4">
					<section>
						<div id="panelhead" class="panel panel-header">Top Windows
							App</div>
						<div class="panel">
							<h1 id="pop">Whatsapp</h1>
							<figure>
								<img class="img-thumbnail" id="top" alt="Top Windows App"
									src="${pageContext.request.contextPath}/resources/images/topwindows.png">
							</figure>
							<br>
							<p id="topandroidtext">Vivamus elementum semper nisi. Aenean
								vulputate eleifend tellus. Aenean leo ligula, porttitor eu,
								consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus
								in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut
								metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam
								ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.
								Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget
								condimentum rhoncus, sem quam semper libero, sit amet adipiscing
								sem neque sed ipsum. Nam quam nunc, blandit vel, luctus
								pulvinar, hendrerit id, lorem.</p>
						</div>
						<div>
							<div class="col-md-6">
								<figure>
									<img id="rating" alt="Rating" src="${pageContext.request.contextPath}/resources/images/rating.png">
								</figure>
							</div>
							<div class="col-md-6" align="right"></div>
							<a class="btn btn-info" href="#">Review</a>
						</div>
					</section>
				</div>

			</div>
		</div>

		<div class="col-md-3" id="review">
			<section>
				<header id="recent">Recent Reviews</header>
				<img class="img-thumbnail" id="recentimg" alt="Recent Review"
					src="${pageContext.request.contextPath}/resources/images/recentimg.jpg">
				<div id="blank"></div>
				<p id="recentreview">Lorem ipsum dolor sit amet, consectetuer
					adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.
					Cum sociis natoque penatibus et magnis dis parturient montes,
					nascetur ridiculus mus. Donec quam felis, ultricies nec,
					pellentesque eu, pretium quis, sem. Nulla consequat massa quis
					enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
					arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
					justo. Nullam dictum felis eu pede mollis pretium. Integer
					tincidunt. Cras dapibus.</p>
			</section>
			<hr>
			<section>
				<header id="popular">Other Popular Apps</header>
				<div>
					<div class="panel">
						<h1 id="pop">Sample Game</h1>
						<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
							justo.</p>
					</div>
					<div class="panel">
						<h1 id="pop">Sample App</h1>
						<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
							justo.</p>
					</div>
					<div class="panel">
						<h1 id="pop">Sample Editor</h1>
						<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
							justo.</p>
					</div>
					<div class="panel">
						<h1 id="pop">Sample Theme</h1>
						<p>In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
							justo.</p>
					</div>
				</div>
			</section>
		</div>
	</div>
	<hr>
	<div id="blank"></div>
	<footer id="footer">
	<%@ include file="/WEB-INF/views/footer.jsp" %>
	</footer>
	<div id="blank"></div>
</body>
</html>