package com.axis.restapi.demo.service;

import com.axis.restapi.demo.beans.User;
import com.axis.restapi.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository repo ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user == null ) {
			throw new UsernameNotFoundException("User Not Found.....");
		}
		UserDetails userDetails = new UserDetailImp(user);
		return userDetails;
	}

}
