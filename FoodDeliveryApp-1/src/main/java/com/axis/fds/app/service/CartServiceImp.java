package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Cart;
import com.axis.fds.app.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements ICartService {

	@Autowired
	CartRepository repo ;
	
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return repo.save(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void removeFromCart(int cid) {
		// TODO Auto-generated method stub
		repo.deleteById(cid);
	}

	@Override
	public List<Cart> getByUserId(int userid) {
		// TODO Auto-generated method stub
		return repo.findByUserid(userid);
	}

	@Override
	public Cart GetByCartId(int cid) {
		// TODO Auto-generated method stub
		return repo.findById(cid).orElse(null);
	}

}
