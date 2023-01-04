package com.axis.fds.app.repository;

import java.util.List;

import com.axis.fds.app.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "CartRepository")
public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByUserid(int userid);
}
