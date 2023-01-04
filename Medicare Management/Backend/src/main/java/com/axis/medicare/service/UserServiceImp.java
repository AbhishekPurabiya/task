package com.axis.medicare.service;

import java.util.List;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.entity.User;
import com.axis.medicare.repository.CustomerRepository;
import com.axis.medicare.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	MedicineRepository medicineRepo ;
	
	@Autowired
	CustomerRepository userRepo ;
	
	@Override
	public List<Medicine> getAll() {
		// TODO Auto-generated method stub
		return medicineRepo.findAll();
	}

	@Override
	public List<Medicine> getByName(String name) {
		// TODO Auto-generated method stub
		return medicineRepo.findByName(name);
	}

	@Override
	public List<Medicine> getByBrand(String brand) {
		// TODO Auto-generated method stub
		return medicineRepo.findByBrand(brand);
	}
	
	@Override
	public boolean isValid(String username , String password) {
		User user = userRepo.checkUserCredential(username, password);
		if(user == null) {
			return false ;
		}
		return true ;
	}
	
	@Override
	public User findUser(String username , String password) {
		return userRepo.checkUserCredential(username, password);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElse(null);
	}

}
