<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include  page="header.jsp" />

<h1>View All Products Here </h1>

<form class="container col-md-4"  action="http://localhost:8080/ProductManagementSystem/ProductController" method="post">
 
<button type="submit"  class="btn btn-warning"   value="viewAll" name="action">Display Products</button>
</form>

<br>

<table class="table table-dark table-striped">
	<thead>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Product DOP</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productList}" var="product"  >
			<tr>
				<td>${product.productId}</td> 
				<td>${product.productName}</td>
			    <td>${product.productPrice}</td> 
			    <td>${product.dateOfPurchase}</td>
			    <td>
					<form class="container col-md-4"  action="http://localhost:8080/ProductManagementSystem/ProductController" method="post">
						 <input type="hidden"  value="${product.productId}" name="productId" />
						 
						<button type="submit"  class="btn btn-danger"   value="delete" name="action">Delete</button>
					</form>
				</td>
	      </tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>