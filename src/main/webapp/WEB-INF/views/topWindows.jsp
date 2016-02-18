<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Windows Apps</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myScript.js"></script>
</head>
<body id="win">
	<div id="mainhead">
	<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<div class="container-fluid">
	<c:forEach var="i" items="${apps}">
		<div class="col-md-3">
			<section>
				<div id="panelhead" class="panel panel-header"><a href="detailnreview/<c:out value="${i.appId}" />">
							<c:out value="${i.name}" /></a></div>
				<div class="panel">
					<figure>
						<img class="img-thumbnail" id="top" alt="Top Windows App"
							src="${pageContext.request.contextPath}/resources/images/topwindows.png">
					</figure>
					<br>
					<p id="topandroidtext"><c:out value="${i.details}" /></p>
				</div>
				<div>
					<div class="col-md-6">
						<figure>
							<img id="rating" alt="Rating" src="${pageContext.request.contextPath}/resources/images/rating.png">
						</figure>
					</div>
					<div class="col-md-6"></div>
					<a class="btn btn-info" href="detailnreview/<c:out value="${i.appId}" />">Review</a>
				</div>
			</section>
		</div>
		</c:forEach>
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
		<%@ include file="/WEB-INF/views/footer.jsp" %>
	</footer>
</body>
</html>