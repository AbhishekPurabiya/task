package com.axis.restapi.demo.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Hospital {

	@Id
	private int patientId ;
	private String patientName ;
	private String diseases ;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate admitDate ;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dischargeDate ;
	
}
