package com.axis.restapi.demo.controller;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.axis.restapi.demo.beans.Hospital;
import com.axis.restapi.demo.exception.PatientNotFountException;
import com.axis.restapi.demo.service.IHospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/patient/general/")
public class HospitalController {

	@Autowired
	IHospitalService service ;
	
	
	@PostMapping("/add")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		
		return service.addPatient(hospital);
	}
	
	@PutMapping("/update")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		
		return service.updatePatient(hospital);
	}
	
	@GetMapping("/get")
	public List<Hospital> getAll(){
		return service.getAllPatient();
	}
	
	@GetMapping("/get/{patientId}")
	public Hospital getOne(@PathVariable("patientId") int id)  {
		return service.getPatientById(id);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<String> delete(@PathVariable("patientId") int id){
		return service.deletePatient(id);
	}
	
	@GetMapping("/get/name/{patientName}")
	public List<Hospital> getByName(@PathVariable("patientName") String name){
		return service.findByPatientName(name);
	}
	
	@GetMapping("/get/diseases/{diseases}")
	public List<Hospital> getByDiseases(@PathVariable("diseases") String diseases){
		return service.findByDiseases(diseases);
	}
	
	@GetMapping("/get/admit/{admitDate}")
	public List<Hospital> getByAdmitDate(@PathVariable("admitDate") String admitDate){
		LocalDate date = LocalDate.parse(admitDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByAdmitDate(date);
	}
	
	@GetMapping("/get/discharge/{dischargeDate}")
	public List<Hospital> getByDischargeDate(@PathVariable("dischargeDate") String dischargeDate){
		LocalDate date = LocalDate.parse(dischargeDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByDischargeDate(date);
	}
	
	@GetMapping("/get/sort/id")
	public List<Hospital> sortById(){
		return service.findByOrderByPatientId();
	}
	
	@DeleteMapping("/delete/name/{patientName}")
	public ResponseEntity<String> deleteByName(@PathVariable("patientName") String name) {
		return service.deleteByPatientName(name);
	}
	
	@DeleteMapping("/delete/diseases/{diseases}")
	public ResponseEntity<String> deleteByDiseases(@PathVariable("diseases") String diseases) {
		return service.deleteByDiseases(diseases);
	}
	
	@DeleteMapping("/delete/admit/{admitDate}")
	public ResponseEntity<String> deleteByAD(@PathVariable("admitDate") String admitDate) {
		LocalDate date = LocalDate.parse(admitDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.deleteByAdmitDate(date);
	}
	
	@DeleteMapping("/delete/discharge/{dischargeDate}")
	public ResponseEntity<String> deleteByDD(@PathVariable("dischargeDate") String dischargeDate) {
		LocalDate date = LocalDate.parse(dischargeDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.deleteByDischargeDate(date);
	}
	
	@PutMapping("/update/name/{patientName}")
	public ResponseEntity<String> updateByName(@RequestBody Hospital hospital ,@PathVariable("patientName") String patientName) {
		return service.updateByPatientName(hospital, patientName);
	}
	
	@PutMapping("/update/diseases/{diseases}")
	public ResponseEntity<String> updateByDiseases(@RequestBody Hospital hospital ,@PathVariable("diseases") String diseases) {
		return service.updateByDiseases(hospital, diseases);
	}
	
	@GetMapping("/get/admit/{admitDate1}/{admitDate2}")
	public List<Hospital> getBetweenAdmitDate(@PathVariable("admitDate1") String admitDate1 , @PathVariable("admitDate2") String admitDate2){
		LocalDate date = LocalDate.parse(admitDate1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		
		LocalDate date1 = LocalDate.parse(admitDate2);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date1);
		
		return service.findByAdmitDateRange(date, date1);
	}
	
	@GetMapping("/get/discharge/{dischargeDate1}/{dischargeDate2}")
	public List<Hospital> getBetweenDischargeDate(@PathVariable("dischargeDate1") String dischargeDate1 , @PathVariable("dischargeDate2") String dischargeDate2){
		LocalDate date = LocalDate.parse(dischargeDate1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		
		LocalDate date1 = LocalDate.parse(dischargeDate2);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date1);
		
		return service.findByDischargeDateRange(date, date1);
	}
	
	@GetMapping("/get/admit/afetr/{admitDate}")
	public List<Hospital> getAfterAdmitDate(@PathVariable("admitDate") String admitDate){
		LocalDate date = LocalDate.parse(admitDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByAfterAdmitDate(date);
	}
	
	@GetMapping("/get/admit/before/{admitDate}")
	public List<Hospital> getBeforeAdmitDate(@PathVariable("admitDate") String admitDate){
		LocalDate date = LocalDate.parse(admitDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByBeforeAdmitDate(date);
	}
	
	@GetMapping("/get/discharge/afetr/{dischargeDate}")
	public List<Hospital> getAfterDischargeDate(@PathVariable("dischargeDate") String dischargeDate){
		LocalDate date = LocalDate.parse(dischargeDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByAfterDischargeDate(date);
	}
	
	@GetMapping("/get/discharge/before/{dischargeDate}")
	public List<Hospital> getBeforeDischargeDate(@PathVariable("dischargeDate") String dischargeDate){
		LocalDate date = LocalDate.parse(dischargeDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		formatter.format(date);
		return service.findByBeforeDischargeDate(date);
	}
	
	@GetMapping("/get/name/sort-asc")
	public List<Hospital> getSortByNameAsc(){
		return service.sortByNameAsc();
	}
	
	@GetMapping("/get/name/sort-dsc")
	public List<Hospital> getSortByNameDsc(){
		return service.sortByNameDsc();
	}
	
	@GetMapping("/get/admit/sort-asc")
	public List<Hospital> getSortByAdmitDateAsc(){
		return service.sortByAdmitDateAsc();
	}
	
	@GetMapping("/get/admit/sort-dsc")
	public List<Hospital> getSortByAdmitDateDsc(){
		return service.sortByAdmitDateDsc();
	}
	
	@GetMapping("/get/discharge/sort-asc")
	public List<Hospital> getSortByDischargeDateAsc() {
		return service.sortByDischargeDateAsc();
	}
	
	@GetMapping("/get/discharge/sort-dsc")
	public List<Hospital> getSortByDischargeDateDsc() {
		return service.sortByDischargeDateAsc();
	}
	
	@GetMapping("/get/paging")
	public Page<Hospital> getPaging(){
		return service.getPagingList();
	}
}
