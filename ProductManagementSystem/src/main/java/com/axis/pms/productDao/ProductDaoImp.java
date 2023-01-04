package com.axis.pms.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.axis.pms.beans.Product;

public class ProductDaoImp implements IProductDao {

	Connection con ;
	
	public ProductDaoImp() {
		
		con =  DBUtill.getDBConnection();
		
		}
	@Override
	public int addProduct(Product product) {
		int count = 0 ;
		try {
		PreparedStatement stm = con.prepareStatement("insert into Product(PRODUCTID, PRODUCTNAME , PRICE , DATEOFPURCHASE) values(?, ?,?,current_date)");
		stm.setInt(1, product.getProductId());
		stm.setString(2, product.getProductName());
		stm.setDouble(3, product.getProductPrice());
		
		count = stm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateProduct(Product product) {
		int count = 0 ;
		try {
		PreparedStatement stm = con.prepareStatement("update Product set PRODUCTNAME= ?, PRICE= ?, DATEOFPURCHASE= current_date+1 where PRODUCTID= ?");
		
		stm.setString(1, product.getProductName());
		stm.setDouble(2, product.getProductPrice());
		stm.setInt(3, product.getProductId());
		count = stm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteProduct(int productId) {
		int count = 0 ;
		try {
			PreparedStatement stm = con.prepareStatement("delete from Product where PRODUCTID= ?");
			stm.setInt(1, productId);
			count = stm.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return count;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = new Product();
		try {
			PreparedStatement stm = con.prepareStatement("select * from Product where PRODUCTID= ?");
			stm.setInt(1, productId);
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				
				
				product.setProductId(result.getInt("PRODUCTID"));
				product.setProductName(result.getString("PRODUCTNAME"));
				product.setProductPrice(result.getDouble("PRICE"));
				product.setDateOfPurchase(result.getString("DATEOFPURCHASE"));
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return product;
	}

	@Override
	public List<Product> viewAllProduct() {
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement stm = con.prepareStatement("select * from Product");
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				Product product = new Product();
				
				product.setProductId(result.getInt("PRODUCTID"));
				product.setProductName(result.getString("PRODUCTNAME"));
				product.setProductPrice(result.getDouble("PRICE"));
				product.setDateOfPurchase(result.getString("DATEOFPURCHASE"));
				
				list.add(product);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
	}

}
