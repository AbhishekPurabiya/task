package com.axis.medicare.service;

import java.time.LocalDate;
import java.util.List;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImp implements IMedicineService {

	@Autowired
	MedicineRepository repo ;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		
		return repo.save(medicine);
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return repo.save(medicine);
	}

	@Override
	public ResponseEntity<String> deleteMedicine(int id) {
		repo.deleteById(id);
		return new ResponseEntity<String>("Record Deleted Successfully...." , HttpStatus.OK);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		
		return repo.findAll();
	}

	@Override
	public List<Medicine> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Medicine> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return repo.findByBrand(brand);
	}

	@Override
	public List<Medicine> findByMfgDate(LocalDate mfgDate) {
		// TODO Auto-generated method stub
		return repo.findByMfgDate(mfgDate);
	}

	@Override
	public List<Medicine> findByExpDate(LocalDate expDate) {
		// TODO Auto-generated method stub
		return repo.findByExpDate(expDate);
	}

	@Override
	public List<Medicine> findByPrice(double price) {
		// TODO Auto-generated method stub
		return repo.findByPrice(price);
	}

	@Override
	public Medicine getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

}
