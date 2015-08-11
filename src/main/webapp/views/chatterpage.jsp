<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LTVNC - Chatter</title>
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
</html>