package com.axis.fds.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "food_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username ;
	private String password ;
	private String contact ;
	private String address ;
	private String role = "user";
}
