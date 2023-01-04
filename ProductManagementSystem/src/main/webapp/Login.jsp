<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.login-form {
	display: flex;
	flex-direction: column;
	row-gap: 1cm;
	justify-content: center;
	align-content: center;
}
</style>
<body>
	<div class="login-form">
		<form action="LoginController.jsp">
			<h2>Enter your Login Details...</h2>
			<br>
			<lable>Username : </lable>
			<input type="text" name="userName" /> <br> <br>
			<lable>Password : </lable>
			<input type="text" name="userPassword" /> <br> <br>
			<button type="submit">Login</button>

		</form>
		<br> New User click here for <a href="RegistrationForm.jsp">Registration</a>
	</div>
</body>
</html>