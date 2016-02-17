<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<section id="head">
		<div class="col-md-1">
			<figure>
				<a href="${pageContext.request.contextPath}/index"><img alt="Logo" src="${pageContext.request.contextPath}/resources/images/logo.png"
					height="100px" width="100px"></a>
			</figure>
		</div>

		<h1 id="title" class="col-md-6">Mobile App Review</h1>
		<div class="col-md-4" id="search"></div>
	</section>
</div>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="home" id="nav"><a href="${pageContext.request.contextPath}/index">Home</a></li>
			<li class="and" id="nav"><a href="${pageContext.request.contextPath}/topAndroid">Android
					Apps</a></li>
			<li class="ios" id="nav"><a href="${pageContext.request.contextPath}/topIPhone">iPhone
					Apps</a></li>
			<li class="win" id="nav"><a href="${pageContext.request.contextPath}/topWindows">Windows
					Apps</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form:form method="post" name="searchform" cssClass="form-inline" modelAttribute="search" action="${pageContext.request.contextPath}/searchDetails">
					<div class="input-group">
						<form:input path="name" cssClass="form-control pull-right"
							style="width: 300px; margin-right: 35px, border: 1px solid black;"
							placeholder="Search Apps"/> <span class="input-group-btn">
							<button type="reset" class="btn btn-default">
								<span class="glyphicon glyphicon-remove"> <span
									class="sr-only">Close</span>
								</span>
							</button>
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-search"> <span
									class="sr-only">Search</span>
								</span>
							</button>
						</span>
					</div>
				</form:form>
			</li>
			<li id="nav">
			<%if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
			<a href="${pageContext.request.contextPath}/login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a>
				<% } else { %>
				<a href="${pageContext.request.contextPath}/logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a>	
					<% } %>
					</li>
		</ul>
	</div>
</nav>
