<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>LTVNC - Chat - Sign up</title>
<link href='<c:url value="/resources/css/bootstrap.min.css" />'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/sticky-footer-navbar.css" />'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/page.css" />' rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootbox.js" />">
	
</script>
<style type="text/css">
canvas {
	background: url("<c:url value='/resources/images/ltvnc.jpg' />")
		no-repeat center center fixed;
	-webkit-filter: blur(10px);
	background-size: cover;
	position: fixed;
	top: 0;
	left: 0;
	z-index: -100;
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<canvas id="background">
	</canvas>
	<div id="divback"></div>
	<div class="container">
		<div class="col-md-6 col-md-offset-4"
			style="height: 520px; position: absolute; top: 0; left: 0; bottom: 0; right: 0; margin: auto">
			<div class="col-md-6"
				style="background-color: white; border-radius: 10px; height: 100%">
				<div class="col-md-10 col-md-offset-1 container">
					<h3 style="text-align: center; color: gray;">Sign up</h3>
					<button class="btn btn-block"
						style="background-color: #3B5998; color: white; margin-top: 20px">
						<img height="20px" style="float: left" class="img-circle"
							src="<c:url value='/resources/images/Facebook-50.png' />">
						<span style="padding-left: 8px">Connect with Facebook</span>
					</button>

					<button class="btn btn-block"
						style="background-color: #DD4B39; color: white">
						<img height="20px" style="float: left" class="img-circle"
							src="<c:url value='/resources/images/Google Plus-50.png' />">
						<span style="padding-left: 8px">Sign in with Google</span>
					</button>
					<div style="text-align: center; margin-top: 10px">
						<p
							style="font-family: Geogria, serif; font-style: italic; font-size: 130%; color: gray">--
							or --</p>
					</div>
					<form id="signupform" action="<c:url value="/signup" />"
						method="post" class="form-horizontal">
						<div id="emaildiv" class="form-group has-feedback">
							<label>Email: </label><input class="form-control" type="text"
								name="email" placeholder="Enter your Email"
								data-toggle="tooltip" data-placement="top" title="" /> <span
								id="emailspan"
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="visibility: hidden;"></span>
						</div>
						<div id="passdiv" class="form-group has-feedback">
							<label>Password: </label><input class="form-control"
								type="password" name="password"
								placeholder="Enter your password" data-toggle="tooltip"
								data-placement="top" title="" /><span id="passspan"
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="visibility: hidden;"></span>
						</div>
						<div id="repassdiv" class="form-group has-feedback">
							<label>Re-Password: </label><input class="form-control"
								type="password" name="rePassword" placeholder="Re-password"
								data-toggle="tooltip" data-placement="top" title="" /><span
								id="repassspan"
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="visibility: hidden;"></span>
						</div>
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<button type="submit" class="btn btn-success btn-block"
									style="background-color: #99c432">Sign up</button>
							</div>
							<div class="col-md-8 col-md-offset-2"
								style="text-align: center; margin-top: 10px">
								<a href="<c:url value="/login" />" style="color: gray">Have
									an account, Login →</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4" style="margin-top: 42px">
				<p>"Welcome to LTVNC - Chat! Have a nice day"</p>
			</div>
			<div class="col-md-4" style="margin-top: 42px">
				<p>"LTVNC - VIET Programmers Connection"</p>
			</div>
		</div>
	</div>
</body>

<footer class="footer">
	<div class="container" style="text-align: center;">
		<p class="text-muted" style="color: white;">
			<strong>Lich King</strong> from <a href="http://www.laptrinhvnc.com"><span
				style="color: white; text-decoration: underline;">laptrinhvnc.com</span></a>
		</p>
	</div>
</footer>

<script type="text/javascript"
	src="<c:url value='/resources/js/page.js' />">
	
</script>
<script type="text/javascript"
	src="<c:url value='/resources/js/signup.js' />"></script>
</html>