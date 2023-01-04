<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.registration-form {
	display: flex;
	flex-direction: column;
	row-gap: 1cm;
	justify-content: center;
	align-content: center;
}
</style>
<body>
<div class="registration-form">
	<h2>Enter Your Details.....</h2>
	<br>
	<form action="RegistrationController.jsp" method="post">
			<lable>User Id : </lable>
			<input type="number" name="userId" /> <br> <br>
			<lable>User Name : </lable>
			<input type="text" name="userName" /> <br> <br>
			<lable>Set Password : </lable>
			<input type="text" name="userPassword" /> <br> <br>
			<lable>User Email : </lable>
			<input type="email" name="userEmail" /> <br> <br>
	<button type="submit">Register</button>
	</form>
</div>
</body>
</html>