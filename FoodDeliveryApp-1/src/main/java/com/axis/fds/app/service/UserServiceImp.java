package com.axis.fds.app.service;

import java.util.List;

import com.axis.fds.app.entity.Food;
import com.axis.fds.app.entity.User;
import com.axis.fds.app.repository.FoodRepository;
import com.axis.fds.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	UserRepository repo ;
	
	@Autowired
	FoodRepository foodRepo ;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	
	@Override
	public User getById(int uid) {
		// TODO Auto-generated method stub
		return repo.findById(uid).orElse(null);
	}

	@Override
	public boolean isValid(String username, String password) {
		User user = repo.checkUserCredential(username, password);
		if(user == null) {
			return false ;
		}
		return true ;
	}

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return repo.checkUserCredential(username, password);
	}
	
	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return foodRepo.findAll();
	}

	@Override
	public List<Food> getByFname(String fname) {
		// TODO Auto-generated method stub
		return foodRepo.findByFname(fname);
	}



	@Override
	public List<Food> getByCategory(String category) {
		// TODO Auto-generated method stub
		return foodRepo.findByCategory(category);
	}

	@Override
	public List<Food> getByPrice(double price) {
		// TODO Auto-generated method stub
		return foodRepo.findByPrice(price);
	}

}
