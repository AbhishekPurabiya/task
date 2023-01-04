package com.axis.pms.service;

import java.util.List;

import com.axis.pms.beans.Product;
import com.axis.pms.productDao.IProductDao;
import com.axis.pms.productDao.ProductDaoImp;

public class ProductServiceImp implements IProductService {

	private IProductDao dao;
	
	public ProductServiceImp() {
		this.dao = new ProductDaoImp();
	}
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.addProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return dao.getProductById(productId);
	}

	@Override
	public List<Product> viewAllProduct() {
		// TODO Auto-generated method stub
		return dao.viewAllProduct();
	}

}
