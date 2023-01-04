package com.axis.spring.restTemplet.demo.service;

import java.time.LocalDate;

import java.util.List;

import com.axis.spring.restTemplet.demo.beans.Hospital;
import com.axis.spring.restTemplet.demo.repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImp implements IHospitalService{

	@Autowired
	HospitalRepository repo ;
	

	
	@Override
	public Hospital addPatient(Hospital hospital) {
		return repo.save(hospital);
	}

	@Override
	public Hospital updatePatient(Hospital hospital) {
		return repo.save(hospital);
	}

	@Override
	public Hospital getPatientById(int id) {
		return repo.findById(id).orElseThrow(null);
			
	}

	@Override
	public ResponseEntity<String> deletePatient(int id) {
		repo.deleteById(id);
		return new ResponseEntity<String>("Patient Record Deleted Successfully...." , HttpStatus.OK);
	}

	@Override
	public List<Hospital> getAllPatient() {
		return repo.findAll();
	}

	@Override
	public List<Hospital> findByPatientName(String patientName) {
		return repo.findByPatientName(patientName);
	}

	@Override
	public List<Hospital> findByDiseases(String diseases) {
		return repo.findByDiseases(diseases);
	}

	@Override
	public List<Hospital> findByAdmitDate(LocalDate admitDate) {
		return repo.findByAdmitDate(admitDate);
	}

	@Override
	public List<Hospital> findByDischargeDate(LocalDate dischargeDate) {
		return repo.findByDischargeDate(dischargeDate);
	}

	@Override
	public ResponseEntity<String> deleteByPatientName(String patientName) {
		repo.deleteByPatientName(patientName);
		return new ResponseEntity<String>("Record Deleted Successfully" , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteByDiseases(String diseases) {
		repo.deleteByDiseases(diseases);
		return new ResponseEntity<String>("Record Deleted Successfully" , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteByAdmitDate(LocalDate admitDate) {
		repo.deleteByAdmitDate(admitDate);
		return new ResponseEntity<String>("Record Deleted Successfully" , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteByDischargeDate(LocalDate dischargeDate) {
		repo.deleteByDischargeDate(dischargeDate);
		return new ResponseEntity<String>("Record Deleted Successfully" , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String>  updateByPatientName(Hospital hospital ,String patientName) {
		repo.updateByPatientName(hospital, patientName);
		return new ResponseEntity<String>("Record Updated Successfully" , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String>  updateByDiseases(Hospital hospital, String diseases) {
		repo.updateByDiseases(hospital, diseases);
		return new ResponseEntity<String>("Record Updated Successfully" , HttpStatus.OK);
	}

	@Override
	public List<Hospital> findByOrderByPatientId() {
		// TODO Auto-generated method stub
		return repo.findByOrderByPatientId();
	}

	@Override
	public List<Hospital> findByAdmitDateRange(LocalDate date1, LocalDate date2) {
		// TODO Auto-generated method stub
		return repo.findByAdmitDateRange(date1, date2);
	}

	@Override
	public List<Hospital> findByDischargeDateRange(LocalDate date1, LocalDate date2) {
		// TODO Auto-generated method stub
		return repo.findByDischargeDateRange(date1, date2);
	}

	@Override
	public List<Hospital> findByAfterAdmitDate(LocalDate date1) {
		// TODO Auto-generated method stub
		return repo.findByAfterAdmitDate(date1);
	}

	@Override
	public List<Hospital> findByBeforeAdmitDate(LocalDate date1) {
		// TODO Auto-generated method stub
		return repo.findByBeforeAdmitDate(date1);
	}

	@Override
	public List<Hospital> findByAfterDischargeDate(LocalDate date1) {
		// TODO Auto-generated method stub
		return repo.findByAfterDischargeDate(date1);
	}

	@Override
	public List<Hospital> findByBeforeDischargeDate(LocalDate date1) {
		// TODO Auto-generated method stub
		return repo.findByBeforeDischargeDate(date1);
	}
	
	@Override
	public List<Hospital> sortByNameAsc(){
		return repo.findAll(Sort.by("patientName").ascending());
	}
	
	@Override
	public List<Hospital> sortByNameDsc(){
		return repo.findAll(Sort.by("patientName").descending());
	}
	
	@Override
	public List<Hospital> sortByAdmitDateAsc(){
		return repo.findAll(Sort.by("admitDate").ascending());
	}
	
	@Override
	public List<Hospital> sortByAdmitDateDsc(){
		return repo.findAll(Sort.by("admitDate").descending());
	}
	
	@Override
	public List<Hospital> sortByDischargeDateAsc(){
		return repo.findAll(Sort.by("dischargeDate").ascending());
	}
	
	@Override
	public List<Hospital> sortByDischargeDateDsc(){
		return repo.findAll(Sort.by("dischargeDate").descending());
	}
	
	@Override
	public Page<Hospital> getPagingList(){
		return  repo.findAll(Pageable.ofSize(2));
	}
	
	
	
}
