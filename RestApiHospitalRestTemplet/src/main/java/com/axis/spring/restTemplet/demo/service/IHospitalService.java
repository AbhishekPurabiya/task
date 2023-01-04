package com.axis.spring.restTemplet.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.axis.spring.restTemplet.demo.beans.Hospital;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IHospitalService {

	public abstract Hospital addPatient(Hospital hospital);
	public abstract Hospital updatePatient(Hospital hospital);
	public abstract Hospital getPatientById(int id);
	public abstract ResponseEntity<String> deletePatient(int id);
	public abstract List<Hospital> getAllPatient();
	
	public abstract List<Hospital> findByPatientName(String patientName);
	public abstract List<Hospital> findByDiseases(String diseases);
	public abstract List<Hospital> findByAdmitDate(LocalDate admitDate);
	public abstract List<Hospital> findByDischargeDate(LocalDate dischargeDate);
	public abstract List<Hospital> findByOrderByPatientId(); 
	public abstract List<Hospital> findByAdmitDateRange(LocalDate date1 , LocalDate date2);
	public abstract List<Hospital> findByDischargeDateRange(LocalDate date1 , LocalDate date2);
	public abstract List<Hospital> findByAfterAdmitDate(LocalDate date1);
	public abstract List<Hospital> findByBeforeAdmitDate(LocalDate date1);
	public abstract List<Hospital> findByAfterDischargeDate(LocalDate date1);
	public abstract List<Hospital> findByBeforeDischargeDate(LocalDate date1);
	
	public abstract ResponseEntity<String> deleteByPatientName(String patientName);
	public abstract ResponseEntity<String> deleteByDiseases(String diseases);
	public abstract ResponseEntity<String> deleteByAdmitDate(LocalDate admitDate);
	public abstract ResponseEntity<String> deleteByDischargeDate(LocalDate dischargeDate);
	
	public abstract ResponseEntity<String> updateByPatientName(Hospital hospital, String patientName);
	public abstract ResponseEntity<String> updateByDiseases(Hospital hospital, String diseases);
	
	public abstract List<Hospital> sortByNameAsc();
	public abstract List<Hospital> sortByNameDsc();
	public abstract List<Hospital> sortByAdmitDateAsc();
	public abstract List<Hospital> sortByAdmitDateDsc();
	public abstract List<Hospital> sortByDischargeDateAsc();
	public abstract List<Hospital> sortByDischargeDateDsc();
	public Page<Hospital> getPagingList();
	
}
