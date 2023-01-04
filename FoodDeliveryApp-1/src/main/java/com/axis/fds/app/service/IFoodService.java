package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Food;

import org.springframework.stereotype.Service;

@Service
public interface IFoodService {

	public abstract Food addFood(Food food);
	public abstract Food updateFood(Food food);
	public abstract List<Food> getAll();
	public abstract Food getFoodById(int fid);
	public abstract void deleteFoodById(int fid);

}
