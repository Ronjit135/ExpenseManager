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
<link rel="stylesheet" href="Scripts/CSS/Category.css">

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
						<li class="active"><a href="Categories">Categories</a></li>
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
				<div style="margin: 0 auto;">
					<c:if test="${userWallets.size() > 0}">
						<form action="Categories" method="post">
							<select name="walletId" required="required">
								<c:forEach var="wallet" items="${userWallets}">
									<option value="${wallet.walletId}" required="required">${wallet.walletName}</option>
								</c:forEach>
							</select> <input type="submit" value="Show Categories">
						</form>
					</c:if>
				</div>
				<div>
					<hr>
				</div>
				<div>
					<c:if test="${showCategories}">
						<div style="margin: 0 auto; width: 30%">
							<form role="form" action="Categories/Add" method="post">
								<div class="row">
									<h2 align="center">Add Category</h2>
									<div class="col-sm-12">
										<div class="form-group">
											<label for="categoryName">Category Name</label> <input
												type="text" name="categoryName" id="categoryName"
												class="form-control input-lg" placeholder="Category Name"
												tabindex="1" required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="categoryDesc">Category Description</label> <input
												type="text" name="categoryDesc" id="categoryDesc"
												class="form-control input-lg"
												placeholder="Category Description" tabindex="1"
												required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="categoryType">Category Type &nbsp;</label>
										</div>
									</div>
									<div class="col-sm-6">
										<select name="categoryType" id="categoryType"
											required="required" style="width: 100%">
											<option value="Income">Income</option>
											<option value="Expense">Expense</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="walletId">Wallet</label> <select id="walletId"
												name="walletId" required="required" style="width: 100%">
												<option value="${userWallet.walletId}">${userWallet.walletName}</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-md-3"></div>
									<div class="col-xs-12 col-md-6">
										<input type="submit" value="Add Category"
											class="btn btn-success btn-block btn-lg">
									</div>
									<div class="col-xs-12 col-md-3"></div>
								</div>
							</form>
						</div>
						<div>
							<hr>
						</div>
						<div style="margin: 0 auto;">
							<div class="row">
								<div class="col-sm-12">
									<form method="post">
										<table border="1" style="widtrh: 100%; text-align: center">
											<tr>
												<td width="10%"></td>
												<td width="10%" align="center">Category ID</td>
												<td width="30%">Category Name</td>
												<td width="30%">Category Description</td>
												<td width="10%">Category Type</td>
												<td width="10%">Wallet ID</td>
											</tr>
											<c:forEach var="category" items="${walletCategoryIncome}">
												<tr>
													<td><input type="radio" name="categoryId"
														value="${category.categoryId}"></td>
													<td>${category.categoryId}</td>
													<td>${category.categoryName}</td>
													<td>${category.categoryDesc}</td>
													<td>${category.categoryType}</td>
													<td>${category.wallet.walletName}</td>
												</tr>
											</c:forEach>
											<tr>
												<td><input type="submit" value="Edit Category"
													formaction="Categories/EditCategory"></td>
												<td><input type="submit" value="Delete Category"
													formaction="Categories/DeleteCategory"></td>
											</tr>
										</table>
									</form>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<form method="post">
										<table border="1" style="widtrh: 100%; text-align: center">
											<tr>
												<td width="10%"></td>
												<td width="10%" align="center">Category ID</td>
												<td width="30%">Category Name</td>
												<td width="30%">Category Description</td>
												<td width="10%">Category Type</td>
												<td width="10%">Wallet ID</td>
											</tr>
											<c:forEach var="category" items="${walletCategoryExpense}">
												<tr>
													<td><input type="radio" name="categoryId"
														value="${category.categoryId}"></td>
													<td>${category.categoryId}</td>
													<td>${category.categoryName}</td>
													<td>${category.categoryDesc}</td>
													<td>${category.categoryType}</td>
													<td>${category.wallet.walletName}</td>
												</tr>
											</c:forEach>
											<tr>
												<td><input type="submit" value="Edit Category"
													formaction="Categories/EditCategory"></td>
												<td><input type="submit" value="Delete Category"
													formaction="Categories/DeleteCategory"></td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div>
					</c:if>
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