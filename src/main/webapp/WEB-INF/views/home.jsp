<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Login | A client company</title>
  	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
     <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
   </head>
  
  <body>
<br>
<br>
<div class="container">
<div class="row">
<div class="col-md-4 col-md-offset-4">
<div class="form-body">
    <ul class="nav nav-tabs final-login">
        <li class="active"><a data-toggle="tab" href="#sectionA">Sign In</a></li>
        <li><a data-toggle="tab" href="#sectionB">Join us!</a></li>
    </ul>
    <div class="tab-content">
        <div id="sectionA" class="tab-pane fade in active">
        <div class="innter-form">
            <form class="sa-innate-form" method="post">
            <label>Email Address</label>
            <input type="text" name="username">
            <label>Password</label>
            <input type="password" name="password">
            <button type="submit">Sign In</button>
            <a href="">Forgot Password?</a>
            </form>
            </div>
            <div class="social-login">
            <p>- - - - - - - - - - - - - Sign In With - - - - - - - - - - - - - </p>
    		<ul>
            <li><a href=""><i class="fa fa-facebook"></i> Facebook</a></li>
            <li><a href=""><i class="fa fa-google-plus"></i> Google+</a></li>
            <li><a href=""><i class="fa fa-twitter"></i> Twitter</a></li>
            </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </div>
    </div>
    </div>
    </div>
  
  </body>
 </html>