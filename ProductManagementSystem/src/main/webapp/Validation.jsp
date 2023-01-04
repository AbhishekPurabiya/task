<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.Statement, java.sql.Connection"%>
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

	<jsp:getProperty property="userName" name="user" />
	<jsp:getProperty property="userPassword" name="user" />

	
		<% String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String us = "system";
		String pass = "Abhi1234";
		
		try{
			//register the drier class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//make the connection
			Connection con = DriverManager.getConnection(url, us, pass);
			//make the statement
			PreparedStatement stm = con.prepareStatement("select * from Register where USERNAME= ? And USERPASSWORD= ?");
			stm.setString(1, username);
			stm.setString(2, password);
			//execute the query
			ResultSet result = stm.executeQuery();
			
			if(result.next()) {
				
					HttpSession session1 = request.getSession();
					
					session1.setAttribute("Username", username);
					%>
					<jsp:forward page="Home.jsp"></jsp:forward>
			<% 	}else{
				%>
				<jsp:forward page="UserWrong.jsp"></jsp:forward>
			<%}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
		
</body>
</html>