<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Order</title>
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
</style>
</head>
<body>
	<div>
		<%@ include file="/views/UserDashboard.jsp"%>
		<br>
		<h2 class="text-center">Order Details</h2>
		<hr>


		<form action="/food/user/cart/order/payment" method="post">

			<div class="container col-11">

				<div class="grid">
					<div class="row">
						<div class="col">
							<img src="/Images/${ cart.fimage}"
								style="height: 250px; width: 250px;" />
						</div>
						<div class="col">
							<div class="row">
								<div class="col">
									<label>Food Name</lable>
										<p>${cart.fname}</p>
								</div>
								<div class="col">
									<label>Food Category</lable>
										<p>${cart.category}</p>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<label>Food Quantity</lable> <input class="form-control col-1"
										type="number" id="quantity" onchange="cal()" name="quantity">
								</div>
								<div class="col">
									<label>Food Status</lable>
										<p>${cart.status}</p>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<label>Food Price</lable> <input class="form-control col-1"
										name="price" id="price" value="${cart.price}" readonly />
								</div>
								<div class="col">
								<label>Total Price</lable>
									<input class="form-control col-2" name="totalprice" id="total" />
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col"></div>
								<div class="col">
									<button class="btn btn-success" type="submit">Place Order</button>
								</div>
							</div>
							
						</div>

					</div>
				</div>
			</div>

		</form>
	</div>

	<script type="text/javascript">
		function GetTotal() {
			var quantity = document.getElementById("quantity").value;
			var price = document.getElementById("price").value;
			return parseInt(quantity * price);
		}

		function cal() {
			if (document.getElementById("quantity")) {
				document.getElementById("total").value = GetTotal();
			}
		}
	</script>


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