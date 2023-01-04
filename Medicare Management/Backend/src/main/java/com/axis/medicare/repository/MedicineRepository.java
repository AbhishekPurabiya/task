package com.axis.medicare.repository;

import java.time.LocalDate;
import java.util.List;

import com.axis.medicare.entity.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

	public List<Medicine> findByName(String name);
	public List<Medicine> findByBrand(String brand) ;
	public List<Medicine> findByMfgDate(LocalDate mfgDate);
	public List<Medicine> findByExpDate(LocalDate expDate);
	public List<Medicine> findByPrice(double price);
}
