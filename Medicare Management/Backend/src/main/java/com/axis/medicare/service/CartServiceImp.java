package com.axis.medicare.service;

import java.util.List;

import com.axis.medicare.entity.UserCart;
import com.axis.medicare.repository.UserCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements ICartService {

	@Autowired
	UserCartRepository cartRepo ;
	
	
	@Override
	public UserCart addCart(UserCart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

	@Override
	public ResponseEntity<String> removeCart(int id) {
		cartRepo.deleteById(id);
		return new ResponseEntity<String>("Record Deleted from Cart.." , HttpStatus.OK);
	}

	@Override
	public List<UserCart> findByCid(int cid) {
		// TODO Auto-generated method stub
		return cartRepo.findByCid(cid);
	}

	@Override
	public UserCart findById(int id) {
		// TODO Auto-generated method stub
		return cartRepo.findById(id).orElse(null);
	}

	

}
