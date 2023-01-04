package com.axis.pms.beans;



public class Product {

	private int productId ;
	private String productName ;
	private double productPrice ;
	private String dateOfPurchase ;
	
	public Product() {
		super();
	}
	
	
	public Product(int productId, String productName, double productPrice, String dateOfPurchase) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.dateOfPurchase = dateOfPurchase;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", dateOfPurchase=" + dateOfPurchase + "]";
	}
	
	
}
