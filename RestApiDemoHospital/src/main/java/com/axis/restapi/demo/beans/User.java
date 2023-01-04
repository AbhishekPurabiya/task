package com.axis.restapi.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "user_table")
public class User {

	@Id
	private int userId;
	private String username ;
	private String password ;
}
