package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Food;
import com.axis.fds.app.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImp implements IFoodService {

	@Autowired
	FoodRepository repo ;
	
	@Override
	public Food addFood(Food food) {
		// TODO Auto-generated method stub
		return repo.save(food);
	}

	@Override
	public Food updateFood(Food food) {
		// TODO Auto-generated method stub
		return repo.save(food);
	}

	@Override
	public List<Food> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Food getFoodById(int fid) {
		// TODO Auto-generated method stub
		return repo.findById(fid).orElse(null);
	}

	@Override
	public void deleteFoodById(int fid) {
		repo.deleteById(fid);
	}

}
