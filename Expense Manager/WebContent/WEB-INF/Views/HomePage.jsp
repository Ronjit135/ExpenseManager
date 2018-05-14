<%@page import="com.app.common.constants.Constants"%>
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
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>EM</h3>
			</div>

			<ul class="list-unstyled components">
				<li class="active"><a href="Home">Home</a></li>
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
			<div style="margin: 0 auto;">
				<c:if test="${userWallets.size()>0}">
					<div class="row">
						<form action="Home/Add" method="post">
							<select name="walletId" required="required">
								<c:forEach var="wallet" items="${userWallets}">
									<option value="${wallet.walletId}">${wallet.walletName}</option>
								</c:forEach>
							</select> <input type="submit" value="Add" />
						</form>
					</div>
					<div>
						<hr>
					</div>
				</c:if>
				<c:set var="addTransaction" scope="page"
					value="${showAddTransaction}"></c:set>
				<c:if test="${addTransaction}">
					<div style="margin: 0 auto; width: 30%">
						<form action="Home/AddTransaction" method="post">
							<div class="row">
								<h2 align="center">Add Transaction</h2>
								<div class="col-sm-12">
									<div class="form-group">
										<label for="transactionDesc">Description</label> <input
											type="text" name="transactionDesc" id="transactionDesc"
											class="form-control input-lg" placeholder="Description"
											tabindex="1" required="required">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="amount">Amount</label><input type="number" min="0"
											value="0" name="amount" id="amount"
											class="form-control input-lg" placeholder="Amount"
											tabindex="1" required="required">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="categoryId">Category</label> &nbsp; <select
											name="categoryId" id="categoryId" required="required"
											style="width: 100%">
											<c:forEach var="category" items="${walletCategory}">
												<option value="${category.categoryId}">${category.categoryName}
													&nbsp; (${category.categoryType})</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="walletId">Wallet</label> &nbsp; <select
											name="walletId" id="walletId" required="required"
											style="width: 100%">
											<option value="${userWallet.walletId}">${userWallet.walletName}</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<input type="submit" value="Add"
										class="btn btn-success btn-block btn-lg">
								</div>
							</div>
						</form>
					</div>
				</c:if>
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