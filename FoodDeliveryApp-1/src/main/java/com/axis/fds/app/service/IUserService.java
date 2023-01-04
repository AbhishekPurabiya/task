package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Food;
import com.axis.fds.app.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public abstract User addUser(User user);
	public abstract List<Food> getAllFood();
	public abstract List<Food> getByFname(String fname);
	public abstract List<Food> getByCategory(String category);
	public abstract List<Food> getByPrice(double price);
	
	
	public abstract User getById(int uid);
	public abstract boolean isValid(String username , String password);
	public abstract User findUser(String username , String password);
}
