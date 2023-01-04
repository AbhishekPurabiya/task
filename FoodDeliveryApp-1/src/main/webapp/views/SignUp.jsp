<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style type="text/css">
.bg {
	background-color: rgb(249, 252, 248);
	position: absolute; /* Stay fixed */
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 60%;
	text-align: center;
	justify-content: center;
	box-shadow: 2px 4px 4px rgb(90, 89, 89);
	padding-top: 100px;
	padding-bottom: 100px;
}
</style>
</head>
<body>

	<div class="bg">
		<form action="/food/user/signup" method="post">
			<div>
				<h2 class="text-center">Registration Form</h2>
				<br>
				<hr>
				<div class="row">
					<div class="col"><b><lable>Enter Username</lable></b></div>
					<div class="col"><input type="text" name="username" class="form-control" style="width: 70%;"></div> 
				</div>
				<br>
				<div>
				<div class="row">
					<div class="col"><b><lable>Enter Password</lable></b> </div>
					<div class="col"><input type="text"
						name="password" class="form-control" style="width: 70%;"></div>
				</div>
					<br>
				</div>
				<div>
				<div class="row">
					<div class="col"><b><lable>Enter Contact Number </lable></b></div>
					<div class="col"><input type="text"
						name="contact" class="form-control" style="width: 70%;"></div>
				</div>
					 <br>
				</div>
				<div>
				<div class="row">
					<div class="col"><b><lable>Enter Address</lable></b></div>
					<div class="col"><textarea type="text" name="address" class="form-control"
						style="width: 70%;"> </textarea></div>
				</div>
					<br>
					
				</div>
				<br>
				<button type="submit" class="btn btn-success" style="padding-left: 1cm; padding-right: 1cm;">Submit</button>
			</div>
		</form>

	</div>




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