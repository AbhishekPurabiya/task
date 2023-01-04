package com.axis.medicare.service;

import java.util.List;

import com.axis.medicare.entity.UserCart;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICartService {

	public abstract UserCart addCart(UserCart cart);
	public abstract ResponseEntity<String> removeCart(int id);
	public List<UserCart> findByCid(int cid);
	public UserCart findById(int id);
}
