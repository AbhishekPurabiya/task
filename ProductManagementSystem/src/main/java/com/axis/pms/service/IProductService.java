package com.axis.pms.service;

import java.util.List;

import com.axis.pms.beans.Product;

public interface IProductService {

	//add and update are logically same
	public abstract int addProduct(Product product);
	public abstract int updateProduct(Product product);
	
	//delete and select one is logically same
	public abstract int deleteProduct(int productId);
	public abstract Product getProductById(int productId);
	
	public abstract List<Product>  viewAllProduct();
}
