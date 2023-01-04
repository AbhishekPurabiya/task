<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User DashBoard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style>
label {
	font-weight: bold;
}

p {
	color: brown;
}

.filetr {
	display: flex;
	flex-direction: row;
	column-gap: 1cm;
}
</style>
</head>
<body>
	<div>
		<%@ include file="/views/UserDashboard.jsp"%>
		<br>

		<form action="/food/user/filter" method="post">
			<div class="d-flex flex-row" ">
				<div class="filter col-3 " style="margin-left: 1cm; margin-right: 1cm;">
					<select class="form-select" name="filter"
						aria-label="Default select example">
						<option selected>Select Filter</option>
						<option value="foodName">By Food Name</option>
						<option value="foodCategory">By Food Category</option>
						<option value="foodPrice">By Food Price</option>
					</select>
				</div>
				<div class="filter col-4" style="margin-left: 1cm; margin-right: 1cm;">
					<input class="form-control" type="text" placeholder="Serch here..." name="search" />
				</div>
				<div class="filter col-2" style="margin-left: 1cm; margin-right: 1cm;">
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</div>
		</form>

		<h2 class="text-center">Food Details</h2>
		<hr>

		<ol>
			<c:forEach items="${foodlist}" var="food">

				<div class="container col-11">
					<li>
						<div class="grid">
							<div class="row">
								<div class="col">
									<img src="/Images/${ food.fimage}"
										style="height: 250px; width: 250px;" />
								</div>
								<div class="col">
									<div class="row">
										<div class="col">
											<label>Food Name</lable>
												<p>${food.fname}</p>
										</div>
										<div class="col">
											<label>Food Category</lable>
												<p>${food.category}</p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<label>Food Quantity</lable>
												<p>${food.quantity}</p>
										</div>
										<div class="col">
											<label>Food Status</lable>
												<p>${food.status}</p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<label>Food Price</lable>
												<p>${food.price}</p>
										</div>
										<div class="col">
											<a href="/food/user/cart/add?foodid=${food.foodid}">
												<button class="btn btn-success">Add to Cart</button>
											</a>



										</div>
									</div>
								</div>
							</div>
						</div>
						<hr>
					</li>
				</div>


			</c:forEach>
		</ol>
	</div>




	<!--linking the bootstrap js-->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>