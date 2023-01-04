<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="com.axis.pms.beans.User" scope="session" ></jsp:useBean>

<jsp:setProperty property="userName" name="user" param="userName"/>
<jsp:setProperty property="userPassword" name="user" param="userPassword"/>

<jsp:forward page="Validation.jsp"></jsp:forward>
</body>
</html>