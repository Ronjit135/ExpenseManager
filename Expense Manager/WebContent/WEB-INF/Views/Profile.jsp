<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="Scripts/CSS/HomePage.css">
<link rel="stylesheet" href="Scripts/CSS/Profile.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <link rel="stylesheet"
	href='<c:url value="Scripts/Bootstrap/css/bootstrap.min.css"></c:url>'>
<script
	src='<c:url value="Scripts/Bootstrap/jQuery/jquery_3-2-1.js"></c:url>'></script>
<script
	src='<c:url value="Scripts/Bootstrap/js/bootstrap.min.js"></c:url>'></script> --%>
<title>EM</title>
</head>
<body>
	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>EM</h3>
			</div>

			<ul class="list-unstyled components">
				<li><a href="Home">Home</a></li>
				<li><a href="#pageSubmenu" data-toggle="collapse"
					aria-expanded="false">Actions</a>
					<ul class="collapse list-unstyled" id="pageSubmenu">
						<li><a href="Transactions">Transactions</a></li>
						<li><a href="Categories">Categories</a></li>
						<li><a href="Wallets">Wallets</a></li>
					</ul></li>
				<li><a href="About">About</a></li>
				<li><a href="Contact">Contact</a></li>
			</ul>
		</nav>
		<!-- Page Content Holder -->
		<div id="content" style="width: 100%">
			<nav class="navbar navbar-default">
				<div class="container-fluid">

					<div class="navbar-header">
						<button type="button" id="sidebarCollapse" class="navbar-btn">
							<span></span> <span></span> <span></span>
						</button>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li><span></span></li>
							<li><span></span></li>
							<li><span></span></li>
							<li><span></span></li>
							<li><a href="Profile"><span
									class="glyphicon glyphicon-user"></span>
									${sessionScope.user.firstName}</a></li>
							<li><a href="Logout"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div>
				<br> <br>
				<div class="row" id="main">
					<div class="col-md-4 well" id="leftPanel">
						<div class="row">
							<div class="col-md-12">
								<div>
									<img src="Images/Default_Avatar.png" alt="User Image"
										class="img-circle img-thumbnail">
									<h2>User</h2>
									<p>Text</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8 well" id="rightPanel">
						<div class="row">
							<div class="col-md-12">
								<form role="form" action="Profile/Save" method="post">
									<h2 align="center">User Profile</h2>
									<hr class="colorgraph">
									<div class="row">
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="form-group">
												<label for="userName">User Name</label> <input type="text"
													name="userName" id="userName" class="form-control input-lg"
													placeholder="User Name" tabindex="1"
													value="${user.userName}" required="required">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12 col-sm-4 col-md-4">
											<div class="form-group">
												<label for="firstName">First Name</label> <input type="text"
													name="firstName" id="firstName"
													class="form-control input-lg" placeholder="First Name"
													tabindex="1" value="${user.firstName}" required="required">
											</div>
										</div>
										<div class="col-xs-12 col-sm-4 col-md-4">
											<div class="form-group">
												<label for="middleName">Middle Name</label> <input
													type="text" name="middleName" id="middleName"
													class="form-control input-lg" placeholder="Middle Name"
													tabindex="1" value="${user.middleName}" required="required">
											</div>
										</div>
										<div class="col-xs-12 col-sm-4 col-md-4">
											<div class="form-group">
												<label for="lastName">Last Name</label> <input type="text"
													name="lastName" id="lastName" class="form-control input-lg"
													placeholder="Last Name" tabindex="2"
													value="${user.lastName}">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12 col-sm-6 col-md-6">
											<div class="form-group">
												<label for="password">Password</label> <input
													type="password" name="password" id="password"
													class="form-control input-lg" placeholder="Password" value="${user.password}"
													tabindex="5" required="required">
											</div>
										</div>
									</div>
									<hr class="colorgraph">
									<div class="row">
										<div class="col-xs-12 col-md-4"></div>
										<div class="col-xs-12 col-md-4">
											<input type="submit" value="Save"
												class="btn btn-success btn-block btn-lg">
										</div>
										<div class="col-xs-12 col-md-4"></div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
				$(this).toggleClass('active');
			});
		});
	</script>
</body>
</html>