package com.axis.medicare.entity;

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
@Table(name = "medicine_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String username ;
	private String password ;
	private String role = "user";
}
