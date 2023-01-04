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
@Table(name = "food_cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid ;
	private String fname ;
	private int foodid ;
	private int userid ;
	
	private String category ;
	private double price ;
	private int quantity ;
	private String fimage;
	private String status ;
}
