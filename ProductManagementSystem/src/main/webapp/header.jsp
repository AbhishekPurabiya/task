<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="Home.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="AddProduct.jsp">Add Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="UpdateProduct.jsp">Update Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="ViewProduct.jsp">View All Product</a>
        </li>
        <li class="nav-item">
        	<form action="http://localhost:8080/ProductManagementSystem/ProductController">
          		<button class="btn btn-outline-danger" type="submit" name="action" value="logout">Logout</button>
        	</form>
        </li>
        
      </ul>
      <form class="d-flex" role="search" action="http://localhost:8080/ProductManagementSystem/ProductController">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="productId">
        <button class="btn btn-outline-success" type="submit" name="action" value="viewById">SearchById</button>
      </form>
    </div>
  </div>
</nav>


<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
</body>
</html>