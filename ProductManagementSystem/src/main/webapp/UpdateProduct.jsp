<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
<jsp:include  page="header.jsp" />


	<br>
	<h2>Enter the Product Details for Update......</h2>
	<br>
	<form action="http://localhost:8080/ProductManagementSystem/ProductController" method="post">
		<div class="container col-6">
			<div class="form-floating mb-3">
				<input type="number" class="form-control" id="id"
					placeholder="Product Id" name="productId"> <label for="id">Product
					Id</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="name"
					placeholder="Product Name" name="productName"> <label
					for="name">Product Name</label>
			</div>
			<div class="form-floating mb-3">
				<input type="number" class="form-control" id="Price"
					placeholder="Product Price" name="productPrice"> <label
					for="price">Product Price</label>
			</div>
		</div>
		<button type="submit" class="btn btn-primary" value="update" name="action">Update</button>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
</body>
</html>