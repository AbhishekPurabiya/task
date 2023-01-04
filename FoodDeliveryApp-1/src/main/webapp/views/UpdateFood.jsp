<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


</head>
<body>
	<div>
		<%@ include file="/views/AdminDashboard.jsp"%>
		<br>
		<h2 class="text-center">Update Food Details</h2>
		<br>
		<hr>

		<div class="container col-9 ">
			<form action="/food/updateDetails" method="post">

				<div class="form-floating mb-3">
					<input type="text" class="form-control" name="foodid"
						value="<c:out value='${food.foodid}'/>" readonly="readonly"
						id="foodName" placeholder="Food Id" style="width: 60%;">
					<label for="foodName">Food Id</label>
				</div>
				<br>
				<div class="row">
					<div clasa="col">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="fname"
								value="<c:out value='${food.fname}'/>" id="foodName"
								placeholder="Food Name" style="width: 60%;"> <label
								for="foodName">Food Name</label>
						</div>
					</div>
					<br>
					<div class="col">
						<select class="form-select" name="category"
							value="<c:out value='${food.category}'/>"
							aria-label="Default select example" style="width: 60%;">
							<option selected>Select Food Category</option>
							<option value="Veg">Veg</option>
							<option value="Non-Veg">Non-Veg</option>
							<option value="Indian">Indian</option>
							<option value="Italian">Italian</option>
							<option value="Chinese">Chinese</option>
							<option value="South Indian">South Indian</option>
							<option value="Punjabi">Punjabi</option>
							<option value="Gujrati">Gujrati</option>
							<option value="Biryani">Biryani</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div clasa="col">
						<div class="form-floating mb-3">
							<input type="number" class="form-control" name="price"
								value="<c:out value='${food.price}'/>" id="foodprice"
								placeholder="Food Price" style="width: 60%;"> <label
								for="foodprice">Food Price</label>
						</div>
					</div>
					<br>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="number" class="form-control" name="quantity"
								value="<c:out value='${food.quantity}'/>" id="foodquantity"
								placeholder="Food Quantity" style="width: 60%;"> <label
								for="foodquantity">Food Quantity</label>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div clasa="col">
						<select class="form-select" name="status"
							value="<c:out value='${food.status}'/>"
							aria-label="Default select example" style="width: 60%;">
							<option selected>Select Availability</option>
							<option value="Available">Available</option>
							<option value="Not Available">Not Available</option>
						</select>
					</div>
					<br>
					<div class="col">
						<div class="input-group mb-3">
						 <input type="file" class="form-control" name="fimage"
								id="inputGroupFile02" style="width: 60%;" value="<c:out value='${food.fimage}' />">
								 <label	class="input-group-text" for="inputGroupFile02">Upload
								Food Image</label>
						</div>
					</div>
				</div>

				<br> <br>
				<button type="submit" class="btn btn-primary"
					style="padding-left: 1cm; padding-right: 1cm;">Submit
					Details</button>

			</form>
		</div>




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