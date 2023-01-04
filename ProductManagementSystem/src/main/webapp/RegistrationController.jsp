<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="com.axis.pms.beans.User"  scope="session" ></jsp:useBean>

<jsp:setProperty property="userId" name="user" param="userId"/>
<jsp:setProperty property="userName" name="user" param="userName"/>
<jsp:setProperty property="userPassword" name="user" param="userPassword"/>
<jsp:setProperty property="userEmail" name="user" param="userEmail"/>

<jsp:forward page="Repository.jsp"></jsp:forward>
</body>
</html>