package com.axis.fds.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodid ;
	private String fname ;
	private String category ;
	private double price ;
	private int quantity ;
	private String fimage;
	private String status ;
}
