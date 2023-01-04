package com.axis.restapi.demo.repository;



import com.axis.restapi.demo.beans.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
