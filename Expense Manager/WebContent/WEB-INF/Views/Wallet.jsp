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
<link rel="stylesheet" href="Scripts/CSS/Wallet.css">

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
						<li class="active"><a href="Wallets">Wallets</a></li>
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
			<div style="margin: 0 auto; width: 30%">
				<form role="form" action="Wallets/Add" method="post">
					<div class="row">
						<h2 align="center">Add Wallet</h2>
						<div class="col-sm-12">
							<div class="form-group">
								<label for="walletName">Wallet Name</label> <input type="text"
									name="walletName" id="walletName" class="form-control input-lg"
									placeholder="Wallet Name" tabindex="1" required="required">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="currentBalance">Initial Balance</label> <input
									type="number" name="currentBalance" id="currentBalance"
									class="form-control input-lg" placeholder="Initial Balance"
									tabindex="1" value="0" required="required" min="0">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Add Wallet"
								class="btn btn-success btn-block btn-lg">
						</div>
					</div>
				</form>
			</div>
			<div>
				<hr>
			</div>
			<div style="margin: 0 auto; width: 50%">
				<form action="Wallets/Delete" method="post">
					<table class="table table-hover">
						<thead>
							<tr align="center">
								<td width="10%"></td>
								<td width="30%"><b>Wallet ID</b></td>
								<td width="30%"><b>Wallet Name</b></td>
								<td width="30%"><b>Wallet Balance</b></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="wallet" items="${userWallets}">
								<tr align="center">
									<td><input type="radio" name="walletId"
										value="${wallet.walletId}" required="required" /></td>
									<td>${wallet.walletId}</td>
									<td>${wallet.walletName}</td>
									<td>${wallet.currentBalance}</td>
								</tr>
							</c:forEach>
							<c:set var="list" scope="session" value="${userWallets.size()}"></c:set>
							<c:if test="${list==0}">
								<tr>
									<td colspan="4" align="center"><h4>No Wallets</h4></td>
								</tr>
							</c:if>
							<c:if test="${list>0}">
								<tr>
									<td colspan="4" align="center"><input type="submit"
										id="deleteWallet" value="Delete Wallet"
										class="btn btn-success btn-block" style="width: 25%"></td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</form>
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