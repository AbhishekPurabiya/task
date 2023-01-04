package com.axis.medicare.service;

import java.time.LocalDate;
import java.util.List;

import com.axis.medicare.entity.Medicine;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IMedicineService {

	public abstract Medicine addMedicine(Medicine medicine);
	public abstract Medicine updateMedicine(Medicine medicine);
	public abstract ResponseEntity<String> deleteMedicine(int id);
	public abstract List<Medicine> getAllMedicine();
	public abstract Medicine getById(int id);
	public List<Medicine> findByName(String name);
	public List<Medicine> findByBrand(String brand) ;
	public List<Medicine> findByMfgDate(LocalDate mfgDate);
	public List<Medicine> findByExpDate(LocalDate expDate);
	public List<Medicine> findByPrice(double price);
}
