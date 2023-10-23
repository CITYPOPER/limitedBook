<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Signup Form with AJAX and jQuery Validations</title>
    <meta name="description" content="Signup form created using Boostrap 4 with jQuery validations and AJAX form submit that returns JSON response." />

    <!-- Bootstrap CSS -->
    <link href="assets2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets2/css/font-awesome.min.css" rel="stylesheet" />
    <link href="assets2/css/custom.css" rel="stylesheet" />
	<link href="assets2/css/open-iconic-bootstrap.min.css" rel="stylesheet" />
	<link href="assets2/css/styles.css" rel="stylesheet" />
    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-47923629-1', 'gigagit.com');
      ga('send', 'pageview');

    </script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-6 align-self-center">
                <form id="form_signup" method="post" action="./SignController.si" novalidate="novalidate">
                    <div class="card">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <h5 class="card-title m-0">
                                    <i class="fa fa-lock mr-1"></i>SIGNUP
                                </h5>
                            </li>
                            <li class="list-group-item">
                                <div class="form-row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="signup_name">Name</label>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-user"></i>
                                                </span>
                                                <input type="text" id="signup_name" name="signup_name" class="form-control" placeholder="Name" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="signup_email">Email address</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                        <input type="email" id="signup_email" name="signup_email" class="form-control" placeholder="Enter email" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="signup_password">Password</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-unlock-alt"></i>
                                        </span>
                                        <input type="password" id="signup_password" name="signup_password" class="form-control" placeholder="Password" />
                                    </div>
                                </div>  
                                <div class="form-group">
                                    <label for="signup_confirm_password">Confirm Password</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-unlock-alt"></i>
                                        </span>
                                        <input type="password" id="signup_confirm_password" name="signup_confirm_password" class="form-control" placeholder="Confirm Password" />
                                    </div>
                                </div>                                  
                            </li>
                            <li class="list-group-item">
                                <button type="submit" class="btn btn-primary">SIGN-UP</button>
                            </li>
                        </ul>
                    </div>
    				<input type="hidden" name="actionType" value="signC">
                </form>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
        </div>
    </footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="assets2/js/jquery-3.2.1.min.js"></script>
    <script src="assets2/js/popper.min.js"></script>
    <script src="assets2/js/bootstrap.min.js"></script>
	<script src="assets2/js/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="assets2/js/app.js"></script>

</body>
</html> 