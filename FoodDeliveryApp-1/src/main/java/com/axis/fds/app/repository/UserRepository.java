package com.axis.fds.app.repository;

import com.axis.fds.app.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(nativeQuery = true , value = "select * from food_user where USERNAME= :username AND PASSWORD= :password")
	public User checkUserCredential(@Param("username") String username , @Param("password") String password);
	
}
