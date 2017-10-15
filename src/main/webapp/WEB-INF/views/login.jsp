<header>
	<jsp:include page="header.jsp" />
</header>

<br>
<br>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="form-body">
				<ul class="nav nav-tabs final-login">
					<li class="active"><a data-toggle="tab" href="#sectionA">Sign
							In</a></li>
					<li><a data-toggle="tab" href="#sectionB">Join us!</a></li>
				</ul>
				<div class="tab-content">
					<div id="sectionA" class="tab-pane fade in active">
						<div class="innter-form">
							<form class="sa-innate-form" method="post"
								  action="/login">
								<label>Email Address</label> <input
									type="text" name="username" value="demo">
								<label>Password</label> <input
									type="password" name="password"
									value="demo">
								<button type="submit">Sign In</button>
								<a href="">Forgot Password?</a>
							</form>
						</div>
						<div class="social-login">
							<p>- - - - - - - - - - - - - Sign In With - - - - - - - - - -
								- - -</p>
							<ul>
								<li class="oauth-button" style="width: 100%"><a class="oauth-button" href="#"><i
										class="fa fa-facebook"></i> My OAuth 2 </a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<footer>
	<jsp:include page="footer.jsp" />
</footer>
