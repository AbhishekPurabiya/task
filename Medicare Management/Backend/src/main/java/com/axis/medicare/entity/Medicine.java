package com.axis.medicare.entity;

import java.time.LocalDate;

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
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name ;
	private String brand ;
	private double price ;
	private String description ;
	private LocalDate mfgDate ;
	private LocalDate expDate ;
	
}
