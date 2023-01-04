package com.axis.medicare.service;

import java.util.List;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public abstract User addUser(User user);
	public abstract List<Medicine> getAll();
	public abstract List<Medicine> getByName(String name);
	public abstract List<Medicine> getByBrand(String brand);
	public abstract User getById(int id);
	public abstract boolean isValid(String username , String password);
	public abstract User findUser(String username , String password);
	
}
