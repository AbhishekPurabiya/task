package com.axis.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axis.pms.beans.Product;
import com.axis.pms.service.IProductService;
import com.axis.pms.service.ProductServiceImp;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductService service;

	public ProductController() {
		super();
		this.service = new ProductServiceImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		switch (action) {
			case "add": {
				Product product = new Product();
				product.setProductId(Integer.parseInt(request.getParameter("productId")));
				product.setProductName(request.getParameter("productName"));
				product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));

				int count = service.addProduct(product);

				if (count > 0) {
					out.println("<h1>Details Added Successfully....</h1>");
				} else {
					out.println("<h1>Failed.....can't Add Details</h1>");
				}
				break;
			}
			case "update": {
				Product product = new Product();
				product.setProductId(Integer.parseInt(request.getParameter("productId")));
				product.setProductName(request.getParameter("productName"));
				product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));

				int count = service.updateProduct(product);

				if (count > 0) {
					out.println("<h1>Details Updated Successfully....</h1>");
				} else {
					out.println("<h1>Failed.....can't Add Details</h1>");
				}
				break;
			}
			case "viewAll": {
				List<Product> productList = service.viewAllProduct();

				session.setAttribute("productList", productList);

				RequestDispatcher rd = request.getRequestDispatcher("ViewProduct.jsp");

				rd.include(request, response);

				break;
			}
			case "viewById": {
				int searchId = Integer.parseInt(request.getParameter("productId"));

				Product searchedProduct = service.getProductById(searchId);

				session.setAttribute("productDetails", searchedProduct);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("Home.jsp");
				reqDispatcher.include(request, response);

				break;
			}
			case "delete": {
				int deleteId = Integer.parseInt(request.getParameter("productId"));

				int count2 = service.deleteProduct(deleteId);

				

				if (count2 > 0) {
					out.print("<h1 style='color:green'> Product Deleted Successfully </h1>");

				} else {

					out.print("<h2 style='color:red'>Delete Operation Failed...</h2>");

				}

				break;
			}
			case "logout" : {
				HttpSession session1 = request.getSession();
				session1.invalidate();
				response.sendRedirect("Login.jsp");
				break ;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
