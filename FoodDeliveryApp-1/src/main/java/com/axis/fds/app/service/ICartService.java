package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Cart;

public interface ICartService {

	public abstract Cart addToCart(Cart cart);
	public abstract List<Cart> getAllCart();
	public abstract List<Cart> getByUserId(int userid);
	public abstract void removeFromCart(int cid);
	public abstract Cart GetByCartId(int cid);
}
