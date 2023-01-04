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
.filet{
	display: flex;
	flex-direction: row;
	column-gap: 1cm;
	float: right;
}

</style>
</head>
<body>
	<div>
		<%@ include file="/views/UserDashboard.jsp"%>
		<br>
		<div class="filter">
			<form action="/food/user/filter" >
				<div >
					<select class="form-select col-2"  name="filter" aria-label="Default select example">
					  <option selected>Select Filter</option>
					  <option value="foodName">By Food Name</option>
					  <option value="foodCategory">By Food Category</option>
					  <option value="foodPrice">By Food Price</option>
					</select>
				</div>
				<div>
					<input class="form-control col-2" type="text" name="search"/>
				</div>
				<div>
					<button type="submit" class="btn-success">Search</button>
				</div>
			</form>
		</div>
		<h2 class="text-center">Food Details</h2>
		<hr>

		<h2 class="text-center text-danger ">!Sorry No Such Food Is Available..</h2>
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