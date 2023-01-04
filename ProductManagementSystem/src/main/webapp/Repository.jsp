<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<jsp:useBean id="user" class="com.axis.pms.beans.User"
		scope="session"></jsp:useBean>

	<jsp:getProperty property="userId" name="user" />
	<jsp:getProperty property="userName" name="user" />
	<jsp:getProperty property="userPassword" name="user" />
	<jsp:getProperty property="userEmail" name="user" />

	<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:orcl" user="system"
		password="Abhi1234" />

	<c:catch var="catchtheException">
		<sql:update dataSource="${db}" var="count">  
		INSERT INTO Register (userId,userName,userPassword,userEmail) VALUES (?, ?, ?, ?)
			<sql:param value="${user.userId}" />
			<sql:param value="${user.userName}" />
			<sql:param value="${user.userPassword}" />
			<sql:param value="${user.userEmail}" />
		</sql:update>
	</c:catch>
	<c:if test="${catchtheException != null}">
	</c:if>

	<jsp:forward page="success.jsp"></jsp:forward>
</body>
</html>