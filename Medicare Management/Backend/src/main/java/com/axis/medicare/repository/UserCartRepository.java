package com.axis.medicare.repository;

import java.util.List;

import com.axis.medicare.entity.UserCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Integer> {

	public List<UserCart> findByCid(int cid);
}
