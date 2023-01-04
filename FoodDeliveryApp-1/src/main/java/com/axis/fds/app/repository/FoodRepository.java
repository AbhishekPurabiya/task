package com.axis.fds.app.repository;

import java.util.List;

import com.axis.fds.app.entity.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "FoodRepository")
public interface FoodRepository extends JpaRepository<Food, Integer> {

	public List<Food> findByFname(String fname);
	public List<Food> findByCategory(String category);
	public List<Food> findByPrice(double price);
} 
