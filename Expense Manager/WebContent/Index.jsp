<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href='<c:url value="Scripts\Bootstrap\css\bootstrap.min.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="Scripts\CSS\Login.css"></c:url>'>
<script
	src='<c:url value="Scripts\Bootstrap\jQuery\jquery_3-2-1.js"></c:url>'></script>
<script
	src='<c:url value="Scripts\Bootstrap\js\bootstrap.min.js"></c:url>'></script>
<%-- <script
	src='<c:url value="Scripts\JS\Login.js"></c:url>'></script> --%>
<title>Expense manager</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="Login" method="post">
					<div class="imgcontainer">
						<img src="Images/Default_Avatar.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">
						<label for="userName"><b>Username</b></label>
						<input type="text" placeholder="Enter Username" name="userName" required>
						<label for="password"><b>Password</b></label>
						<input type="password" placeholder="Enter Password" name="password" required>
						<button type="submit">Login</button>
						<label class="center"><span class="forgotPassword"><a href="#">Forgot Password?</a></span></label>
					</div>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>