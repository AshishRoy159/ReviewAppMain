<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Details</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link href="resources/css/mystyle.css" rel="stylesheet" />
<script src="resources/js/jquery-2.2.0.js"></script>
<script src="resources/js/myScript.js"></script>
</head>
<body>
	<div id="mainhead">
	<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<div class="container-fluid">
		<div id="content" class="col-md-8">
			<figure>
				<img alt="App Banner" src="resources/images/facebook.png" height="300px"
					width="750px">
			</figure>
			<div class="container-fluid">
				<div class="col-md-9">
					<h1 id="title">Facebook</h1>
					<h4 id="developer">
						<b>Developed By: </b> Facebook Inc.
					</h4>
				</div>
				<div class="col-md-3" align="right">
					<figure>
						<img id="ratingdt" alt="Rating" src="resources/images/rating.png"
							height="40px" width="180px">
					</figure>
				</div>

			</div>
			<div class="container-fluid">
				<div class="col-md-9">
					<h4 id="developer">
						<b>Platform : </b> Android / iOS / Windows
					</h4>
				</div>
			</div>
			<section>
				<h2 id="details">Details:</h2>
				<div id="detail">
					Keeping up with friends is faster than ever.<br> â¢ See what
					friends are up to <br> â¢ Share updates, photos and videos <br>
					â¢ Get notified when friends like and comment on your posts <br>
					â¢ Play games and use your favorite apps <br> Now you can get
					early access to the next version of Facebook for Android by
					becoming a beta tester. <br> Learn how to sign up, give
					feedback and leave the program in our Help Center:
					http://on.fb.me/133NwuP <br> Sign up directly here:
					http://play.google.com/apps/testing/com.facebook.katana <br>
					Problems downloading or installing the app? See
					http://bit.ly/GPDownload1 <br> Still need help? Please tell us
					more about the issue. http://bit.ly/invalidpackage <br>
					Facebook is only available for users age 13 and over. <br>
					Terms of Service: http://m.facebook.com/terms.php.
				</div>
			</section>
			<div id="blank"></div>
			<section>
				<div class="col-md-4">
					<img alt="Screenshot 1" src="resources/images/fb1.png" height="300px"
						width="200px">
				</div>
				<div class="col-md-4">
					<img alt="Scerrenshot 2" src="resources/images/fb2.png" height="300px"
						width="200px">
				</div>
				<div class="col-md-4">
					<img alt="Screenshot 3" src="resources/images/fb3.png" height="300px"
						width="200px">
				</div>
			</section>
			<hr>
			<% if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
			<div id="largeblank"></div>
			<div id="blank"></div>
			<hr>
			<%}else { %>
			<div class="container-fluid">
				<div id="ratingtxt" class="col-md-6" align="left">Your Rating</div>
				<div class="col-md-6" align="right" id="jRate">
					
				</div>
			</div>
			<div id="blank"></div>
			<hr>
			
			<div id="usercomment">
				<div id="user">
					<h2 id="details">User's Name</h2>
				</div>
				<div id="comment">
					<form action="">
						<div>
							<textarea class="form-control" rows="6" cols="50"></textarea>
						</div>
						<div id="blank"></div>
						<input class="btn btn-default" type="submit" name="submit"
							value="Post"> <input class="btn btn-default" type="reset"
							name="reset" value="Clear">

					</form>
				</div>
			</div>
			<%} %>
			<hr>
			<div id="comments">
				<section>
					<blockquote class="quote-box">
						<p class="quotation-mark"></p>
						<p class="quote-text">Don't believe anything that you read on
							the internet, it may be fake.</p>
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

		<div class="col-md-4">
			<div class="panel panel-header">
				<h1 id="regtitle">App of the Week</h1>
			</div>
			<section>
				<div class="panel">
					<h2 id="details">Whatsapp</h2>
					<figure>
						<img alt="App of the Week" src="resources/images/topwindows.png"
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
			<hr>
			<div class="panel panel-header">
				<h1 id="regtitle">App of the Month</h1>
			</div>
			<section>
				<div class="panel">
					<h2 id="details">Twitter</h2>
					<figure>
						<img alt="App of the Week" src="resources/images/topiosapp.png"
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
	</div>
	<footer id="footer"> 
	<%@ include file="/WEB-INF/views/footer.jsp" %>
	</footer>
</body>
</html>