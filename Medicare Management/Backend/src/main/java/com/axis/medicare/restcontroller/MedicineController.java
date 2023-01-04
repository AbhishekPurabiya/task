package com.axis.medicare.restcontroller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.service.IMedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicare/v1/medicine")
public class MedicineController {

	@Autowired
	IMedicineService service ;
	
	@PostMapping("/add")
	public Medicine addDetails(@RequestBody Medicine medicine) {
		return service.addMedicine(medicine);
	}
	
	@PutMapping("/update")
	public Medicine updateDetails(@RequestBody Medicine medicine) {
		return service.updateMedicine(medicine);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDetails(@PathVariable("id") int id){
		return service.deleteMedicine(id);
	}
	
	@GetMapping("/get")
	public List<Medicine> getAll(){
		return service.getAllMedicine();
	}
	
	@GetMapping("/get/name/{name}")
	public List<Medicine> getByName(@PathVariable("name") String name){
		return service.findByName(name);
	}
	
	@GetMapping("/get/price/{price}")
	public List<Medicine> getByPrice(@PathVariable("price") double price){
		return service.findByPrice(price);
	}
	
	@GetMapping("/get/brand/{brand}")
	public List<Medicine> getByBrand(@PathVariable("brand") String brand){
		return service.findByBrand(brand);
	}
	
	@GetMapping("/get/mfgDate/{mfgDate}")
	public List<Medicine> getByMfgDate(@PathVariable("mfgDate") String mfgDate){
		LocalDate date = LocalDate.parse(mfgDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByMfgDate(date);
	}
	
	@GetMapping("/get/expDate/{expDate}")
	public List<Medicine> getByExpDate(@PathVariable("expDate") String expDate){
		LocalDate date = LocalDate.parse(expDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByExpDate(date);
	}
}
