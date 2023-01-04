package com.axis.medicare.repository;



import com.axis.medicare.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery = true , value = "select * from medicine_user where USERNAME= :username AND PASSWORD= :password")
	public User checkUserCredential(@Param("username") String username , @Param("password") String password);
}
